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

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		boolean done = false;
		while(!done == true){
		
		//test
		Spreadsheet test = new Spreadsheet();
		
		System.out.print(test.processCommand("A1 = \"text with spaces\""));
		//System.out.println(test.processCommand("a1"));
		//System.out.println(test.processCommand("clear"));
		System.out.println(test.processCommand("a1"));
		System.out.println(test.processCommand(" clear ".trim()));
		
		//System.out.println(test.processCommand("a1").equals(""));
		
		
		System.out.println("Do you want to keep going? (Type \"quit\" to end)");
		String end = userInput.next();
		//toLowerCase will enable both q and Q to end
		end = end.toLowerCase();
		int n = end.indexOf("quit");
		if(n == 0) {
			done = true;
		}else {
			done = false;
			}

		}
	}
}

