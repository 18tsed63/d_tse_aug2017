/* Darius Tse
 * 4.13.18
 * 
 */

package textExcel;

public class PercentCell extends RealCell implements Cell{
	//private String percent;
	private double dec;
	public PercentCell(String input) {
		super(input);
		//percent = input;
		dec = Double.parseDouble(input.substring(0, input.indexOf("%"))) / 100;
		
	}
	public String abbreviatedCellText() {
		String dec = (this.dec * 100.0) + "";
		String result = dec.substring(0, dec.indexOf("."));
		return (result + "%" + "          ").substring(0, 10);
	}
	public String fullCellText() {
		//String result = percent.substring(1,percent.length() - 1);
		//double dec = Double.parseDouble(result) / 100;
		return dec + "";
	}
	public double getDoubleValue() {
		
		return dec;
	}
}

