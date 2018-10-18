package algorithum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

	public List<List<Integer>> permute_bk(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	
	/**
	 * backtrace 每次建构在之前建构的基础上存入新数字，构成新的组合
	 * @param num
	 * @return
	 */
	public List<List<Integer>> permute(int[] num) {
	    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
	    res.add(new ArrayList<Integer>());
	    // 逐一加入新数，构成新的组合
	    for (int n : num) {
	    	int size = res.size();
	    	// 逐一取出之前的组合
	        for (; size > 0; size--) {
	            List<Integer> r = res.pollFirst();
	            // 逐一加入不同的位置
	            for (int i = 0; i <= r.size(); i++) {
	                List<Integer> t = new ArrayList<Integer>(r);
	                t.add(i, n);
	                res.add(t);
	            }
	        }
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		int[] ary = {1,2,3};
		System.out.println("Input array is: "+ Arrays.toString(ary));
		List<List<Integer>> List = new Permutation().permute(ary);
		
		System.out.println("Permutation of the array is:");
		for (List<Integer> l : List) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

}
