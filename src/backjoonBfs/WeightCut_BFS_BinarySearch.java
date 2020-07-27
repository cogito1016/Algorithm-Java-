package backjoonBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeightCut_BFS_BinarySearch {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] islands = new int[N+1][N+1];
		int min=1000000000,max=0;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(islands[first][second]<weight) {
				if(weight<min)
					min=weight;
				if(weight>max)
					max=weight;
				islands[first][second]=weight;
				islands[second][first]=weight;
			}//if end
		}//for end 
		
		st = new StringTokenizer(br.readLine());
		int goalY = Integer.parseInt(st.nextToken());
		int goalX = Integer.parseInt(st.nextToken());
		
		int mid;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visit = new boolean[N+1];
		boolean possible = false;
		int result = 0;
		while(min<=max) {
			mid=(min+max)/2;
			queue.clear();
			Arrays.fill(visit,false);
			visit[goalY]=true;
			possible=false;
			
			for(int i=1;i<=N;i++) {
				if(islands[goalY][i]!=0 && islands[goalY][i]>=mid) {	
					queue.offer(i);
					visit[i]=true;
				}//if end
			}//for end 
			
			while(!queue.isEmpty()) {
				int thisIsland = queue.poll();
				if(thisIsland==goalX) {
					possible=true;
					break;
				}
				for(int i=1;i<=N;i++) {
					if(visit[i])
						continue;
					if(islands[thisIsland][i]!=0 && islands[thisIsland][i]>=mid) {
						if(i==goalX) {
							possible=true;
							break;
						}
						queue.offer(i);
						visit[i]=true;
					}//if end
				}//for end 
				if(possible)
					break;
			}//while end 
			
			if(possible) {
				result=min;
				min=mid+1;
			}else {
				max=mid-1;
			}
		}//while end 
		
		System.out.println(result);
		
		br.close();
	}//main() end
}
