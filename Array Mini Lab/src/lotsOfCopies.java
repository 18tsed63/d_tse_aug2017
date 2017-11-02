import java.util.Arrays;

/* Darius Tse
 * 11.1.17
 * Array mini lab
 */
public class lotsOfCopies {

	public static void main (String[] args) {
		int num = 7;
		String strMain = "APCS";
		int [] arrMain = {1, 2, 3, 4, 5};
		
		/* 1. When you pass something into a method and then change the value inside
		 * the method, does the value change in the main part of your program?
		 *
		 * Yes and no. Primitives like String and int do not change, but 
		 * object such as arrays will change. I speculate that it is because 
		 * arrays are storages rather than variables.
		 */
		changeMe(num, strMain, arrMain);
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));
		}
	
	public static void changeMe(int x, String str, int [] arr) {
		System.out.println("in changeMe, before change, num is " + x);
		x = 4;
		System.out.println("in changeMe, after change, num is " + x);
		System.out.println("in changeMe, before change, strMain is " + str);
		str = " hi there";
		System.out.println("in changeMe, after change, strMain is " + str);
		System.out.println("in changeMe, before change, arrMain is " + Arrays.toString(arr));
		arr [0] = 9;
		System.out.println("in changeMe, after change, arrMain is " + Arrays.toString(arr));
			
	/* 2. When you set one variable to equal another and then change the original
	 * variable to something else, does the second value change too or stay the same?
	 * 
	 *  For ints and String, it won't change, but for arrays it will 
	 *  
	 */
	
		//a = start
		//b = a
		//a == new
		//b == ???
		
		//integer
		x = 3;
		int bInt = x;
		x = 23;
		System.out.println(" b: " + bInt);
		
		//String
		str = "hhhhh";
		String bStr = str;
		str = "iiiiii";
		System.out.println("bStr: " + bStr);
		
		//array
		int [] bArr = arr;
		arr[0] = 200;
		System.out.println("bArr: " + Arrays.toString(bArr));
	}
	
}

