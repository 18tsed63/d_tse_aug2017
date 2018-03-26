package textExcel;

public class ValueCell implements Cell{
	private Double value;
	public ValueCell(String value) {
		this.value = Double.parseDouble(value);
	}
	public String abbreviatedCellText() {
		String result = this.value + "          ";
		return result.substring(0,10);
	}
	public String fullCellText() {
		String result = value + "";
		return result;
	}

}
