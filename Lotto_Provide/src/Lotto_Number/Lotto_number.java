package Lotto_Number;

public class Lotto_number {

	private int lottonum[];

	public Lotto_number() {
		lottonum = new int[7];
	}

	public int[] getLottonum() {
		return this.lottonum;
	}

	public int getLottonum(int index) {
		return this.lottonum[index];
	}

	public void setLottonum(int num, int index) {
		this.lottonum[index] = num;
	}

	public void setLottonum(int[] lottonum) {
		this.lottonum = lottonum;
	}
}
