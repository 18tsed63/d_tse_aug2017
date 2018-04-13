/* Darius Tse
 * 3.13.18
 * 
 */

package textExcel;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		boolean done = false;
		Spreadsheet grid = new Spreadsheet();
		while (!done == true) {
			String input = userInput.nextLine();
			input = input.toLowerCase();
			if (input.indexOf("quit") < 0) {
				System.out.println(grid.processCommand(input));
			}
			else {
				done = true;
			}
		}
	}
}