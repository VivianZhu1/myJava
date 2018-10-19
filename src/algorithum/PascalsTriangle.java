package algorithum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
  In Pascal's triangle, each number is the sum of the two numbers directly above it.

	Input: 5
	
	Output:
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
	
 */
public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> allrows = new ArrayList<>();
		List<Integer> row = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			
			// every row has first elem as 1;
			row.add(0, 1);

			// replace sum elem at second place j start with 1,
			// since will use j+1 elem, so j< row.size()-1
			for (int j = 1; j < row.size() - 1; j++) {

				row.set(j, row.get(j) + row.get(j + 1));
			}
			allrows.add(new ArrayList<>(row));
		}
		return allrows;

	}
	
	public static void main(String[] args) {
		
		List<List<Integer>> list = new PascalsTriangle().generate(5);
		for (List<Integer> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
		}
		
	}

}
