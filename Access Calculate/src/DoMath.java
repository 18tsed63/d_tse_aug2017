/* Darius Tse
 * 9.6.17
 * test math functions here
 */
public class DoMath {

	public static void main(String[] args) {
		double pi = 3.14159;
		System.out.println(Calculate.square(5));
		System.out.println(Calculate.cube(5));
		System.out.println(Calculate.average(2.0, 5.0));
		System.out.println(Calculate.average(2.0, 3.0, 4.0));
		System.out.println(Calculate.toDegrees(pi/2));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(1, 2, 3));
		System.out.println(Calculate.toImproperFrac(3,1,2));
		System.out.println(Calculate.toMixedNum(7, 2));
		System.out.println(Calculate.foil(2, 3, 6, -7, "x"));
		System.out.println(Calculate. isDivisibleBy(3,2));
		System.out.println(Calculate.absValue(5));
		System.out.println(Calculate.max(9,8));
		System.out.println(Calculate.max(1,2,3));
		System.out.println(Calculate.min(8,9));
		System.out.println(Calculate.round2(2.015));
		System.out.println(Calculate.exponent(2,3));
		System.out.println(Calculate.factorial(5));
		System.out.println(Calculate.isPrime(91));
		System.out.println(Calculate.isPrime(61));
		System.out.println(Calculate.gcf(64, 24));
		System.out.println(Calculate.sqrt(30));
		System.out.println(Calculate.quadForm(1, 0, 0));
	
	}

}
