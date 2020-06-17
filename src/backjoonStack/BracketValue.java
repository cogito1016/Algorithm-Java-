package backjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BracketValue {

	//(40 )41 [91 ]93
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		Stack<Character> stack = new Stack<Character>();
		
		stack.push(s.charAt(0));
		char beforeC = s.charAt(0);
		int level = 0;
		int[] levelArr = new int[30];
				
		for(int i=1;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(c=='[' || c=='(') {
				level++;
				stack.push(c);
				beforeC=c;
				continue;
			}//if end 열때

			if(stack.isEmpty()) {
				stack.push(c);
				beforeC=c;
				continue;
			}//if end 비어있을때
			
			char checkC = stack.peek();
			if(c==')' && checkC=='(') {
				stack.pop();
				if(beforeC=='(')
					levelArr[level]+=2;
				else {
					levelArr[level]+=levelArr[level+1]*2;
					levelArr[level+1]=0;
				}
			}//if end 소괄호 닫을때
			else if(c==']' && checkC=='[') {
				stack.pop();
				if(beforeC=='[')
					levelArr[level]+=3;
				else {
					levelArr[level]+=levelArr[level+1]*3;
					levelArr[level+1]=0;
				}
			}//if end 대괄호 닫을때
			else {
				break;
			}
			
			level--;
			beforeC=c;
		}//for end
		
		
		if(stack.isEmpty())  
			System.out.println(levelArr[0]);
		else
			System.out.println("0");
		
		br.close();
	}//main() end
}//class end