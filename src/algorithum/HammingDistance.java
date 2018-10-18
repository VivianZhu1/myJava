package algorithum;

public class HammingDistance {

	/**
	 * x, y, 异或 XOR 结果为 1 的个数
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int getHammingDistance(int x, int y) {

		return Integer.bitCount(x ^ y);

	}

	

	public static int hammingWeight(int n) {
		int result = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				result++;
			}
			n >>>= 1;
		}
		return result;
	}

	public static void main(String[] args) {

		int x = 1; // 001
		int y = 5; // 101

//		System.out.println(x ^ y); // output is 100 :4

		int hmmingDis = getHammingDistance(x, y);
		System.out.println("hamming distance of " + x + "and " + y + " is " + hmmingDis);
		
		int number = 11;
		System.out.println("There're "+hammingWeight(number)+ " '1'(bitcount) in number "+number);
		

	}
}
