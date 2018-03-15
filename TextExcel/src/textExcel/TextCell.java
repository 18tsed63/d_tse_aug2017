package textExcel;

public class TextCell implements Cell{
	private String text;
	public TextCell (String text) {
		this.text = text;
	}
	public String abbreviatedCellText() {
		return text.substring(0,10);
	}
	public String fullCellText() {
		return "\"" + text + "\"";
	}
}
