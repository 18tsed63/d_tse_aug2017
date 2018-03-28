package textExcel;

public class ValueCell extends RealCell{
	private String input;
	private Double value;
	public ValueCell(String value) {
		input = value;
		this.value = Double.parseDouble(input);
	}
	public String abbreviatedCellText() {
		String result = this.value + "          ";
		return result.substring(0,10);
	}
	public String fullCellText() {
		//String result = value + "";
		return input;
	}
	public double getDoubleValue() {
		
		return value;
	}
}

