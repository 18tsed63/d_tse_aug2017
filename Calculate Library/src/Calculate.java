/* Darius Tse
 * 9.6.17
 * write math functions here
 */
public class Calculate {
	public static int square(int operand){
	 int square = operand*operand;
			 return square;
	}

		 
public static int cube( int operand){
		int cube = operand*operand*operand;
			return cube;
	}
	
public static double average ( double operand1, double operand2){
		double average = (operand1 + operand2)/2;
			return average;
	}

public static double average ( double operand1, double operand2, double operand3){
	double average = (operand1 + operand2 + operand3)/3;
		return average;
	}

public static double toDegrees ( double operand) {
	double pi = 3.14159;
	double toDegrees = (operand*180/pi);
	return toDegrees;
	}

public static double toRadians ( double operand) {
	double pi = 3.14159;
	double toRadians = (operand*pi/180);
	return toRadians;
	}

public static double discriminant(double A, double B, double C){
	double discriminant = (B*B) - (4*A*C);
		return discriminant;
	}

public static String toImproperFrac(int A, int B, int C) {
	int numerator = (A*C)+B;
	int denominator = C;
	String toImproperFrac = (numerator + "/" + denominator);
	return toImproperFrac;
	}

public static String toMixedNum(int A, int B) {
int wholeNum = A/B;
int numerator = A%B;
int denominator = B;
String toImproperFrac = (wholeNum + "_" + numerator + "/" + denominator);
return toImproperFrac;
	}

public static String foil(int A, int B, int C, int D, String n) {
int polynomialA = A*C;
int polynomialB = (A*D) + (B*C);
int polynomialC = B*D;
String foil = (polynomialA+n+"^2"+" +"+"("+polynomialB+n+")"+" "+"+"+"(" + polynomialC + ")");
return foil;

	}
}



	





	





