package Lotto_Provide;

import java.util.ArrayList;
import java.util.Random;

import Lotto_Number.Lotto_number;
import Lotto_Number.Lotto_select_number;
import Lotto_Number.Lotto_weigh_number;
import Lotto_analysis.Lotto_analysis;
import Lotto_analysis.Lotto_analysis_num;

public class Lotto_provide_num implements Lotto_provide {

	private final int LOTTO = 46;

	private Lotto_number lottoresult; // 로또번호 결과

	private Lotto_analysis lottoanalysis;

	private Lotto_select_number selectnum;
	private Lotto_weigh_number weinum;

	public Lotto_provide_num() {
		lottoresult = new Lotto_number();

		lottoanalysis = new Lotto_analysis_num();

	}

	public Lotto_number result(ArrayList lottolist) {
		System.out.println("=======================================================");
		System.out.println("데이터 추출 시작\n");

		System.out.println(lottolist);

		weinum = lottoanalysis.lotto_weight(lottolist); // 가중치 분석
		selectnum = lottoanalysis.lotto_select(lottolist); // 하나도 안나온 번호 중 6자리 선택

		for (int i = 1; i < LOTTO; i++) {
			System.out.print(weinum.getWeight(i) + " ");
			if (i % 10 == 0)
				System.out.println();
		}

		System.out.println();
		System.out.println("==================  6자리 번호  ==================");

		for (int i = 0; i < selectnum.getCnt(); i++) {
			System.out.print(selectnum.getSelct(i) + " ");
		}
		
		System.out.println();
		System.out.println("==================  보너스 번호  ==================");
		for (int i = 0; i < selectnum.getCnt_bns(); i++) {
			System.out.print(selectnum.getSelect_bns(i) + " ");
		}
		System.out.println();
		System.out.println("==================  보너스 번호   가중치 ==================");

		for (int i = 1; i < LOTTO; i++) {
			System.out.print(weinum.getWeight_bns(i) + " ");
			if (i % 10 == 0)
				System.out.println();
		}
		System.out.println();
		
		lottoresult = last_provide();
		
		return lottoresult;
	}

	public Lotto_number last_provide() {
		int rot = 0, lottocnt = 0, bns = 0;
		for (int i = 1; i <= 45; i++) { // 보너스번호 선택

			if (bns <= weinum.getWeight_bns(i))
				bns = i;
		}
		
		while (rot < 6) {
			sort(selectnum.getSelect(), 0, selectnum.getCnt() - 1);

			Random random = new Random();

			int temp = random.nextInt(LOTTO - selectnum.getCnt());
			System.out.print(temp + " ");

			System.out.println(lottosearch(selectnum.getSelect(), temp, 0, selectnum.getCnt() - 1));

			if (!lottosearch(selectnum.getSelect(), temp, 0, selectnum.getCnt() - 1) && temp != 0
					&& !lottosearch(lottoresult.getLottonum(), temp, 0, lottocnt - 1)) {

				lottoresult.setLottonum(temp, lottocnt++);
				rot++;

			}
			sort(lottoresult.getLottonum(), 0, lottocnt - 1);
		}

		lottoresult.setLottonum(bns, lottocnt++);

		for (int i = 0; i < lottocnt; i++) {

			if (i == lottoresult.getLottonum().length - 1) {
				System.out.print("[" + lottoresult.getLottonum(i) + "]");
				break;
			}
			System.out.print(lottoresult.getLottonum(i) + " ");
		}

		System.out.println();

		System.out.println("=======================================================");
		System.out.println("데이터 추출 종료");
		System.out.println("=======================================================\n");

		return lottoresult;
	}

	public boolean lottosearch(int arr[], int num, int left, int right) { // 로또번호 탐색
		if (left > right)
			return false;
		int mid = (left + right) / 2;

		if (arr[mid] == num)
			return true;
		else if (arr[mid] > num)
			return lottosearch(arr, num, left, mid - 1);
		else
			return lottosearch(arr, num, mid + 1, right);

	}

	public void mergeSort(int arr[], int left, int right, int mid) {
		int temp[] = new int[arr.length];

		int l = left;
		int r = mid + 1;
		int t = left;

		while (l <= mid && r <= right) {
			if (arr[l] > arr[r])
				temp[t++] = arr[r++];
			else
				temp[t++] = arr[l++];
		}

		while (l <= mid)
			temp[t++] = arr[l++];
		while (r <= right)
			temp[t++] = arr[r++];

		for (int i = left; i <= right; i++)
			arr[i] = temp[i];

	}

	public void sort(int arr[], int left, int right) {
		if (left >= right)
			return;

		int mid = (left + right) / 2;

		sort(arr, left, mid);
		sort(arr, mid + 1, right);
		mergeSort(arr, left, right, mid);

	}
}
