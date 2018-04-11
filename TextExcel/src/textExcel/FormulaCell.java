package textExcel;

public class FormulaCell extends RealCell implements Cell {
	// private String formula;
	public FormulaCell(String input) {
		super(input);
		// formula = input;
	}

	public String abbreviatedCellText() {
		double equation = getDoubleValue();
		String result = equation + "          ";
		return result.substring(0, 10);
	}

	public String fullCellText() {
		return getInput();
	}

	public double getDoubleValue() {
		String equation = getInput();
		String eqn = equation.substring(2, equation.length() - 2);
		String[] arr = eqn.split(" ");
		double result = Double.parseDouble(arr[0]);
		for (int i = 1; i < arr.length; i += 2) {
			if (arr[i].equals("+")) {
				result += Double.parseDouble(arr[i + 1]);
			} else if (arr[i].equals("-")) {
				result -= Double.parseDouble(arr[i + 1]);
			} else if (arr[i].equals("*")) {
				result *= Double.parseDouble(arr[i + 1]);
			} else {
				result /= Double.parseDouble(arr[i + 1]);
			}
		}
		return result;
	}
}
