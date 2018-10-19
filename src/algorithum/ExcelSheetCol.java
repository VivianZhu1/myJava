package algorithum;

/**
 *  Given a column title as appear in an Excel sheet, return its corresponding column number.

		For example:
		
		    A -> 1
		    B -> 2
		    C -> 3
		    ...
		    Z -> 26
		    AA -> 27
		    AB -> 28 
		    ...
		    
		Example 1:
		Input: "A"
		Output: 1
		
		Example 2:
		Input: "AB"
		Output: 28
		
		Example 3:
		Input: "ZY"
		Output: 701
		
 */
public class ExcelSheetCol {
	
	public static void main(String[] args) {
		
		ExcelSheetCol sol = new ExcelSheetCol();
		
		String[] arys = {"A","AZ","ZA","AAA"};
		for (String str : arys) {
			System.out.println(sol.titleToNumber(str));
		}
	}

	
	public int titleToNumber(String s) {
	    int result = 0;
	    for(int i = 0 ; i < s.length(); i++) {
	      result = result * 26 + (s.charAt(i) - 'A' + 1);
	    }
	    return result;
	  }
}
