package algorithum;

/**
    Reverse bits of a given 32 bits unsigned integer.

	Example:
	
	Input: 43261596
	Output: 964176192
	Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
	             return 964176192 represented in binary as 00111001011110000010100101000000.
	             
 */
public class ReverseBits {


	/**
	 * n不断右移位取末位，结果res不断左移位和n的末位取或，如此进行32次即可。考察简单的位运算。

	 * @return
	 */
	public int reverseBits(int n) {
		int res = n & 1;
		for (int i = 1; i < 32; i++) {
			n = n >> 1;
			res = res << 1;
			res = res | (n & 1);
		}
		return res;
	}
	  
	  
	public static void main(String[] args) {
		
		ReverseBits solution = new ReverseBits();
		
		int[] ary = {43261596,1,3,4,5}; 
		
		for (int i : ary) {
			System.out.println("Reverse"+i+" => "+solution.reverseBits(i));
		}
		
		
	}
}
