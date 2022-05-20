package main;

public class ShippingRoute {

	/**
	 * X[]
	 * tryValue(int k)
	 * boolean check(int v, int k)
	 * @param args
	 */
	public static void main(String[] args) {
		TSPSolver solver = new TSPSolver();
		solver.readInput("D:\\Study\\Specialization\\Specialization_9\\Min\\CSD22\\data.txt");
		solver.solve();
	}
	
	

}
