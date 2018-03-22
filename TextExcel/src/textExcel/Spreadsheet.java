/* Darius Tse
 * 3.13.18
 * 
 */

package textExcel;

import java.util.Arrays;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] sheet = new Cell[20][12];
	
	public Spreadsheet() {
		for(int i = 0; i < sheet.length; i++) {
			for(int j = 0; j < sheet[i].length; j++) {
				Cell k = new EmptyCell();
				sheet[i][j] = k;
			}
		}
	}
	@Override
	public String processCommand(String command)
	{
		//command = command.toLowerCase();
		String result = "";
		String [] arr = command.split(" ");
		//makes it so commands are not sensitive to upper or lower case
		arr[0] = arr[0].toLowerCase();
		SpreadsheetLocation cell = new SpreadsheetLocation(arr[0]);
		int row = 0;
		int col = 0;
		//if(command.indexOf("clear") < 0) {
		if(!arr[0].equals("clear")) {
		row = cell.getRow();
		col = cell.getCol();
		}
		//clear command
		if(arr[0].equals("clear")) {
		//if(command.indexOf("clear") >= 0) {
			//clear cell
			
			if(arr.length > 1) {
				SpreadsheetLocation clearCell = new SpreadsheetLocation(arr[1]);
				sheet[clearCell.getRow()][clearCell.getCol()] = new EmptyCell();
			}
			//clear grid
			else{
				for(int i = 0; i < sheet.length; i++) {
					for(int j = 0; j < sheet[i].length; j++) {
						Cell k = new EmptyCell();
						sheet[i][j] = k;
					}
				}
			}
			result = getGridText();
		}
		//cell inspection command
		else if(arr.length == 1) {
			result = sheet[row][col].fullCellText();
		}
		//cell assignment command
		else if(arr.length > 1){
			String [] texts = command.split(" ", 3);
			sheet[row][col] = new TextCell(texts[2]);
			result = getGridText();
			
		}
		return result;
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String grid = "   ";
		for(char k = 'A'; k <= 'L'; k++) {
			grid += "|" + k + "         ";
		}
		grid += "|\n";
		
		for(int i = 0; i < sheet.length; i++) {
			String number = i + 1 + "   ";
			grid += number.substring(0, 3);
			for(int j = 0; j < sheet[i].length; j++) {
				grid += "|" + sheet[i][j].abbreviatedCellText();
			}
			grid += "|\n";
		}
		return grid;
	}

}
