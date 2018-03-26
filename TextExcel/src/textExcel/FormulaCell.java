package textExcel;

public class FormulaCell implements Cell{
	private String formula;
	public FormulaCell(String input) {
		formula = input;
	}
	public String abbreviatedCellText() {
		return "          ";
	}
	public String fullCellText() {
		return formula;
	}
}
