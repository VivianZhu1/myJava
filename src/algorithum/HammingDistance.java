package algorithum;

public class HammingDistance {

	/**
	 在信息论中，两个等长字符串之间的汉明距离（英语：Hamming distance）是两个字符串对应位置的不同字符的个数。
	 换句话说，它就是将一个字符串变换成另外一个字符串所需要替换的字符个数。
	 对于二进制字符来说， 就是bit不同值得个数， 一下汉明距离为 x^y = 1(异或， 相异为1)
	 	int x = 1; // 001
		int y = 5; // 101

	 汉明重量是字符串相对于同样长度的零字符串的汉明距离，也就是说，它是字符串中非零的元素个数：
	 对于二进制字符串来说，就是1的个数，所以11101的汉明重量是4。
	 
	 
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
