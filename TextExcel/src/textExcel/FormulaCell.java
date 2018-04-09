package textExcel;

public class FormulaCell extends RealCell implements Cell {
	// private String formula;
	public FormulaCell(String input) {
		super(input);
		// formula = input;
	}

	public String abbreviatedCellText() {
		return "solved eqn";
	}

	public String fullCellText() {
		return getInput();
	}

	public double getDoubleValue() {
		String[] arr = getInput().split(" ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i + 1] == "+") {

			}
			else if (arr[i + 1] == "+") {

			}
			else if (arr[i + 1] == "+") {

			}
			else{

			}
		}
		return 0;
	}
}
