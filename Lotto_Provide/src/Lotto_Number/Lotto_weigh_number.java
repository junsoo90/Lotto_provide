package Lotto_Number;

public class Lotto_weigh_number {

	private int weight[];
	private int weight_bns[];

	public Lotto_weigh_number(int n) {
		weight = new int[n];
		weight_bns = new int[n];
	}

	
	
	public int getWeight(int n) {
		return weight[n];
	}

	public int getWeight_bns(int n) {
		return weight_bns[n];
	}

	public int[] getWeight() {
		return weight;
	}

	public void setWeight(int num, int index) {
		this.weight[index] = num;
	}

	public int[] getWeight_bns() {
		return weight_bns;
	}

	public void setWeight_bns(int num, int index) {
		this.weight_bns[index] = num;
	}

}
