package backjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PsRepeat {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		Stack<Character> stack = null;
		String s;
		for(int i=0; i<test;i++) {
			stack = new Stack<Character>();
			s=br.readLine();
			for(int j=0;j<s.length();j++) {
				char thisChar = s.charAt(j);
				if(stack.isEmpty()) {
					if(thisChar==')') {
						stack.add(thisChar);
						break;
					}//if end
					else {
						stack.add(thisChar);
					}
				}//if end
				else{
					char beforeChar=stack.peek();
					if(beforeChar!=thisChar)
						stack.pop();
					else
						stack.add(thisChar);
				}//if~else end
			}//for end


			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}//for end
		
		br.close();
	}//main() end
}//class end