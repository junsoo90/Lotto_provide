package Lotto_Number;

public class Lotto_select_number {

	private int select[];
	private int select_bns[];
	private int cnt;
	private int cnt_bns;

	public Lotto_select_number(int n) {
		select = new int[n];
		select_bns = new int[n];
	}

	public int getSelect_bns(int n) {
		return select_bns[n];
	}

	public int getSelct(int n) {
		return select[n];
	}

	public int[] getSelect() {
		return select;
	}

	public void setSelect(int num, int index) {
		this.select[index] = num;
	}

	public int[] getSelect_bns() {
		return select_bns;
	}

	public void setSelect_bns(int num, int index) {
		this.select_bns[index] = num;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getCnt_bns() {
		return cnt_bns;
	}

	public void setCnt_bns(int cnt_bns) {
		this.cnt_bns = cnt_bns;
	}

}
