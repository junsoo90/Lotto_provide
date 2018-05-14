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
		lottojson.first_list_add(); // �ζǹ�ȣ �ֽ����� ������Ʈ ( json ���� ���� )

		ArrayList readlist = lottojson.read(); // �ζǹ�ȣ �б� ( ���� �б� )

		lottonum = lotto_analysis(lottoprovide, readlist); // �ζǹ�ȣ �м���� ����
	}
	
	public Lotto_number lotto_analysis(Lotto_provide lottoprovide, ArrayList readlist) {
																// �м� ����� ���� ��� ����
		return lottoprovide.result(readlist);
	}

	public int[] getLottonum() {
		return lottonum.getLottonum();
	}

}
