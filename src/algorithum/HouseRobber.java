package algorithum;

public class HouseRobber {
	
	public static void main(String[] args) {
		
		int[] nums = { 2,1,1,2,3,3,3,9,1 };
		
		HouseRobber robber = new HouseRobber();
		System.out.println(robber.rob(nums));
		
	}

	private int rob(int[] nums) {
//		 int[][] dp = new int[nums.length + 1][2];
//		    for (int i = 1; i <= nums.length; i++) {
//		        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
//		        dp[i][1] = nums[i - 1] + dp[i - 1][0];
//		    }
//		    return Math.max(dp[nums.length][0], dp[nums.length][1]);
		
		int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n > 2)
            nums[2] += nums[0];
        for (int i = 3; i < n; i++)
                nums[i] += Math.max(nums[i-2], nums[i-3]);
        return Math.max(nums[n-1], nums[n-2]);
		
	}

}
