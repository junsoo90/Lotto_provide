package Lotto__parse;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import Lotto_Number.Lotto_number;

public class Lotto_json_process implements Lotto_json {

	private final int turn = 795; // 800회 이후 로또번호 추출
	private final int LOTTO = 45;

	private JSONArray lottojson;
	private JSONParser parser;
	private JSONObject object;

	private InputStreamReader isr;

	private Lotto_number lottonumber;
	private ArrayList lottoarray;

	public Lotto_json_process() {
		lottonumber = new Lotto_number();
		parser = new JSONParser();
		lottoarray = new ArrayList();
	}

	public void first_list_add() { // 로또번호 저장 ( json )
		URL result;

		int addturn = turn;

		lottojson = new JSONArray();
		try {

			while (true) { // turn 회차 이후 로또번호 저장 

				result = new URL("http://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=" + addturn);

				isr = new InputStreamReader(result.openConnection().getInputStream());

				object = (JSONObject) JSONValue.parse(isr);

				if ("success".equals(object.get("returnValue"))) { // 로또 번호 콘솔 출력
					System.out.print(addturn + "회차 로또 번호 :");
					for (int i = 1; i <= 6; i++) {
						System.out.print(" " + object.get("drwtNo" + i));
					}
					System.out.println(" (보너스 : " + object.get("bnusNo") + ")");

				} else {
					System.out.println(addturn + "회차 로또 정보 읽기를 실패하였습니다.");
					break;
				}
				lottojson.add(object);
				addturn++;

			}

			object.clear();
			isr.close();
			
			System.out.println("=======================================================");
			System.out.println("로또번호 가져오기 완료\n");

			FileWriter writer = new FileWriter("Lotto_Info\\lottoinfo.json");
			writer.write(lottojson.toString());
			writer.close();

			System.out.println("=======================================================");
			System.out.println("json 저장 완료");
			System.out.println("=======================================================\n");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList read() {
		System.out.println("=======================================================");

		System.out.println("읽기 시작\n");
		try {
			System.out.println("json start");

			JSONArray lottotemp = (JSONArray) parser.parse(new FileReader("Lotto_Info\\lottoinfo.json"));

			for (int i = 0; i < lottotemp.size(); i++) { // json 파일 로또번호 가져오기
				int[] lotto_temp = new int[7];
				JSONObject json_temp = (JSONObject) lottotemp.get(i);

				lotto_temp[lotto_temp.length - 1] = Integer.parseInt(json_temp.get("bnusNo").toString()); // 보너스번호

				for (int j = 1; j < 7; j++) {
					lotto_temp[j - 1] = Integer.parseInt(json_temp.get("drwtNo" + j).toString()); // 로또 6개 번호

				}

				for (int j = 0; j < lotto_temp.length; j++)
					System.out.print(lotto_temp[j] + " ");
				System.out.println();

				lottoarray.add(lotto_temp);

			}

			System.out.println("리스트 종료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("=======================================================");
		System.out.println("읽기 종료");
		System.out.println("=======================================================\n");

		return lottoarray;
	}

}
