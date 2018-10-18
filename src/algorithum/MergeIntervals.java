package algorithum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.ArrayUtils;
import util.Interval;

/**
    Given a collection of intervals, merge all overlapping intervals.

	Example 1:
	
	Input: [[1,3],[2,6],[8,10],[15,18]]
	Output: [[1,6],[8,10],[15,18]]
	Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
	Example 2:
	
	Input: [[1,4],[4,5]]
	Output: [[1,5]]
	Explanation: Intervals [1,4] and [4,5] are considered overlapping.
	
 */
public class MergeIntervals {
	
	 public List<Interval> merge(List<Interval> intervals) {
		 
		List<Interval> res = new ArrayList<>();
		
		int n = intervals.size();
		int[] start = new int[n];
		int[] end = new int[n];
		
		for (int i = 0; i < intervals.size(); i++) {
			start[i] = intervals.get(i).start;
			end[i] = intervals.get(i).end;
		}

		Arrays.sort(start);
		Arrays.sort(end);
		
		for(int i =0,j =0; i<n-1; i++) {
			// 如果后一个的start 比前一个的end大，则加入返回列表。因为用i+1来标识，所以i最大值取到n-2，
			if(i == n-1 || start[i+1] > end[i]) {
				res.add(new Interval(start[j], end[i]));
				j=i+1;
			}
		}
		return res;
	 }
	 
	 public static void main(String[] args) {
		MergeIntervals solution = new MergeIntervals();
		int[][] intervals ={{1,3},{2,6},{8,10},{15,18}};
		ArrayUtils.printMatrix(intervals, "Input intervals: ");
		List<Interval> list = genIntvaList(intervals);
		
		List<Interval> res = solution.merge(list);
		System.out.println(" Merged intervals:");
		for (Interval it : res) {
			System.out.println("["+it.start+" , "+it.end+"]");
		}
	}

	private static List<Interval> genIntvaList(int[][] intervals) {
		List<Interval> retList = new ArrayList<>();
		for (int[] is : intervals) {
			Interval itvl = new Interval();
			itvl.start = is[0];
			itvl.end = is[1];
			retList.add(itvl);
		}
		return retList;
	}

}
