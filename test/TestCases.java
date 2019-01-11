import com.codingpan.leetcode.passedOJ.LC202HappyNumber;
import edu.princeton.cs.algs4.StdOut;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;


public class TestCases {
	//Arrays
	//Integer
	int[] num0 = {1, 2};
	int[] num1 = {2, 1};
	int[] num2 = {1, 2, 3};
	int[] num3 = {3, 2, 1};
	int[] num4 = {-1, 1, 1, 1, 2, 1};
	int[] num5 = {-32, 2 , 4, 6, 8, 10, -2 , 5, 0, 31, 1, -3, -1, -5, -1};
 	int[] num6 = {0, 0, 0, 0};
 	int[] num7 = {-2,0,1,1,2};
 	
 	//String
 	String[] s0 = {"()()", "()[]{}", "()"};
	String[] s1 = {"([)]", "(]"};
	
	// Happy number test
	static int[] testNums = {19, 0, 1, -1, -9, 20};


	public static boolean isValidNumber(String s) {
		boolean isValid = false;
		try {
			Double.parseDouble(s);
			isValid = true;
		} catch (NumberFormatException e) {

		}
		return isValid;
	}
	
	
	public static void main(String[] args) {
//		LC202HappyNumber testHappyNumber = new LC202HappyNumber();
//		for (Integer i : testNums) {
//			if (testHappyNumber.isHappy(i)) {
//				System.out.println(i + " is happy #");
//			} else {
//				System.out.println(i + " is not happy #");
//
//			}
//		}

//		String s = ".00";
//		StdOut.println(isValidNumber(s));
//
//		DecimalFormat priceFormat = new DecimalFormat("0.0000");
//		priceFormat.format(Double.valueOf(s));


		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2019);
		cal.set(Calendar.MONTH, 3);	// 0 - 11 -> Jan - Dec
		cal.set(Calendar.DATE, 5);

		Date dt1 = cal.getTime();
		Date dt2 = cal.getTime();
		StdOut.println(dt1 == dt2);
		StdOut.println(dt1.hashCode() + ", " + dt2.hashCode());
		StdOut.println(dt1 + ", " + dt2);
		StdOut.println(dt1.equals(dt2));
	}

}
