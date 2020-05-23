package backjoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MakeOne {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int goal = Integer.parseInt(br.readLine());
		
		boolean[] visit = new boolean[goal+1];
		
//		int[] dp = new int[goal+1];
//		dp[2]=1; //2일경우 1이됨
//		dp[3]=1; //3일경우 1이됨
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(goal);
		visit[goal]=true;
		
		int result = -1;
		while(!queue.isEmpty()) {
			result++;
			int queueSize = queue.size();
			for(int i=0;i<queueSize;i++) {
			
				int thisVal = queue.poll();
				int top = 0;
				int bottom = 0;
				if(thisVal==1) {
					queue.clear();
					break;
				}//if end
				
				top = thisVal/2;
				bottom = thisVal%2;
				if(bottom==0 && !visit[top]) {
					queue.offer(thisVal/2);
					visit[top]=true;
				}//if end

				top = thisVal/3;
				bottom = thisVal%3;
				if(bottom==0 && !visit[top]) {
					queue.offer(thisVal/3);
					visit[top]=true;
				}//if end
	
				int nextVal = thisVal-1;
				if(!visit[nextVal]) {
					queue.offer(nextVal);
					visit[nextVal]=true;
				}//if end	
			}//for end 
		}//while end
		
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end