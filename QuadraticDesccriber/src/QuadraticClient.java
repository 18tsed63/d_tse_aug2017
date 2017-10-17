/* Darius Tse
 * 10.17.17
 * Run to Quadratic Describer
 */

import java.util.*;

public class QuadraticClient {
	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the Quadratic Describer");
		System.out.println("Provide your values for coefficeint a, b, and c");
		boolean done = false;
		while(!done == true){
			System.out.print("a: ");
			double a = userInput.nextDouble();
			System.out.print("b: ");
			double b = userInput.nextDouble();
			System.out.print("c: ");
			double c = userInput.nextDouble();
			System.out.println(Quadratic.quadrDescriber(1, 2, 1));
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			String end = userInput.next();
			int n = end.indexOf("q");
			if(n == 0) {
				done = true;
			}else {
				done = false;
			}
		}
	}
}



