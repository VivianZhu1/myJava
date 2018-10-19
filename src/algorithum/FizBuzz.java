package algorithum;

import java.util.ArrayList;
import java.util.List;

public class FizBuzz {
	
	
	public List<String> fizzBuzz(int n) {
		
		List<String> res = new ArrayList<>();
		
		for(int i = 1; i<=n; i++) {
			if(i % 3 == 0 && i % 5 == 0)
				res.add("FizzBuzz");
			else if(i%5 ==0)
				res.add("Buzz");
			else if(i%3 == 0)
				res.add("Fizz");
			else
				res.add(Integer.toString(i));
		}
			
		return res;

	}
	
	public static void main(String[] args) {
		
		List<String> list = new FizBuzz().fizzBuzz(60);
		
		for (String string : list) {
			System.out.println(string);
		}
	}

}
