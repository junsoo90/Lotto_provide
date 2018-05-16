package Lotto;

import java.util.ArrayList;

import Lotto_Number.Lotto_number;
import Lotto_Provide.Lotto_provide;
import Lotto_Provide.Lotto_provide_num;
import Lotto_parse.Lotto_json;
import Lotto_parse.Lotto_json_process;

public class Lotto_process {

	private Lotto_json lottojson;

	private Lotto_number lottonum;
	private Lotto_provide lottoprovide;

	public Lotto_process() {

		lottonum = new Lotto_number();
		lottojson = new Lotto_json_process();
	}

	public void lottoprovide() {
		lottoprovide = new Lotto_provide_num();
		lottojson.lotto_info(); // �ζǹ�ȣ �ֽ����� ������Ʈ ( json ���� ���� )

		ArrayList readlist = lottojson.lotto_read(); // �ζǹ�ȣ �б� ( ���� �б� )

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
