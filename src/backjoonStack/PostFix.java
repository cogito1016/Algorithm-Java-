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
		
		boolean firstFlag=false;
		for(int i=0;i<statement.length();i++) {
			char c = statement.charAt(i);
			if(c>=65 && c<=90) {
				System.out.print(c);
				if(firstFlag) 
					System.out.print(stack.pop());
				firstFlag=false;
				
			}else {
				if(c==')')
				{
					while(stack.peek()!='(')
						System.out.print(stack.pop());
					stack.pop();
				}else {			
					if(stack.peek()=='+'||stack.peek()=='-')
						System.out.print(stack.pop());
					stack.push(c);
				}

				if(c=='*'||c=='/')
					firstFlag=true;
				else
					firstFlag=false;
			}
		}//for end
		while(!stack.isEmpty())
			System.out.print(stack.pop());
		
		br.close();
	}//main() end
}//class end