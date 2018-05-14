package Lotto_analysis;

import java.util.ArrayList;

import Lotto_Number.Lotto_select_number;
import Lotto_Number.Lotto_weigh_number;

public class Lotto_analysis_num implements Lotto_analysis {
	private final int LOTTO = 46;

	private Lotto_select_number select;
	private Lotto_weigh_number wei;

	public Lotto_analysis_num() {
		select = new Lotto_select_number(LOTTO);
		wei = new Lotto_weigh_number(LOTTO);
	}

	public Lotto_weigh_number lotto_weight(ArrayList lottolist) {
		for (int i = 0; i < lottolist.size(); i++) { // 가중치
			int temp[] = (int[]) lottolist.get(i);

			wei.setWeight_bns(wei.getWeight_bns(temp[6]) + 1, temp[6]);
			for (int j = 0; j < 6; j++) {

				wei.setWeight(wei.getWeight(temp[j]) + 1, temp[j]);
			}
		}

		return wei;

	}

	public Lotto_select_number lotto_select(ArrayList lottolist) {
		int cnt = 0, cnt_bns = 0;
		for (int i = 1; i < LOTTO; i++) { // 가중치에 따른 로또번호 선택
			if (wei.getWeight(i) == 0) {
				select.setCnt(cnt++);
				select.setSelect(i, select.getCnt());
			}

			if (wei.getWeight_bns(i) == 0) {
				select.setCnt_bns(cnt_bns++);
				select.setSelect_bns(i, select.getCnt_bns());
			}
		}
		System.out.println();
		return select;
	}
}
