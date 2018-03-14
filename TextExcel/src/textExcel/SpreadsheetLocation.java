/* Darius Tse
 * 3.13.18
 * 
 */

package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String cellName;
	
    @Override
    public int getRow()
    {
    	
    	String row = cellName.substring(1);
    	int i = Integer.parseInt(row);
    	
    	
    	
        return i - 1;
    }

    @Override
    public int getCol()
    {
        String column = cellName.toUpperCase();
        char c = column.charAt(0);               
        //int ascii = (int) c;
        return c - 65;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        this.cellName = cellName;
    }

}


