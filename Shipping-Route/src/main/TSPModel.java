package main;

public class TSPModel {
	private int[] X;
	private boolean[] marked;
	private double f;
	private int best_f;
	private int[] best_X;
	private double[][] c;

	private boolean check(int k, int v) {
		if (k >= c.length)
			return false;
		for (int i = 0; i < k; i++) {
			if (X[i] == v)
				return false;
		}
		return true;
	}

	private boolean check() {
		for (boolean m : marked) {
			if (!m)
				return false;
		}
		return true;
	}

	public void tryValue(int k) {
		for (int i = 0; i < c.length; i++) {
			if (check(k, i)) {
				//set values for traveling at index k of X and column i of row X[k-1]
				marked[i] = true;
				f += c[X[k - 1]][i];
				X[k] = i;
				//recursive calling
				tryValue(k + 1);
				//check complete route
				if (check()) {
					f += c[i][0];
					if (best_f == 0 || f < best_f)
						updateBest();
					f -= c[i][0];
				}
				//set default values after checking
				marked[i] = false;
				f -= c[X[k - 1]][i];
				X[k] = -1;
			}
		}
	}

	public void updateBest() {
		this.best_X = this.X.clone();
		this.best_f = (int) this.f;
	}

	public void printSolution() {
		System.out.print(this.best_f);
	}

	private void clear(int k) {
		for (int i = k; i < X.length; i++) {
			X[i] = -1;
			marked[i] = false;
		}
	}

	public void setInput(double[][] c) throws Exception {
		if (c.length == 0) throw new Exception("Empty data!");
		this.c = c;
		X = new int[c.length];
		marked = new boolean[c.length];
		best_X = new int[c.length];
		marked[0] = true;
		X[0] = 0;
		f = 0;
		best_f = 0;
		clear(1);
	}
	
	private void printArray(int[] arr) {
		for (int i : arr) System.out.print(i + " -> ");
		System.out.println("0");
	}

	public void solve() {
		tryValue(1);
		System.out.println("\nSolution:");
		printArray(best_X);
	}
}
