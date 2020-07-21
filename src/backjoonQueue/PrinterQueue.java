package backjoonQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(T-- >0) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] values = new int[N];
			Queue<Integer> queue = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int thisNum = Integer.parseInt(st.nextToken());
				values[i] = thisNum;
				queue.offer(thisNum);
			}//for end
			
			Arrays.sort(values);
			int valuesIdx = N-1;
			int result = 0;
			
			while(!queue.isEmpty()) {
				
				int thisValue = queue.poll();
				
				if(thisValue == values[valuesIdx]) {
					result++;
					valuesIdx--;
					if(M==0)
						break;
				}else {
					queue.offer(thisValue);
					if(M==0)
						M=queue.size();
				}//if~else end
				M--;
			}//while end
			
			System.out.println(result);
		}//while end
		
		br.close();
	}//main() end 
}
