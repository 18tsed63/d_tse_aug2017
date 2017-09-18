/* Darius Tse
 * 9.6.17
 * write math functions here
 */

// part 1
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

// part 2

public static boolean isDivisibleBy(int Dividend, int Divisor){
	if(Dividend%Divisor==0) return true; 
	else
		return false;
	}
public static double absValue(double A) {
	if(A > 0) return A;
 	else { return A*-1;
 		}
	}

public static double max(double A, double B) {
	if(A > B) return A;
	else { return B;
		}
	}

public static double max(double A, double B, double C) {
	if(A > B && A > C) return A;
	if(B > A && B > C) return B;
	else { return C;
			}
	}

public static double min(double A, double B) {
	if(A < B) return A;
	else { return B;
		}
	}

public static double round2(double A) {
	if(A * 1000 % 10 < 5) {
		return ((A * 1000) - (A * 1000 % 10))/1000;
	}else { 
		return ((A * 1000) + (10 - (A * 1000 % 10)))/1000;
    		}
	}

//part 3
public static double exponent(double A, int B) {
	int i = 1;
	double k = A;
	while (i < B) {
	 k *= A;
	 i++;
			}
	return k;
	}

public static int factorial(int a) {
	int i = 1;
	for (i = 1; a >= 1; a--) {
		i *= a;
		}
return i;
	}


public static boolean isPrime(int a) {
	for(int i = 2; i < a; i++) {
		if(isDivisibleBy(a, i) == true) {
			return false;
			}
		}
		return true;
	}

public static int gcf(int a, int b) {
	while(b != 0) {
        int i = a;
		a = b;
        if(isDivisibleBy(i, b) == true) {
		return Math.abs(a);
		}
 b = i%b;   
	}
    return Math.abs(a);
}

public static double sqrt(double a) {
	double b = 1;
	while(a >= b * b) {
		b++;
		}
	while(a <= b * b) {
		double c;
		c = a / b;
		c = c + b;
		c = c / 2;
		b = c;
		b = b - 0.01;
		}
		return round2(b);
	}	
}
	




	





	





