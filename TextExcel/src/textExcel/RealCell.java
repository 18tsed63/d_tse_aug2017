package textExcel;

public class RealCell implements Cell {
	private String input;
	public RealCell(String input) {
		this.input = input;
	}
	public String abbreviatedCellText() {
		
		return null;
	}

	public String fullCellText() {
		
		return input;
	}

	public double getDoubleValue() {
		return 0.0;
	}
	
	public String getInput() {
		return input;
	}
}

