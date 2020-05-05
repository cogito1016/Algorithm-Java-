package backjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackPractice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<test;i++) {
			st = new StringTokenizer(br.readLine());
			String instruction = st.nextToken();
			if(instruction.equals("push")) //push
				stack.push(Integer.parseInt(st.nextToken()));
			else if(instruction.equals("pop")) {
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
			}
			else if(instruction.equals("size"))
				System.out.println(stack.size());
			else if(instruction.equals("empty")) {
				System.out.println(stack.isEmpty()?1:0);
			}
			else if(instruction.equals("top")) {
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
			}
		}//for end
		
		br.close();
	}//main() end
}//class end