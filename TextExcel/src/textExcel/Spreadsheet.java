/* Darius Tse
 * 3.13.18
 * 
 */

package textExcel;

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
		
		return "";
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

}


