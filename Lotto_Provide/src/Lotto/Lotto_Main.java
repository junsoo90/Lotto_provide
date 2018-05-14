package Lotto;

import Lotto_Number.Lotto_number;
import Lotto_Provide.Lotto_provide;
import Lotto_Provide.Lotto_provide_num;

public class Lotto_Main {

	public static void main(String[] args) {

		Lotto_process lottoprocess = new Lotto_process();
		lottoprocess.lottoprovide();

		int[] arr = lottoprocess.getLottonum();
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
