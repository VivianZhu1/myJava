package algorithum;

/**
	Return the index of the first occurrence of needle in haystack,
	or -1 if needle is not part of haystack.
	
	Example 1:
	Input: haystack = "hello", needle = "ll"
	Output: 2
	
	Example 2:
	Input: haystack = "aaaaa", needle = "bba"
	Output: -1
	
	Clarification:
	What should we return when needle is an empty string? 
	For the purpose of this problem, we will return 0 when needle is an empty string. 
	This is consistent to C's strstr() and Java's indexOf().
	
 */
public class Strstr {
	
	public  int strStr(String haystack, String needle) {

        if(needle == null || needle.isEmpty())
            return 0;


        if(needle.length() > haystack.length())
            return -1;

        int index = -1;

        for(int i = 0; i<haystack.length();i++) {
            int count = 0;
            for(int j = 0, k = i; j<needle.length(); j++) {
                if(needle.charAt(j) != haystack.charAt(k)) {
                    break;
                }else {
                    count++;
                    k++;
                }
            }
            if(count == needle.length()) {
                index = i;
                return index;
            }
        }
        return index;

	}
	
	
	public static void main(String[] args) {
		
		Strstr solution = new Strstr();
		
		String[][] strs = {{"mississippi","mississippi"},
					  {"","a"},
					  {"",""}};
		
		for (String[] str : strs) {
			String haystack = str[0];
			String needle = str[1];
			System.out.println("String indexOf() output: "+ haystack.indexOf(needle));
			System.out.println("Strstr strStr() output: "+ solution.strStr(haystack, needle));
		}
	}

}
