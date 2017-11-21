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
        String operand1 = expression[0];
        String operator = expression[1];
        String operand2 = expression[2];
        String[] arr1 = splitOp(operand1);
        String[] arr2 = splitOp(operand2);
        String result = "";
        if(operator.equals("+")) {
        	result = addFrac(arr1, arr2);
        }
        else if(operator.equals("-")) {
        	result = subtractFrac(arr1, arr2);
        }
        else if(operator.equals("*")) {
        	result = multiplyFrac(arr1, arr2);
        }
        else if(operator.equals("/")) {
        	result = divideFrac(arr1, arr2);
        }
        //simplify for (num/den = 1)
        String[] n = splitOp(result);
        if(Integer.parseInt(n[1]) == Integer.parseInt(n[2])) {
        	result = simplify(result);
        }
        //simplify for wholeNums
        if(result.indexOf("0/1") >= 0) {
        	result = simplify(result);
        }
        
        return result;
        
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
    
    public static String simplify(String fraction) {
    	String simpleAnswer = "";
    	String[] simpleArr = splitOp(fraction);
    	int whole = Integer.parseInt(simpleArr[0]);
		int num = Integer.parseInt(simpleArr[1]);
		int den = Integer.parseInt(simpleArr[2]);
		int factor = gcf(num, den);
    	if(simpleArr[1].equals("0") == true) {
    		simpleAnswer = simpleArr[0];
    	}
    	else if(whole == 0) {
    		num /= factor;
    		den /= factor;
    		String Answer = toMixedNum(num, den);
    		String[] j = splitOp(Answer);
    		int k = Integer.parseInt(j[1]);
    		int l = Integer.parseInt(j[2]);
    		if(k < 0) {
    			j[1] = "" + (-1 * k);	
    		}
    		if(l < 0) {
    			j[2] = "" + (-1 * l);
    		}
    		simpleAnswer = j[0] + "_" + j[1] + "/" + j[2];
    		if(num == den) {
    			simpleAnswer = "" + (whole + 1);
    		}
    	}
    	else if(whole > 0) {
    		num /= factor;
    		den /= factor;
    		String mixNum = toMixedNum(num, den);
    		String arr[] = splitOp(mixNum);
    		int i = Integer.parseInt(arr[0]);
    		i += whole;
    		simpleAnswer = i + "_" + arr[1] + "/" + arr[2];
    	}
    	return simpleAnswer;
    }
    
    public static String addFrac(String[] arr1, String[] arr2) {
    	String sum = "";
    	int whole1 = Integer.parseInt(arr1[0]);
    	int numerator1 = Integer.parseInt(arr1[1]);
    	int denominator1 = Integer.parseInt(arr1[2]);
    	int whole2 = Integer.parseInt(arr2[0]);
    	int numerator2 = Integer.parseInt(arr2[1]);
    	int denominator2 = Integer.parseInt(arr2[2]);
    	numerator1 *= denominator2;
    	numerator2 *= denominator1;
    	int denominator = denominator1 * denominator2;
    	if(whole1 >= 0 && whole2 >=0) {
	    	int sumWhole = whole1 + whole2;
	    	int sumNum = numerator1 + numerator2;
	    	sum = sumWhole + "_" + sumNum + "/" + denominator;
	    }
    	if(whole1 < 0) {
    		String[] newArr = new String [3];
    		newArr[0] = "" + whole1 * -1;
    		newArr[1] = arr1[1];
    		newArr[2] = arr1[2];
    		sum = subtractFrac(newArr, arr2);
    		sum = "-" + sum;
    		if(sum.indexOf("--") >= 0) {
    			sum = sum.substring(2, sum.length());
    		}
    	}
    	return sum;
    }
    
    public static String subtractFrac(String[] arr1, String[] arr2) {
    	String difference = "";
    	int whole1 = Integer.parseInt(arr1[0]);
    	int numerator1 = Integer.parseInt(arr1[1]);
    	int denominator1 = Integer.parseInt(arr1[2]);
    	int whole2 = Integer.parseInt(arr2[0]);
    	int numerator2 = Integer.parseInt(arr2[1]);
    	int denominator2 = Integer.parseInt(arr2[2]);
    	numerator1 *= denominator2;
    	numerator2 *= denominator1;
    	int denominator = denominator1 * denominator2;
    	String operand1 = toImproperFrac(whole1, numerator1, denominator);
    	String operand2 = toImproperFrac(whole2, numerator2, denominator);
    	String[] op1 = operand1.split("/");
    	String[] op2 = operand2.split("/");
    	numerator1 = Integer.parseInt(op1[0]);
    	denominator1 = Integer.parseInt(op1[1]);
    	numerator2 = Integer.parseInt(op2[0]);
    	denominator2 = Integer.parseInt(op2[1]);
    	if(whole2 >= 0) {
    		int diffNum = numerator1 - numerator2;
    		difference = diffNum + "/" + denominator;
    	}
    	if(whole2 < 0) {
    		String[] newArr = new String [3];
    		newArr[0] = "" + whole2 * -1;
    		newArr[1] = arr2[1];
    		newArr[2] = arr2[2];
    		difference = addFrac(arr1, newArr);
    	}
    	return difference;
    }
    
    public static String multiplyFrac(String[] arr1, String[] arr2) {
    	String product = "";
    	int whole1 = Integer.parseInt(arr1[0]);
    	int numerator1 = Integer.parseInt(arr1[1]);
    	int denominator1 = Integer.parseInt(arr1[2]);
    	int whole2 = Integer.parseInt(arr2[0]);
    	int numerator2 = Integer.parseInt(arr2[1]);
    	int denominator2 = Integer.parseInt(arr2[2]);
    	int i = whole1;
    	int j = whole2;
    	if(whole1 < 0) {
    		whole1 *= -1;
    	}
    	if(whole2 < 0) {
    		whole2 *= -1;
    	}
    	String operand1 = toImproperFrac(whole1, numerator1, denominator1);
    	String operand2 = toImproperFrac(whole2, numerator2, denominator2);
    	String[] op1 = operand1.split("/");
    	String[] op2 = operand2.split("/");
    	numerator1 = Integer.parseInt(op1[0]);
    	denominator1 = Integer.parseInt(op1[1]);
    	numerator2 = Integer.parseInt(op2[0]);
    	denominator2 = Integer.parseInt(op2[1]);
    	
    	int prodNum = numerator1 * numerator2;
    	int prodDen = denominator1 * denominator2;
    	product = prodNum + "/" + prodDen;
    	if(i < 0 && j < 0) {
    		product = prodNum + "/" + prodDen;
    	}
    	else if(i < 0 || j < 0) {
    		product = "-" + prodNum + "/" + prodDen;
    	}
    	return product;
    }
    
    public static String divideFrac(String[] arr1, String[] arr2) {
    	String quotient = "";
    	int whole1 = Integer.parseInt(arr1[0]);
    	int numerator1 = Integer.parseInt(arr1[1]);
    	int denominator1 = Integer.parseInt(arr1[2]);
    	int whole2 = Integer.parseInt(arr2[0]);
    	int numerator2 = Integer.parseInt(arr2[1]);
    	int denominator2 = Integer.parseInt(arr2[2]);
    	int i = whole1;
    	int j = whole2;
    	if(whole1 < 0) {
    		whole1 *= -1;
    	}
    	if(whole2 < 0) {
    		whole2 *= -1;
    	}
    	String operand1 = toImproperFrac(whole1, numerator1, denominator1);
    	String operand2 = toImproperFrac(whole2, numerator2, denominator2);
    	String[] op1 = operand1.split("/");
    	String[] op2 = operand2.split("/");
    	numerator1 = Integer.parseInt(op1[0]);
    	denominator1 = Integer.parseInt(op1[1]);
    	numerator2 = Integer.parseInt(op2[0]);
    	denominator2 = Integer.parseInt(op2[1]);
    	int quoNum = numerator1 * denominator2;
    	int quoDen = denominator1 * numerator2;
    	quotient = quoNum + "/" + quoDen;
    	if(i < 0 && j < 0) {
    		quotient = quoNum + "/" + quoDen;
    	}
    	else if(i < 0 || j < 0) {
    		quotient = "-" + quoNum + "/" + quoDen;
    	}
    	return quotient;
    }
}


