package textExcel;

public class PercentCell implements Cell{
	private String percent;
	public PercentCell(String input) {
		percent = input;
	}
	public String abbreviatedCellText() {
		String result = percent.substring(1,percent.indexOf("."));
		return result + "%";
	}
	public String fullCellText() {
		String result = percent.substring(1,percent.length() - 1);
		double dec = Double.parseDouble(result) / 100;
		return dec + "";
	}
}
