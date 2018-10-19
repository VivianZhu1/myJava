package algorithum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 统计小于非负整数n的素数的个数。
 * 
 * Count the number of prime numbers less than a non-negative number, n. prime:
 * the number can only multiple by 1 and itself
 * 
 * Example:
 * 
 * Input: 10 Output: 4 Explanation: There are 4 prime numbers less than 10, they
 * are 2, 3, 5, 7.
 * 
 */
public class CountPrime {

	private List<Integer> list = new ArrayList<>();

	public int countPrimes(int n) {

		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (notPrime[i] == false) {
				count++;
				list.add(i);
				for (int j = 2; i * j < n; j++) {
					notPrime[i * j] = true;
				}
			}
		}
		return count;
	}

	public int countPrimes1(int n) {

		if (n <= 1) {
			return 0;
		}

		// 默认所有的元素值都会设置为false
		boolean[] notPrime = new boolean[n];
		notPrime[0] = true;
		notPrime[1] = true;

		for (int i = 2; i * i < n; i++) {
			// 如果i是一个质数，i将i的倍数设置为非质数
			// 如是i是一个合数，则它必定已经设置为true了，因为是从2开始处理的
			if (!notPrime[i]) {
				for (int j = 2 * i; j < n; j += i) {
					notPrime[j] = true;
				}
			}
		}

		// 统计质数的个数
		int result = 0;

		for (int i = 0; i < notPrime.length; i++) {
			if (!notPrime[i]) {
				result++;
				list.add(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		CountPrime solution = new CountPrime();
		int bound = 10;
		int n = solution.countPrimes(bound);
		System.out.println("Print count: " + n);
		System.out.println("primes in " + bound + " : " + Arrays.toString(solution.list.toArray()));
	}

}
