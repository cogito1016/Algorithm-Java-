package backjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostFix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String statement = br.readLine();
		
		Stack<Stack<Character>> stackList = new Stack<Stack<Character>>();
		stackList.add(new Stack<Character>());
		Stack<Character> thisStack;
		
		boolean lastFlag =false;
		
		for(int i=0;i<statement.length();i++) {
			
			thisStack = stackList.peek();
			char thisChar = statement.charAt(i);

			if(i==statement.length()-1) {
				lastFlag=true;
			}//if end
			
			if(thisChar>=65&&thisChar<=90) {
				System.out.print(thisChar);
				if(!thisStack.isEmpty()) {
					char beforeChar = (char) thisStack.peek();
					if(beforeChar=='*'||beforeChar=='/')
						System.out.print(thisStack.pop());
					else if((beforeChar=='+'||beforeChar=='-')&&lastFlag)
						System.out.print(thisStack.pop());
				}//if end
			}//피연산자
			else if(thisChar=='+'||thisChar=='-') {
				if(!thisStack.isEmpty()) {
					char beforeChar = (char) thisStack.peek();
					if(beforeChar=='+'||beforeChar=='-')
						System.out.print(thisStack.pop());
				}//if end
				thisStack.add(thisChar);
			}//'하'순위 연산자
			else if(thisChar=='*'||thisChar=='/') {
				thisStack.add(thisChar);
			}//'중'순위 연산자
			else if(thisChar=='(') {
				stackList.add(new Stack<Character>());
			}//'상'순위 연산자
			else if(thisChar==')') {
				if(!thisStack.isEmpty()) {
					char beforeChar = (char) thisStack.peek();
					if(beforeChar=='+'||beforeChar=='-')
						System.out.print(thisStack.pop());
				}//if end
				stackList.pop();
				
				thisStack= stackList.peek();
//				if(!thisStack.isEmpty()) {
//					char beforeChar = (char) thisStack.peek();
//					if(beforeChar=='+'||beforeChar=='-')
//						System.out.print(thisStack.pop());
//				}//if end
				while(!thisStack.isEmpty())
					System.out.print(thisStack.pop());
			}//'상'순위 연산자
		}//for end
		
		
		br.close();
	}//main() end
}//class end