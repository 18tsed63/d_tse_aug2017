/* Darius Tse
 * 3.13.18
 * 
 */

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		boolean done = false;
		while(!done == true){
		
		
		SpreadsheetLocation a = new SpreadsheetLocation("L20");
		int b = a.getCol();
		int c = a.getRow();
		System.out.println( c);
		
		
		
		System.out.println("Do you want to keep going? (Type \"quit\" to end)");
		String end = userInput.next();
		//toLowerCase will enable both q and Q to end
		end = end.toLowerCase();
		int n = end.indexOf("q");
		if(n == 0) {
			done = true;
		}else {
			done = false;
			}

		}
	}
}


