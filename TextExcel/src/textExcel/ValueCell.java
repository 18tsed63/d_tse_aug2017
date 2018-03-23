package textExcel;

public class ValueCell implements Cell{
	private String value;
	public ValueCell(String value) {
		this.value = value;
	}
	public String abbreviatedCellText() {
		String result = this.value + "          ";
		return result.substring(0,10);
	}
	public String fullCellText() {
		return value;
	}

}
