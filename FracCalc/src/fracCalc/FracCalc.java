/* Darius Tse
 * 11.20.17
 * fraction calculator
 */
package fracCalc;
import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        boolean done = false;
        while(!done == true) {
    	Scanner userInput = new Scanner (System.in);
        System.out.println("Enter expression: ");
        String expression = userInput.nextLine();
        System.out.println(produceAnswer(expression));
        
        System.out.println("Do you want to quit?");
        String quit = userInput.next();
        int n = quit.indexOf("q");
		if(n == 0) {
			done = true;
		}else {
			done = false;
		}
    }
    }
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
    	String[] expression = input.split(" ");
        //operands and operator
    	String operand1 = expression[0];
        String operator = expression[1];
        String operand2 = expression[2];
        //operands in arrays
        String[] arr1 = splitOp(operand1);
        String[] arr2 = splitOp(operand2);
        //operand 1 divided into ints (whole, numerator, denominator)
        int whole1 = Integer.parseInt(arr1[0]);
    	int numerator1 = Integer.parseInt(arr1[1]);
    	int denominator1 = Integer.parseInt(arr1[2]);
    	//operand 2 divided into ints (whole, numerator, denominator)
    	int whole2 = Integer.parseInt(arr2[0]);
    	int numerator2 = Integer.parseInt(arr2[1]);
    	int denominator2 = Integer.parseInt(arr2[2]);
    	//turn both operands to improper fractions
    	/*Why? So, adding and subtracting negatives will be more efficient
    	 * and it is a necessity for multiplying and dividing.
    	 */
    	int [] opArr1 = toImproperFrac(whole1, numerator1, denominator1);
		int [] opArr2 = toImproperFrac(whole2, numerator2, denominator2);
    	int[] result = new int [2];
    	String answer = "";
    	
        if(operator.equals("+")) {        	
        	//common denominator
    		opArr1[0] *= opArr2[1];
        	opArr2[0] *= opArr1[1];        	
        	int denominator = opArr1[1] * opArr2[1];
        	
        	result = addFrac(opArr1[0], opArr2[0], denominator);
        	answer = toMixedNum(result);	
        }
        else if(operator.equals("-")) {
        	//common denominator
        	opArr1[0] *= opArr2[1];
        	opArr2[0] *= opArr1[1];
        	
        	int denominator = denominator1 * denominator2;
        	result = subtractFrac(opArr1[0], opArr2[0], denominator);
        	answer = toMixedNum(result);
        }
       else if(operator.equals("*")) {       	    		
        	result = multiplyFrac(opArr1[0], opArr1[1], opArr2[0], opArr2[1]);        	
        	answer = toMixedNum(result);   			
        }
        else if(operator.equals("/")) {        	
    		result = divideFrac(opArr1[0], opArr1[1], opArr2[0], opArr2[1]);
        	answer = toMixedNum(result);
        }        
        return answer;  
    }
    
    public static String[] splitOp(String equation) {
    	String[] expression = new String [3];
    //mixedNum
    if(equation.indexOf("/") >= 0 && equation.indexOf("_") >= 0) {
		String[] arr = equation.split("_");	
		expression[0] = arr[0];
		String[] frac = arr[1].split("/");
		expression[1] = frac[0];
		expression[2] = frac[1];
		}
    //fracNum
    else if(equation.indexOf("/") >= 0 && equation.indexOf("_") < 0) {
    	String[] arr = equation.split("/");
    	expression[0] = "0";
    	expression[1] = arr[0];
    	expression[2] = arr[1];
    }
    //wholeNum
    else {
    	expression[0] = equation;
    	expression[1] = "0";
    	expression[2] = "1";
    }
    return expression;
    }

    public static int[] toImproperFrac (int whole, int numerator, int denominator){
		int[] improperFrac=new int [2];
		//negative frac
		if(whole<0){
			
			improperFrac[0] = (whole*denominator)+(numerator*-1)	;
			improperFrac[1] = denominator;
		}else{
			improperFrac[0] =((whole*denominator)+numerator);
			improperFrac[1]=denominator;
		}
		return improperFrac;
	}

public static String toMixedNum(int[] answer){
		
	String reducedAnswer = "";
	int gcf = gcf(answer[0], answer[1]);
	if(gcf != 1){
		answer[0] = answer[0] / gcf;
		answer[1] = answer[1] / gcf;
	}
	if(answer[1] < 0){
		answer[1] = Math.abs(answer[1]);
		answer[0] = answer[0]*-1;
	}
	int coefficient = answer[0] / answer[1];
	int remainder = answer[0] % answer[1];
	if (coefficient < 0){
	  	if(remainder == 0 && answer[1] == 1){
	  		reducedAnswer = (Integer.toString(coefficient));
	 	}
	  	else if(remainder == 0 && answer[1] == -1){
	 			reducedAnswer = (Integer.toString(coefficient));
	  	}
	  	else{
		  		 reducedAnswer = coefficient + "_" + Math.abs(remainder) + "/" + Math.abs(answer[1]);
		}
	}
	else if(remainder == 0){
		reducedAnswer = coefficient+"";		
	}
	else if(coefficient == 0){			
		if(remainder < 0 && answer[1] < 0){
			int newNum = remainder*-1;
		  	int newDen = answer[1]*-1;
		  	reducedAnswer = newNum + "/" + newDen;
	}
		else{
				reducedAnswer = remainder + "/" + answer[1];
		}
	}
	else if(remainder < 0 && answer[1] < 0){
 	    int numerator = remainder * -1;
 		int denominator = answer[1] * -1;
 		reducedAnswer = coefficient + "_" + numerator + "/" + denominator;
	}
	else{
			reducedAnswer = coefficient + "_" + remainder + "/" + answer[1];
		}
					    		
	   	return reducedAnswer;
	}	
    
    public static boolean isDivisibleBy(int Dividend, int Divisor){
    	if(Dividend%Divisor==0) return true; 
    	else
    		return false;
    	}
    
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

    public static int[] addFrac(int numerator1, int numerator2, int denominator) {
    	
    	int sumNum;
    	int[] sumArr = new int [2];

	    	sumNum = numerator1 + numerator2;
	    	
	    	sumArr[0] = sumNum;
	    	sumArr[1] = denominator;
	   
    	return sumArr;
    }
    
    public static int[] subtractFrac(int numerator1, int numerator2, int denominator) {
    	
    	int diffNum;
    	int[] diffArr = new int [2];
    	
    	diffNum = numerator1 - numerator2;
    	
    	diffArr[0] = diffNum;
    	diffArr[1] = denominator;
    		
    	return diffArr;
    }
    
    public static int[] multiplyFrac(int numerator1, int denominator1,
    		int numerator2, int denominator2) {
    	int[] prodArr = new int [3];
    	
    	int prodNum = numerator1 * numerator2;
    	int prodDen = denominator1 * denominator2;
    	
    	prodArr[0] = prodNum;
    	prodArr[1] = prodDen;
    	
    	return prodArr;
    }
    
    public static int[] divideFrac(int numerator1, int denominator1,
    		int numerator2, int denominator2) {
    	int[] quoArr = new int [2];
    	
    	int quoNum = numerator1 * denominator2;
    	int quoDen = denominator1 * numerator2;
    	
    	quoArr[0] = quoNum;
    	quoArr[1] = quoDen;

    	return quoArr;
    }
}