package backjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ps {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int i=0;i<test;i++) {
			
			String s = br.readLine();
			
			Stack<Character> stack = new Stack<Character>();
			
			for(int j=0;j<s.length();j++) {
				char thisChar = s.charAt(j);
				if(!stack.isEmpty()) {
					char beforeChar = stack.peek();
					if(thisChar!=beforeChar) {
						stack.pop();
					}else
						stack.add(thisChar);
				}
				else if(thisChar==')') {
					stack.add(thisChar);
					break;
				}else
					stack.add(thisChar);
			}//for end
			
			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}//for end
		
		br.close();
	}//main() end
}//class end