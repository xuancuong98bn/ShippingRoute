package main;

public class TSPModel {
	private int[] X;
	private boolean[] marked;
	private double f;
	private int best_f;
	private int[] best_X;
	private double[][] c;

	int count;

	public boolean check(int k, int v) {
		if (k > c.length || k == v)
			return false;
		for (int i = 0; i < k; i++) {
			if (X[i] == v)
				return false;
		}
		return true;
	}

	public boolean check() {
		for (boolean m : marked) {
			if (!m)
				return false;
		}
		return true;
	}

	private void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " -> ");
		}
		System.out.println("0");
	}

	public void tryValue(int k) {
		for (int i = 0; i < c.length; i++) {
			if (check(k, i)) {
				marked[i] = true;
				f += c[k][i];
				X[k] = i;
				tryValue(++k);
				if (check()) {
					f += c[i][0];
					if (f < best_f) updateBest();
					clear(k);
				}
				printArray(X);
			}
		}
	}

	public void updateBest() {
		this.best_X = this.X.clone();
		this.best_f = (int) this.f;
		this.f = 0;
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

	public void setInput(double[][] c) {
		this.c = c;
		X = new int[c.length];
		marked = new boolean[c.length];
		best_X = new int[c.length];
		clear(0);
		f = 0;
		best_f = 99;
	}

	public void solve() {
		marked[0] = true;
		X[0] = 0;
		tryValue(1);
		printArray(X);
	}
}
