/* Darius Tse
 * 9.29.17
 * write math functions here
 * 2nd period
 */

// part 1
public class Calculate {
	// takes an integer and returns the integer squared
	public static int square(int operand){
	 int square = operand*operand;
			 return square;
	}

// takes an integer and returns the integer cubed		 
public static int cube( int operand){
		int cube = operand*operand*operand;
			return cube;
	}
// takes 2 ints, returns average of 2 ints	
public static double average ( double operand1, double operand2){
		double average = (operand1 + operand2)/2;
			return average;
	}
// takes 3 ints, returns average of 3 ints
public static double average ( double operand1, double operand2, double operand3){
	double average = (operand1 + operand2 + operand3)/3;
		return average;
	}
// takes a double, returns double in degrees
public static double toDegrees ( double operand) {
	double pi = 3.14159;
	double toDegrees = (operand*180/pi);
	return toDegrees;
	}
// takes a double, returns double in radians
public static double toRadians ( double operand) {
	double pi = 3.14159;
	double toRadians = (operand*pi/180);
	return toRadians;
	}

public static double discriminant(double a, double b, double c){
	double discriminant = (b * b) - (4 * a * c);
		return discriminant;
	}

public static String toImproperFrac(int whole, int numerator, int denominator) {
	numerator = (whole * denominator) + numerator;
	String toImproperFrac = (numerator + "/" + denominator);
	return toImproperFrac;
	}

public static String toMixedNum(int numerator, int denominator) {
	int wholeNum = numerator / denominator;
	numerator = numerator % denominator;
	String toMixedNum = (wholeNum + "_" + numerator + "/" + denominator);
	return toMixedNum;
	}
// takes 4 ints and a String, returns the ints and String "foiled"
public static String foil(int a, int b, int c, int d, String n) {
	int polynomialA = a * c;
	int polynomialB = (a * d) + (b * c);
	int polynomialC = b * d;
	String foil = (polynomialA+n+"^2"+" +"+"("+polynomialB+n+")"+" "+"+"+"(" + polynomialC + ")");
	return foil;
	
	}

// part 2
// takes 2 ints, returns true when dividend is divisible by divisor
public static boolean isDivisibleBy(int Dividend, int Divisor){
	if(Dividend%Divisor==0) return true; 
	else
		return false;
	}
// takes a double, returns absolute value of the double
public static double absValue(double a) {
	if(a > 0) return a;
 	else { return a * -1;
 		}
	}
// takes 2 double, returns the bigger double
public static double max(double num1, double num2) {
	if(num1 > num2) return num1;
	else { return num2;
		}
	}
// takes 3 double, returns the biggest double
public static double max(double num1, double num2, double num3) {
	if(num1 > num2 && num1 > num3) return num1;
	if(num2 > num1 && num2 > num3) return num2;
	else { return num3;
			}
	}
// takes 2 double, returns the smallest double
public static double min(double num1, double num2) {
	if(num1 < num2) return num1;
	else { return num2;
		}
	}
// takes a double, returns double rounded to the nearest 0.01
public static double round2(double orig)
{
	double result = 0.0;
		
	int tempInt = (int)(orig * 1000);
	int roundNum = tempInt % 10;
	tempInt = tempInt / 10;
	if (roundNum >= 5 && tempInt > 0)
		tempInt++;
	else if(roundNum <= -5 && tempInt < 0)
		tempInt--;
	result = tempInt / 100.0;
	return result;
}

//part 3

public static double exponent(double baseNum, int exponent) {
	int i = 1;
	double k = baseNum;
	while (i < exponent) {
	 k *= baseNum;
	 i++;
			}
	return k;
	}
// multiplies all integers between 1 and the int
public static int factorial(int num) {
	int i = 1;
	for (i = 1; num >= 1; num--) {
		i *= num;
		}
return i;
	}

// takes a int and decides whehter it is prime
public static boolean isPrime(int num) {
	for(int i = 2; i < num; i++) {
		if(isDivisibleBy(num, i) == true) {
			return false;
			}
		}
		return true;
	}

// takes 2 ints and returns the greatest common factor of the 2 ints
public static int gcf(int num1, int num2) {
	while(num2 != 0) {
        int i = num1;
		num1 = num2;
        if(isDivisibleBy(i, num2) == true) {
		return Math.abs(num2);
		}
 num2 = i % num2;   
	}
    return Math.abs(num1);
}
// takes a double, returns squareroot of the double
public static double sqrt(double a) {
	if(a == 0) {
		return a;
	}
	double b = 0;
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
		b = b + 0.01;
		return round2(b);
}
	
// part 4
/* quadratic formula
 * take the coefficients of a standard form equation as 3 ints
 * returns the values of the equation's roots
 * may return 1, 2, or no answers
 */
public static String quadForm(int a, int b, int c) {
	String k = "no real roots";
	double x1;
	double x2;
	double d = discriminant(a, b, c);
	// 2 solution
	if(d > 0) {
		d = sqrt(d);
		x1 = (-1 * b) + d;
		x1 = x1 / (2 * a);
		x2 = (-1 * b) - d;
		x2 = x2 / (2 * a);
		x1 = round2(x1);
		x2 = round2(x2);
		String i = x1 + " and " + x2;
		return i;
	}
	// 1 solution
	if(d == 0) {
		x1 = (-1 * b) + d;
		x1 = x1 / (2 * a);
		x1 = round2(x1);
		String j = x1 + " ";
		return j;
	}
	// no solution
	if(d < 0) {
		return k;
	}
		return k;
}

}	








	





	





