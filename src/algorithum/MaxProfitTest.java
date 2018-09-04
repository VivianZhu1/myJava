package algorithum;

public class MaxProfitTest {

	public static void main(String[] args) {
//		int[] stock = { 7, 1, 5, 3, 6, 4 };
		int[] stock = {7,6,4,3,1 };


		int profit = MaxProfitTest.maxProfit(stock);
		System.out.println(profit);
	}

	public static int maxProfit(int[] prices) {

		int min = prices[0];
		int mindex = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
				mindex = i;
			}
		}

		int max = prices[mindex];
		int mandex = mindex ;
		for (int j = mindex ; j < prices.length; j++) {
			if (prices[j] > max) {
				max = prices[j];
				mandex = j;
			}
		}

		if (max <= min)
			return 0;
		else
			return max - min;
	}

}