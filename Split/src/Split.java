/* Darius Tse
 * 10.27.17
 *  Method that remove certain words from a sentence
 */

import java.util.Arrays;

public class Split{

	public static void main(String[] args) {
		// Part 0
		//Your task
		//String.split();
		//It's a method that acts on a string, <StringName>.split(<String sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		// Example: "I like apples!".split(" "); 
		//	it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples".split("really")
		//	it will split at the word "really" and return an array of ["I "," like "," red apples!"]

		//play around with String.split! 
//What happens if you "I reallyreally likeapples".split("really") ?
		String[] arr = "I like apples".split(" ");
		System.out.println(Arrays.toString("I like apples".split(" ")));
		System.out.println(Arrays.toString("I really like really red apples".split("really")));
		System.out.println(Arrays.toString("really I really like really red really apples, really".split("really")));
		System.out.println(getTheFilling("applespineapplesbreadlettustomatobaconmayohambreadcheese"));
		//Your task Part 1:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		* What if it's a fancy sandwich with multiple pieces of bread?
		*/
	}
		public static String getTheFilling(String sandwich) {
			String [] i = sandwich.split("bread");
			String filling = i[1];
			return filling ;
		}
	

}
