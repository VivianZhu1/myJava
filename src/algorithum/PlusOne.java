package algorithum;

import java.util.Arrays;

public class PlusOne {

	/**
	 * math method cannot handle value extends Long.max_value
	 * 
	 * @param digits
	 * @return
	 */
	public int[] plusOne1(int[] digits) {

		long base = 1;
		long sum = 0;
		
		for (int i = digits.length - 1; i >= 0; i--) {
			sum += digits[i] * base;
			base *= 10;
		}
		
		String sumVal = Long.toString(sum+1);
		int[] res = new int[sumVal.length()];

		for(int j = 0; j< sumVal.length(); j++) {
			int newdigit =  sumVal.charAt(j) - '0' ;
			res[j]= newdigit;
		}

		return res;
	}
	
	
	public int[] plusOne(int[] digits) {
        
	    int n = digits.length;
	    
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        
	        digits[i] = 0;
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
	
	public static void main(String[] args) {
		
		PlusOne solution = new PlusOne();
		
		int[][] ary = { {1,1,9},
						{9,8,7,6,5,4,3,2,1,0},
						{3,2,1},
						{4,3,2,1},
						{9,9,9,9} };
		
		for (int[] is : ary) {
			System.out.println(Arrays.toString(solution.plusOne(is)));
		}
	}
}
