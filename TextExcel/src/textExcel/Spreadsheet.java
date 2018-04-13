/* Darius Tse
 * 4.13.18
 * 
 */

package textExcel;

import java.util.Arrays;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	private Cell[][] sheet = new Cell[20][12];

	public Spreadsheet() {
		for (int i = 0; i < sheet.length; i++) {
			for (int j = 0; j < sheet[i].length; j++) {
				sheet[i][j] = new EmptyCell();;
			}
		}
	}

	@Override
	public String processCommand(String command) {
		// command = command.toLowerCase();
		String result = "";
		String[] arr = command.split(" ", 3);
		// makes it so commands are not sensitive to upper or lower case
		arr[0] = arr[0].toLowerCase();
		int row = 0;
		int col = 0;
		//get row and col when command is not clear
		if (!arr[0].equals("clear")) {
			SpreadsheetLocation cell = new SpreadsheetLocation(arr[0]);
			row = cell.getRow();
			col = cell.getCol();
		}
		// clear command
		if (arr[0].equals("clear")) {
			// clear cell
			if (arr.length > 1) {
				SpreadsheetLocation clearCell = new SpreadsheetLocation(arr[1]);
				sheet[clearCell.getRow()][clearCell.getCol()] = new EmptyCell();
			}
			// clear grid
			else {
				for (int i = 0; i < sheet.length; i++) {
					for (int j = 0; j < sheet[i].length; j++) {
						
						sheet[i][j] =  new EmptyCell();;
					}
				}
			}
			result = getGridText();
		}
		// cell inspection command
		else if (arr.length == 1) {
			result = sheet[row][col].fullCellText();
		}
		// cell assignment command
		else if (arr.length > 1) {
			//text cell
			if (arr[2].indexOf("\"") >= 0) {
				
				sheet[row][col] = new TextCell(arr[2]);	
			}
			//formula cell
			else if (arr[2].indexOf("(") >= 0) {
				sheet[row][col] = new FormulaCell(arr[2], sheet);
			}
			//percent cell
			else if (arr[2].indexOf("%") >= 0) {
				sheet[row][col]  = new PercentCell(arr[2]);
			}
			//value cell
			else {
				sheet[row][col] = new ValueCell(arr[2]);
			}
			result = getGridText();
		}
		return result;
	}

	@Override
	public int getRows() {
		return 20;
	}

	@Override
	public int getCols() {
		return 12;
	}

	@Override
	public Cell getCell(Location loc) {
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText() {
		String grid = "   ";
		for (char k = 'A'; k <= 'L'; k++) {
			grid += "|" + k + "         ";
		}
		grid += "|\n";

		for (int i = 0; i < sheet.length; i++) {
			String number = i + 1 + "   ";
			grid += number.substring(0, 3);
			for (int j = 0; j < sheet[i].length; j++) {
				grid += "|" + sheet[i][j].abbreviatedCellText();
			}
			grid += "|\n";
		}
		return grid;
	}

}
