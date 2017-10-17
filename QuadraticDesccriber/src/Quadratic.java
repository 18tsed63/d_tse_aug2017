/* Darius Tse
 * 10.17.17
 * Describes a parabola
 */

//import java.util.*;

public class Quadratic {

public static double discriminant(double a, double b, double c){
	double discriminant = (b * b) - (4 * a * c);
		return discriminant;
}	

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
	
public static String quadForm(double a, double b, double c) {
	String k = "none";
	double x1;
	double x2;
	double d = discriminant(a, b, c);
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
	if(d == 0) {
		x1 = (-1 * b) + d;
		x1 = x1 / (2 * a);
		x1 = round2(x1);
		String j = x1 + " ";
		return j;
	}
	if(d < 0) {
		return k;
	}
		return k;
}	
	
public static String quadrDescriber(double a, double b, double c) {
	String heading = "Description of the graph of: ";
	String equation = "y = " + a + "x^2 + " + "(" + b + ")" + "x + " + c;
	//opens
	String open = "";
	if(a > 0) {
		open = "Opens: Up";
	}else if(a < 0){
		open = "Opens: Down";
	}else if(a == 0){
		open = "n/a";
	}
	//Axis Of Symmetry & vertex
	String AOS = "";
	String vertex = "";
	double vertexX = -b / 2 * a;
	double vertexY =  (a * vertexX * vertexX) - (b * vertexX) + c;
	AOS = "Axis of Symmetry: " + vertexX;
	vertex = "vertex: (" + vertexX + "," + vertexY + ")";
	//x-intercept & y-intercept
	String xInt = "";
	String yInt = "";
	xInt = "x-intercept(s): " + quadForm(a, b, c);
	yInt = "y-intercept: " + c;
	String quadrDescriber = heading+"\n"+equation+"\n"+open+"\n"+AOS+"\n"+vertex+ "\n" + xInt+"\n"+yInt;
	return quadrDescriber;
	}
}

