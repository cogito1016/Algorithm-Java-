package backjoonImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class KeyLogger_Refactoring {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- >0) {
		
			String s = br.readLine();
			Stack<Character> mainStack = new Stack<Character>();
			Stack<Character> tempStack = new Stack<Character>();
			
			for(int i=0;i<s.length();i++) {
				
				char c = s.charAt(i);
				
				if(c=='<') {
					if(!mainStack.isEmpty())
						tempStack.push(mainStack.pop());
					continue;
				}else if(c=='>') { 
					if(!tempStack.isEmpty())
						mainStack.push(tempStack.pop());
					continue;
				}else if(c=='-') {
					if(!mainStack.isEmpty())
						mainStack.pop();
					continue;
				}//if~elseIf~elseIf end
				
				mainStack.push(c);
			}//for end

			for(char c : mainStack) {
				bw.write(c);
			}//for end		

			while(!tempStack.isEmpty()) {
				bw.write(tempStack.pop());
			}//for end
			bw.newLine();
			bw.flush();
		}//while end
		
		br.close();
		bw.close();
	}//main() end
}
