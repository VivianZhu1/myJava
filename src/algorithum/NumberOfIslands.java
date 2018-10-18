package algorithum;

import util.ArrayUtils;

/**
 *给定一个2维数字表格，其中'1'代表岛，'0'代表水，要求计算岛的数量。一个岛被水包围着，
 *其上下左右的格子是1的话也算同一个岛。你可以假设表格的四个边外都是水。
	
	Example 1:
	
	Input:
	11110
	11010
	11000
	00000
	
	Output: 1
	
	Example 2:
	
	Input:
	11000
	11000
	00100
	00011
	
	Output: 3

 */
public class NumberOfIslands {
	private int n;
	private int m;
	
	public int numIslands(char[][] grid) {
	    int count = 0;
	    n = grid.length;
	    if (n == 0) return 0;
	    m = grid[0].length;
	    for (int i = 0; i < n; i++){
	        for (int j = 0; j < m; j++)
	            if (grid[i][j] == '1') {
	                DFSMarking(grid, i, j);
	                ++count;
	            }
	    }    
	    return count;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
	    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
	    grid[i][j] = '0';
	    DFSMarking(grid, i + 1, j);
	    DFSMarking(grid, i - 1, j);
	    DFSMarking(grid, i, j + 1);
	    DFSMarking(grid, i, j - 1);
	}
	
	public static void main(String[] args) {
		NumberOfIslands solution = new NumberOfIslands();
		
		char[][] islands = {{'1','1','1','1','0'},
							{'1','1','0','1','0'},
							{'1','1','0','0','0'},
							{'0','0','0','0','0'}};
		ArrayUtils.printMatrix(islands, "input islands:");
		System.out.println("islands number:"+solution.numIslands(islands));
		
		System.out.println();
		
		char[][] islands2 = {{'1','1','0','0','0'},
							{'1','1','0','0','0'},
							{'0','0','1','0','0'},
							{'0','0','0','1','1'}};
		ArrayUtils.printMatrix(islands2, "input islands:");
		System.out.println("islands number:"+solution.numIslands(islands2));
		
		
	
	}
}
