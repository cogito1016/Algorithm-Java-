package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsHideGame {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int subin=Integer.parseInt(st.nextToken());
		int slave=Integer.parseInt(st.nextToken());
		int size = 100000+10;
		
		boolean[] visit = new boolean[size];
		int[] direct = {1,-1};
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(subin);
		visit[subin]=true;
		int result =0;
		
		while(!queue.isEmpty()) {
			if(subin==slave)
				break;
			int queueSize = queue.size();
			result++;
			for(int i=0;i<queueSize;i++) {
				if(queue.isEmpty()) 
					break;
				
				int node = queue.poll();
				
				for(int a=0;a<3;a++) {
					int nextLoc;
					if(a==2)
						nextLoc = node*2;
					else
						nextLoc = node+direct[a];
					if(nextLoc>=size||nextLoc<0)
						continue;
					if(visit[nextLoc])
						continue;
					if(nextLoc==slave) {
						queue.clear();
						break;
					}//if end
						
					visit[nextLoc]=true;
					queue.offer(nextLoc);
				}//for end
			}//for end
		}//while end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end