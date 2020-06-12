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
		String str = br.readLine();
		
		int strLength = str.length();
		int targetIndex = 0;
		
		List<String> resultList = new Stack<String>();
		List<Stack<Character>> stackList = new Stack<Stack<Character>>();
		List<Boolean> firstFlagList = new Stack<Boolean>();
		
		firstFlagList.add(false);
		resultList.add(new String(""));
		stackList.add(new Stack<Character>());
		
		String result = resultList.get(0);
		Stack<Character> stack = stackList.get(0);
		boolean firstFlag = firstFlagList.get(0);
		
		while(targetIndex!=strLength) {
			
			char thisChar = str.charAt(targetIndex++);
			
			if((thisChar>=65 && thisChar<=90)) {
				result+=thisChar;
				if(firstFlag) {
					result+=stack.pop();
					firstFlag=false;
				}
			}else if( thisChar=='+' || thisChar=='-'){
				if(!stack.isEmpty()) {
					result+=stack.pop();
				}//if end
				stack.push(thisChar);
			}else if( thisChar=='*' || thisChar=='/'){
				stack.push(thisChar);
				firstFlag=true;
			}else{
				
				if(thisChar=='(') {

					resultList.set(resultList.size()-1,result);
					firstFlagList.set(firstFlagList.size()-1,firstFlag);
					
					resultList.add(new String(""));
					stackList.add(new Stack<Character>());
					firstFlagList.add(false);
					
					result = resultList.get(resultList.size()-1);
					stack = stackList.get(stackList.size()-1);
					firstFlag = firstFlagList.get(firstFlagList.size()-1);
				}else if(thisChar==')') {
					while(!stack.isEmpty()) {
						result+= stack.pop();
					}//while end 
					
					String temp = result ;

					resultList.remove(resultList.size()-1);
					stackList.remove(stackList.size()-1);
					firstFlagList.remove(firstFlagList.size()-1);

					result = resultList.get(resultList.size()-1)+temp;
					firstFlag = firstFlagList.get(firstFlagList.size()-1);
					stack = stackList.get(stackList.size()-1);
					
					if(firstFlag) {
						result+=stack.pop();
						firstFlag=false;
					}
						
				}//if~elseIf end
			}//If~elseIf~else end
		}//while end
		
		while(!stack.isEmpty()) {
			result+= stack.pop();
		}//while end 
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end