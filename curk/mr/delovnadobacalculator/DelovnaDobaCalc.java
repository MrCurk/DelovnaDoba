package curk.mr.delovnadobacalculator;

import java.util.Scanner;

/**
 * 
 * @author mr.curk@gmail.com
 *
 */

class DelovnaDobaCalc  {
	private DelovnaDoba dd;
	private Scanner sc;
	private String keyboardInput;
DelovnaDobaCalc() {
	dd = new DelovnaDoba();
	sc = new Scanner(System.in);
	keyboardInput = "";
}

 void start() {

	 
	 
	 do {
		DelovnaDobaCalc.printHelp();
		keyboardInput = nextInput();
		switch (keyboardInput) {
		case "":
			System.out.print("Let: ");
			dd.addDD(nextInputInt(), 0, 0);

			System.out.print("Mesecev: ");
			dd.addDD(0, nextInputInt(), 0);

			System.out.print("Dni: ");
			dd.addDD(0, 0, nextInputInt());
			dd.toPrintDD();
			break;
		case "R":
			dd.resetDD();
			dd.toPrintDD();
			break;
		case "Q":
			System.out.println("Lep pozdrav!");
			break;
		default:
			printErr();
			break;
		} 
	} while (!keyboardInput.toUpperCase().equals("Q"));
	 
	 
	 
	
}

private String nextInput() {
	return sc.nextLine().toUpperCase();
}

private int nextInputInt() {
	try {
		return Integer.parseInt(sc.nextLine());
	} catch (Exception e) {
		printErr();
		return 0;
	}
	
}

private void printErr() {
	System.out.println("Napaka pri vnoslu!!!");	
}
 static void printHelp() {
	System.out.println("Enter - Sestevanje, R - Reset, Q - Izhod");
}

}
