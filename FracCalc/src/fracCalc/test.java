package fracCalc;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		String[] expression = new String [3];
		String[] arr = "1_1/2".split("_");	
		expression[0] = arr[0];
		String[] frac = arr[1].split("/");
		expression[1] = frac[0];
		expression[2] = frac[1];
		System.out.println(Arrays.toString(expression));
	}

}
