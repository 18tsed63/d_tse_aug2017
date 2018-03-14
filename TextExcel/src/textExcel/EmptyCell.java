/* Darius Tse
 * 3.13.18
 * 
 */

package textExcel;

public class EmptyCell implements Cell{
	private String EmptyCell;
	public EmptyCell() {
		EmptyCell = "|          |";
	}
	public String abbreviatedCellText() {
		return EmptyCell;
	}
	public String fullCellText() {
		return EmptyCell;
	}
}


