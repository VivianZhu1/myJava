package algorithum;

import util.ArrayUtils;

/**
 * Roman important number is 1,4,5,9 => 10,40,50,90 ...
 *  I 1
 *  V 5
 *  X 10
 *  L 50
 *  C 100
 *  D 500
 *  M 1000
 *  
 *  the ith element > the i+1 elements then  value = ith+ (i+1)th
 *  eg. XI, X > I, then X + I = 11
 *  
 *  otherwise, value = ith - (i+1)th
 *  eg. IX, I < X, then X - I = 9
 *  
 */
public class IntegerToRoman {

	public String intToRoman(int num) {

		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num -= values[i];
				sb.append(strs[i]);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
	
		IntegerToRoman solution = new IntegerToRoman(); 
		
		int[] nums = {3,4,9,11,58,1994};
		ArrayUtils.printArray(nums, "convert integer to Roman");
		for (int i : nums) {
			System.out.println(solution.intToRoman(i)+ "     ("+i+")");
		}
	}

}
