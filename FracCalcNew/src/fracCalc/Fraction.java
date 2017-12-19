/* Darius Tse
 * 12.18.17
 * objects that frac calc calls on
 */
package fracCalc;

public class Fraction {
	private int whole = 0;
	private int numerator = 0;
	private int denominator = 1;
	private int[] globalArr = new int[2];

	public Fraction(String equation) {
		// mixedNum
		if (equation.indexOf("/") >= 0 && equation.indexOf("_") >= 0) {
			String[] arr = equation.split("_");
			whole = Integer.parseInt(arr[0]);
			String[] frac = arr[1].split("/");
			numerator = Integer.parseInt(frac[0]);
			denominator = Integer.parseInt(frac[1]);
		}
		// fracNum
		else if (equation.indexOf("/") >= 0 && equation.indexOf("_") < 0) {
			String[] arr = equation.split("/");
			whole = 0;
			numerator = Integer.parseInt(arr[0]);
			denominator = Integer.parseInt(arr[1]);
		}
		// wholeNum
		else {
			whole = Integer.parseInt(equation);
		}
		globalArr = toImproperFrac(whole, numerator, denominator);
	}

	/*
	 * public void toImproperFrac (int whole, int numerator, int denominator){
	 * //negative frac if(whole<0){ numerator = (whole * denominator) + (numerator *
	 * -1);
	 * 
	 * }else{ numerator =((whole * denominator) + numerator); } }
	 */
	private int[] toImproperFrac(int whole, int numerator, int denominator) {
		int[] improperFrac = new int[2];
		// negative frac
		if (whole < 0) {

			improperFrac[0] = (whole * denominator) + (numerator * -1);
			improperFrac[1] = denominator;
		} else {
			improperFrac[0] = ((whole * denominator) + numerator);
			improperFrac[1] = denominator;
		}
		return improperFrac;
	}

	public int[] addFrac(int numerator1, int numerator2, int denominator) {

		int sumNum;
		int[] sumArr = new int[2];

		sumNum = numerator1 + numerator2;

		sumArr[0] = sumNum;
		sumArr[1] = denominator;

		return sumArr;
	}

	public int[] subtractFrac(int numerator1, int numerator2, int denominator) {

		int diffNum;
		int[] diffArr = new int[2];

		diffNum = numerator1 - numerator2;

		diffArr[0] = diffNum;
		diffArr[1] = denominator;

		return diffArr;
	}

	public int[] multiplyFrac(int numerator1, int denominator1, int numerator2, int denominator2) {
		int[] prodArr = new int[3];

		int prodNum = numerator1 * numerator2;
		int prodDen = denominator1 * denominator2;

		prodArr[0] = prodNum;
		prodArr[1] = prodDen;

		return prodArr;
	}

	public int[] divideFrac(int numerator1, int denominator1, int numerator2, int denominator2) {
		int[] quoArr = new int[2];

		int quoNum = numerator1 * denominator2;
		int quoDen = denominator1 * numerator2;

		quoArr[0] = quoNum;
		quoArr[1] = quoDen;

		return quoArr;
	}

	public String toMixedNum(int[] answer) {

		String reducedAnswer = "";
		int gcf = gcf(answer[0], answer[1]);
		if (gcf != 1) {
			answer[0] = answer[0] / gcf;
			answer[1] = answer[1] / gcf;
		}
		if (answer[1] < 0) {
			answer[1] = Math.abs(answer[1]);
			answer[0] = answer[0] * -1;
		}
		int coefficient = answer[0] / answer[1];
		int remainder = answer[0] % answer[1];
		if (coefficient < 0) {
			if (remainder == 0 && answer[1] == 1) {
				reducedAnswer = (Integer.toString(coefficient));
			} else if (remainder == 0 && answer[1] == -1) {
				reducedAnswer = (Integer.toString(coefficient));
			} else {
				reducedAnswer = coefficient + "_" + Math.abs(remainder) + "/" + Math.abs(answer[1]);
			}
		} else if (remainder == 0) {
			reducedAnswer = coefficient + "";
		} else if (coefficient == 0) {
			if (remainder < 0 && answer[1] < 0) {
				int newNum = remainder * -1;
				int newDen = answer[1] * -1;
				reducedAnswer = newNum + "/" + newDen;
			} else {
				reducedAnswer = remainder + "/" + answer[1];
			}
		} else if (remainder < 0 && answer[1] < 0) {
			int numerator = remainder * -1;
			int denominator = answer[1] * -1;
			reducedAnswer = coefficient + "_" + numerator + "/" + denominator;
		} else {
			reducedAnswer = coefficient + "_" + remainder + "/" + answer[1];
		}

		return reducedAnswer;
	}

	public boolean isDivisibleBy(int Dividend, int Divisor) {
		if (Dividend % Divisor == 0)
			return true;
		else
			return false;
	}

	public int gcf(int num1, int num2) {
		while (num2 != 0) {
			int i = num1;
			num1 = num2;
			if (isDivisibleBy(i, num2) == true) {
				return Math.abs(num2);
			}
			num2 = i % num2;
		}
		return Math.abs(num1);
	}
	public int[] getArr() {
		return globalArr;
	}
}


