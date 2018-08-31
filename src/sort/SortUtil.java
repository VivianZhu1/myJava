package sort;

/**
 * 
 * 
 * @author vivianzhu
 *
 */
public class SortUtil {
	
	public static void main(String[] args) {
		
		int[] array= new int[]{11,10,33,42,12,34,5,23,6};
		System.out.println("Before sortation:" );
		for (int i : array) {
			System.out.print(i +",");
		}
		System.out.println("");

		SortUtil SortUtil = new SortUtil();
		
//		SortUtil.bubbleSort(array);
//		SortUtil.insertSort(array);
//		SortUtil.selectSort(array);
		SortUtil.quickSort(array);
		
		System.out.println("After sortation:" );
		for (int i : array) {
			System.out.print(i +",");
		}
	}
	
	/**
	 * 交换排序
	 * bubble sort, 
	 * Time: O(n^2)
	 * Space: O(1)
	 * Steady
	 * 
	 * @param a 
	 */
	public void bubbleSort(int[] a) {
		
		for(int i = 0 ;i< a.length; i++) {
			for(int j=i+1; j< a.length; j++) {
				if(a[i] > a[j]) {
					int temp = a[j];
					 a[j]= a[i];
					 a[i]=temp;
				}
			}
		}
	}
	
	/**
	 * 直接插入排序
	 * insert sort: assume first n-1 element is sorted already. T
	 * hen insert n element in to correct position.
	 * 
	 * Time O(n^2)
	 * Space: O(1)
	 * steady
	 * 
	 * @param a
	 */
	public void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i-1;
			// if a[i] <a[j], then backward move array
			for (; j>=0 && a[j] > temp ; j--) {
				a[j+1] = a[j];
			}
			a[j+1]=temp;
		}
	}
	
	/**
	 *
	 * 选择排序
	 * select sort: use first element as pivotkey, each time select smallest in rest n-1 elements
	 * 
	 * Given: 4,3,5,1,10
	 * 
	 * 1st: 1,3,5,4,10；
	 * 2nd: 1,3,5,4,10;
	 * 3rd: 1,3,4,5,10;
	 * 
	 *  * Time: O(n^2)
	 * Space: O(1)
	 * Steady
	 * 
	 * @param a
	 */
	public void selectSort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			int pivotkey = a[i];
			int index = i+1;
			int min = a[index];
			for(int j = i+1; j < a.length-1; j++) {
				if(a[j+1] < min) {
					min = a[j+1];
					index = j+1;
				}
			}
			a[i]= a[index];
			a[index] = pivotkey;
		}
	}
	
	/**
	 * Quick Sort: 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素
	 * 通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
	 * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
	 * 
	 * Time: O(n*log2n)~ O(n^2) (n*log以2为底，n的对数)
	 * Space:O(log2n)~O(n) (n*log以2为底，n的对数)
	 * Un-Steady
	 * 
	 * @param array
	 */
	public void quickSort(int[] array) {
		
		_quickSort(array, 0, array.length-1);
	}
	
	private void _quickSort(int[] a, int low, int high) {
		if(low < high){
			int middle = getMiddle(a, low, high);
			_quickSort(a, low, middle-1 );
			_quickSort(a, middle+1, high);
		}
	}
	
	private int getMiddle(int[] a , int low, int high) {
		
		int pivot = a[low];  
		while(low < high) {
			while(low < high && a[high]>= pivot) {
				high--;
			}
			a[low]=a[high];
			
			while(low < high && a[low]<= pivot) {
				low++;
			}
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}
	
}
