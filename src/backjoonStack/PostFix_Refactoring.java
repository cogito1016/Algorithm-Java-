package backjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFix_Refactoring {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<Character>(); 
		
		for(int i=0;i<s.length();i++) {
			
			char thisChar = s.charAt(i);
			
			if(thisChar>='A'&&thisChar<='Z') {
				
				System.out.print(thisChar);
			}else if(thisChar=='*'||thisChar=='/') {
				
				if(!stack.isEmpty()) {
					if(stack.peek()=='*'||stack.peek()=='/') {
						System.out.print(stack.pop());
					}//if end
				}//if end	
				stack.push(thisChar);
			}else if(thisChar=='+'||thisChar=='-') {
				while(!stack.isEmpty() && (stack.peek()=='*'||stack.peek()=='/'||stack.peek()=='+'||stack.peek()=='-') ) {
					System.out.print(stack.pop());
				}//if end	
				stack.push(thisChar);
			}else if(thisChar==')') {
				
				while(stack.peek()!='(') {
					System.out.print(stack.pop());
				}//while end
				stack.pop();
			}else if(thisChar=='('){
				stack.push(thisChar);
			}//if end
			
		}//for end
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}//while end
		
		br.close();
	}//main() end
}//class end