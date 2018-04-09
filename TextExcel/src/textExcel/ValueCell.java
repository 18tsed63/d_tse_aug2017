package textExcel;

public class ValueCell extends RealCell implements Cell {
	//private String input;
	private Double value;
	public ValueCell(String value) {
		super(value);
		//input = value;
		this.value = Double.parseDouble(value);
	}
	public String abbreviatedCellText() {
		String result = this.value + "          ";
		return result.substring(0,10);
	}
	public String fullCellText() {
		//String result = value + "";
		return getInput();
	}
	public double getDoubleValue() {
		//this.value = Double.parseDouble(getInput());
		return value;
	}
}

