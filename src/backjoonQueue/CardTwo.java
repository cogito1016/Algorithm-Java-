package backjoonQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CardTwo {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			queue.offer(i+1);
		}//for end

		
		for(int i=0;i<N;i++) {
			if(queue.size()==1)
				break;
			queue.poll();
			if(queue.size()==1)
				break;
			int top = queue.poll();
			queue.offer(top);
		}//for end

		System.out.println(queue.poll());
		br.close();
	}//main() end
}//class end