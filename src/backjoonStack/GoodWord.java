package backjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodWord {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int wordNum = Integer.parseInt(br.readLine());
		Stack<Character> stack;
		int result =0;
		
		for(int i=0;i<wordNum;i++) {
			String s = br.readLine();
			stack = new Stack<Character>();
			
			for(int j=0;j<s.length();j++) {
				char thisC = s.charAt(j);
				
				if(stack.isEmpty()) {
					stack.add(thisC);
					continue;
				}//if end
				
				char beforeC = stack.peek();
				if(beforeC==thisC)
					stack.pop();
				else
					stack.add(thisC);
			}//for end 
			
			if(stack.isEmpty())
				result++;
		}//for end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end