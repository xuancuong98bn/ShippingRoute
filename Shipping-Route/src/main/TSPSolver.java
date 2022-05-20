package main;

import java.io.BufferedReader;
import java.io.FileReader;

public class TSPSolver {
	private TSPModel model;

	public TSPSolver() {
		model = new TSPModel();
	}
	
	public void solve() {
		model.solve();
		model.printSolution();
	}

	public void readInput(String filename) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
			double[][] out;
			String line = bufferedReader.readLine();
			int n = Integer.parseInt(line.trim()) + 1;
			int i = 0;
			out = new double[n][n];
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				double[] child = toInt(line.trim().split(" "));
				out[i++] = child;
			}
			model.setInput(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private double[] toInt(String[] arrStr) {
		double[] out = new double[arrStr.length];
		for (int i = 0; i < arrStr.length; i++) {
			out[i] = Double.parseDouble(arrStr[i]);
		}
		return out;
	}
}
