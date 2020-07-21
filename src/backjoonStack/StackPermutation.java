package backjoonStack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackPermutation {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<N;i++) {
			queue.offer(Integer.parseInt(br.readLine()));
		}//for end
		
		char[] result = new char[2*N];
		int resultIdx = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=1;i<=N;i++) {
			stack.add(i);
			result[resultIdx++]='+';
			
			while(stack.peek().intValue()==queue.peek().intValue()) {
				stack.pop();
				queue.poll();
				result[resultIdx++]='-';
				if(stack.isEmpty())
					break;
			}//if end
		}//for end
		
		
		if(queue.isEmpty()){
			for(char c : result)
				System.out.println(c);
		}else
			System.out.println("NO");
		
		
		br.close();
	}//main() end
}
