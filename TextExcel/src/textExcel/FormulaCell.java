package textExcel;

public class FormulaCell extends RealCell implements Cell {
	private Cell[][] sheet;

	public FormulaCell(String input, Cell[][] sheet) {
		super(input);
		this.sheet = sheet;
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
		eqn = eqn.toLowerCase();
		String[] arr = eqn.split(" ");
		double result = 0;

		if (Character.isLetter(eqn.charAt(0)) == true) {
			// when arr[0] is SUM or AVG
			if (Character.isLetter(eqn.charAt(1)) == true) {
				String[] cellsRange = arr[1].split("-");
				SpreadsheetLocation start = new SpreadsheetLocation(cellsRange[0]);
				SpreadsheetLocation end = new SpreadsheetLocation(cellsRange[1]);
				int startRow = start.getRow();
				int startCol = start.getCol();
				int endRow = end.getRow();
				int endCol = end.getCol();
				arr[1] = arr[1].toLowerCase();
				// when command is SUM
				if (arr[0].indexOf("sum") >= 0) {
					result = sum(startRow, startCol, endRow, endCol);
				}
				// when command is AVG
				else {
					result = avg(startRow, startCol, endRow, endCol);
				}
			}
			// when arr[0] is a cell
			else if (Character.isLetter(eqn.charAt(1)) == false) {
				SpreadsheetLocation cell = new SpreadsheetLocation(arr[0]);
				RealCell first = (RealCell) sheet[cell.getRow()][cell.getCol()];
				result = first.getDoubleValue();
			}
		}
		// when arr[0] is a number
		else {
			result = Double.parseDouble(arr[0]);
		}

		if (arr[0].indexOf("sum") < 0 && arr[0].indexOf("avg") < 0) {
			for (int i = 1; i < arr.length; i += 2) {
				if (Character.isLetter((arr[i + 1]).charAt(0)) == true) {
					arr[i + 1] = arr[i + 1].toLowerCase();
					SpreadsheetLocation iCell = new SpreadsheetLocation(arr[i + 1]);
					RealCell iValue = (RealCell) sheet[iCell.getRow()][iCell.getCol()];
					arr[i + 1] = iValue.getDoubleValue() + "";
				}
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
		}
		return result;
	}

	public double sum(int startRow, int startCol, int endRow, int endCol) {
		double sum = 0;
		for(int i = startRow; i <= endRow; i++) {
			for(int j = startCol; j <= endCol; j++) {
				RealCell k = (RealCell) sheet[i][j];
				sum += k.getDoubleValue();
			}
		}
		return sum;
	}

	public double avg(int startRow, int startCol, int endRow, int endCol) {
		double result = sum(startRow, startCol, endRow, endCol);
		int counter = (endRow - startRow + 1) * (endCol - startCol + 1);
		return result / counter;
	}

}

