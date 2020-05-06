package backjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronStick {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		
		char beforeChar = 0;
		int underIron=0;
		int pieceIron=0;
		for(int i=0;i<s.length();i++) {
			char thisChar = s.charAt(i);
			if(stack.isEmpty()||thisChar=='(') {
				beforeChar = thisChar;
				stack.add(thisChar);
				underIron++;
				continue;
			}
			
			underIron--;
			if(beforeChar==')')
				pieceIron+=1;
			else
				pieceIron+=underIron;
			beforeChar = thisChar;
			stack.pop();
		}//for end
		System.out.println(pieceIron);
		br.close();
	}//main() end
}//class end