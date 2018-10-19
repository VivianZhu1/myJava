package algorithum;

import java.util.HashMap;
import java.util.Map;

/**
    You are a product manager and currently leading a team to develop a new product. Unfortunately, 
    the latest version of your product fails the quality check. Since each version is developed based 
    on the previous version, all the versions after a bad version are also bad.

	Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all 
	the following ones to be bad.
	
	You are given an API boolean isBadVersion(version) which will return whether version is bad.
	Implement a function to find the first bad version. You should minimize the number of calls to the API.
	
	Example:
	
	Given n = 5, and version = 4 is the first bad version.
	
	call isBadVersion(3) -> false
	call isBadVersion(5) -> true
	call isBadVersion(4) -> true
	
	Then 4 is the first bad version. 
	
 */
public class FirstBadVersion {
	
	private Map<Integer, Boolean> versionMap;
	
	public FirstBadVersion(int n, int badVersion) {
		
		versionMap = new HashMap<>();
		
		 for(int i = 1; i<= n; i++) {
			 if(i<badVersion)
				 versionMap.put(i, true);
			 else
				 versionMap.put(i, false);
		 }
	}
	 
	/**
	 * NOTE:
	 * Since (left + right) / 2 can exceed the integer limit 
	 * whereas left + (right - left)/2 doesn't exceed the integer bounds.
	 * 
	 * @param n
	 * @return
	 */
	public int firstBadVersion(int n) {

		int start = 1, end = n;

        while(start<end){
            int mid = start+(end-start)/2;
            if(isBadVersion(mid))
                end = mid;
            else
                start =mid+1;
        }
         return end;
	}
	 
     /**
      * if get 'false' then this is a bad version
     * @param version
     * @return
     */
    public boolean isBadVersion(int version) {
    	 return !versionMap.getOrDefault(version,false);
     }
     
     public static void main(String[] args) {
    	 // mockup isBadversion api
    	 int totalVersion = 20;
    	 FirstBadVersion solution = new FirstBadVersion(totalVersion, 8);
    	 
    	 System.out.println("The first bad version is:"
    			 	+solution.firstBadVersion(totalVersion));
	}
}
