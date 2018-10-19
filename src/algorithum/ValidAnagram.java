package algorithum;

/**
	Given two strings s and t , write a function to determine if t is an anagram of s.

	Example 1:
	
	Input: s = "anagram", t = "nagaram"
	Output: true
	
	Example 2:
	
	Input: s = "rat", t = "car"
	Output: false
	
	Note:
	You may assume the string contains only lowercase alphabets.


 */
public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++)
			alphabet[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			alphabet[t.charAt(i) - 'a']--;
		for (int i : alphabet)
			if (i != 0)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		ValidAnagram solution = new ValidAnagram();
		
		String[][] strs = {{"listen","silent"},
							{"bar","baa"},
							{"yours","soury"}};
		
		
		for (String[] str : strs) {
			System.out.println("'"+str[0] +(solution.isAnagram(str[0], str[1])?"' IS ":"' ISN‘T ") 
								+"anagram of '"+str[1]+"'");
		}
		
		
	}

}
