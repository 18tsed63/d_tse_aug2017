package textExcel;

public class TextCell implements Cell{
	private String text;
	public TextCell (String text) {
		this.text = text;
	}
	public String abbreviatedCellText() {
		String text = this.text.substring(1,this.text.length() - 1) + "           ";
		return text.substring(0,10);
	}
	public String fullCellText() {
		return text;
	}
}

