package algorithum;

import java.util.Deque;
import java.util.LinkedList;

/**
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
    determine if the input string is valid.

	An input string is valid if:
	
	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
	Note that an empty string is also considered valid.
	
	Example 1:
	
	Input: "()"
	Output: true
	
	Example 2:
	
	Input: "()[]{}"
	Output: true
 *
 */
public class ValidParentheses {
	
	public boolean isParentheses(String s) {
		
		Deque<Character> stack = new LinkedList<>();
		
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if(c =='(')
				stack.push(')');
			else if(c == '[')
				stack.push(']');
			else if(c == '{') {
				stack.push('}');
			}else if(stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		
		ValidParentheses solution = new ValidParentheses();
		String[] strings = {"()[]{}","[()]","([})"};
		
		for (String str : strings) {
			System.out.println("input String: ’"+str+ (solution.isParentheses(str)?"‘  IS  ":"’  ISN‘T  ")
								+"valid parentheses!");
			
			
		}
		
	}

}
