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
		System.out.println(Arrays.toString("apples pineapples bread lettus tomato bacon mayo ham bread cheese" .split("bread")));
		//get the filling
		System.out.println(getTheFilling("applespineapplesbreadlettustomatobaconmayohambreadcheese"));
		System.out.println(getTheFilling("applespineapplesbreadlettustomatobreadbaconbreadmayohambreadcheese"));
		System.out.println(getTheFilling("apples pineapples bread lettus tomato bread bacon mayo ham bread cheese" ));
		
		//Your task Part 1:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		* What if it's a fancy sandwich with multiple pieces of bread?
		*/
	}
	//PART 1 and 2 (this code works for both)	
	public static String getTheFilling(String sandwich) {
			String [] i = sandwich.split("bread");
			String filling = "";
			//not a sandwich
			if(i.length <= 2) {
				String j = "not a sandwich";
				return j;
			}
			//peasant sandwich
			/*else if(i.length == 3) {
			filling = i[1];
			return filling;
			}*/
			//fancy sandwich
			if(i.length >= 2) {
			filling = Arrays.toString(Arrays.copyOfRange(i, 1, i.length - 1));
			return filling;
			}
			
			
			return filling;	
	}		
	
}
