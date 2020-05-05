package backjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String statement = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		boolean highFlag = false;
		
		for(int i=0;i<statement.length();i++) {
			char thisChar = statement.charAt(i);
			if(thisChar>=65&&thisChar<=90) {
				System.out.print(thisChar);
				if(highFlag) {
					System.out.print(stack.pop());
					highFlag=false;
				}
				continue;
			}//피연산자
			
			highFlag=false;
			
			
			if(thisChar=='+'||thisChar=='-') {
				if(!stack.isEmpty()) {
					char beforeChar = stack.peek();
					if(beforeChar=='+'||beforeChar=='-')
						System.out.print(stack.pop());
				}
				stack.add(thisChar);
				continue;
			}//낮은 우선순위일때
			 
			if(thisChar=='*'||thisChar=='/'){
				highFlag=true;
				stack.add(thisChar);
				continue;
			}//높은 우선순위일때
			
			if(thisChar==')') {
				char beforeChar = stack.peek();
				if(beforeChar=='+'||beforeChar=='-')
					System.out.print(stack.pop());
				stack.pop();
				continue;
			}
			
			if(thisChar=='(')
				stack.add(thisChar);
		}//for end
		br.close();
	}//main() end
}//class end