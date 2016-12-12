import com.codingpan.leetcode.passedOJ.HappyNumber2;


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
	
	
	public static void main(String[] args) {
		HappyNumber2 testHappyNumber = new HappyNumber2();
		for (Integer i : testNums) {
			if (testHappyNumber.isHappy(i)) {
				System.out.println(i + " is happy #");
			} else {
				System.out.println(i + " is not happy #");

			}
		}
		
	}

}
