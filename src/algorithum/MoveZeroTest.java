package algorithum;

public class MoveZeroTest {
	
	public static void main(String[] args) {
		
		MoveZeroTest test = new MoveZeroTest();
		
		int[] nums = {0,12,3,0,6,9};
		
		test.moveZero(nums);
		
		for (int i : nums) {
			System.out.print(i+" , ");
		}
	}
	
	
	public void moveZero(int[] nums) {
		
		int head = 0;
		int tail = nums.length-1;
		int length = nums.length;
		
		while( tail > 0 && head < length && tail > head) {
			
			while(nums[head] != 0)
				head++;
			
			while(nums[tail] == 0) {
				tail--;
			}
			
			if(nums[head] == 0 && nums[tail] !=0 && head < tail) {
				int temp = nums[tail];
				nums[tail] = nums[head];
				nums[head] = temp;
				length--;
			}
			
		}
	}

}
