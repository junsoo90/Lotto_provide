package Lotto;

import java.util.ArrayList;

import Lotto_Number.Lotto_number;
import Lotto_Provide.Lotto_provide;
import Lotto_Provide.Lotto_provide_num;
import Lotto__parse.Lotto_json;
import Lotto__parse.Lotto_json_process;

public class Lotto_process {

	private Lotto_json lottojson;

	private Lotto_number lottonum;

	public Lotto_process() {
		lottonum = new Lotto_number();
		lottojson = new Lotto_json_process();
	}

	public void lottoprovide() {
		Lotto_provide lottoprovide = new Lotto_provide_num(); 
		lottojson.first_list_add(); // 로또번호 최신으로 업데이트 ( json 파일 쓰기 )

		ArrayList readlist = lottojson.read(); // 로또번호 읽기 ( 파일 읽기 )

		lottonum = lotto_analysis(lottoprovide, readlist); // 로또번호 분석결과 저장
	}
	
	public Lotto_number lotto_analysis(Lotto_provide lottoprovide, ArrayList readlist) {
																// 분석 방법에 따라 결과 리턴
		return lottoprovide.result(readlist);
	}

	public int[] getLottonum() {
		return lottonum.getLottonum();
	}

}
