package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsStartLink {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int totalHeight = Integer.parseInt(st.nextToken());
		int thisHeight = Integer.parseInt(st.nextToken())-1;
		int goalHeight = Integer.parseInt(st.nextToken())-1;
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken())*-1;
		
		int[] direct = {up,down};
		boolean[] visit = new boolean[totalHeight];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(thisHeight);
		visit[thisHeight]=true;
		int nextHeight;
		int result=0; 
		boolean flag = false;
		while(!queue.isEmpty()) {
			if(thisHeight==goalHeight) {
				flag=true;
				break;
			}//if end
			int queueSize=queue.size();
			result++;
			for(int a=0;a<queueSize;a++) {
				if(queue.isEmpty())
					break;
				int node = queue.poll();
				for(int i=0;i<2;i++) {
					nextHeight = node+direct[i];
					if(nextHeight<0||nextHeight>=totalHeight)
						continue;					
					if(visit[nextHeight])
						continue;
					if(nextHeight==goalHeight){
						flag=true; 
						queue.clear();
						break;
					}//if end
					
					visit[nextHeight]=true;
					queue.add(nextHeight);
				}//for end
			}//for end
		}//while end
		if(flag)
			System.out.println(result);
		else
			System.out.println("use the stairs");
		br.close();
	}//main() end
}//class end