package algorithum;

/**
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

	Note: For the purpose of this problem, we define empty string as valid palindrome.
	
	Example 1:
	Input: "A man, a plan, a canal: Panama"
	Output: true
	
	Example 2:
	Input: "race a car"
	Output: false
	
 */
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s.length() == 1)
			return true;
		
		// remove space and punctuation char.
		String clear = s.toLowerCase().replaceAll("\\p{Punct}", "").replaceAll(" ", "");
		int left = 0;
		int right = clear.length() - 1;
		while (left < right) {
			if (clear.charAt(right) == clear.charAt(left)) {
				left++;
				right--;
			} else
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		ValidPalindrome solution = new ValidPalindrome();
		
		String[] strs = {"A man, a plan, a canal: Panama", "race a car"};
		
		for (String str : strs) {
			System.out.println("'"+str +(solution.isPalindrome(str)?"'  IS ":"'  ISN'T ")+ " valid palindrome");
		}
		
		
		
	}
	
	

}
