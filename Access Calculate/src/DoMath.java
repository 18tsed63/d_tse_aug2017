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
	}

}
