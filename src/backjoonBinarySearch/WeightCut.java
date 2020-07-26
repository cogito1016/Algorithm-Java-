package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeightCut {
	
	static class Node{
		int x,y,possibleWeight;
		Node(int y,int x, int possibleWeight){
			this.x=x;
			this.y=y;
			this.possibleWeight=possibleWeight;
		}//cons end
	}//Node class end

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] islands = new int[N+1][N+1];
		boolean[][] visited = new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			islands[first][second]=weight;
			islands[second][first]=weight;
		}//for end 
		
		st = new StringTokenizer(br.readLine());
		int goalY = Integer.parseInt(st.nextToken());
		int goalX = Integer.parseInt(st.nextToken());

		
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i=1;i<=N;i++) {
			if(islands[goalY][i]!=0) {
				queue.offer(new Node(goalY,i,islands[goalY][i]));
				visited[goalY][i]=true;
				visited[i][goalY]=true;
			}//if end
		}//for end 
		
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.print(islands[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.print(visited[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		int max = 0;
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			if(node.x==goalX && node.possibleWeight>max) {
				max=node.possibleWeight;
				continue;
			}//if end
			
			for(int i=1;i<=N;i++) {
				
				int thisY = node.x;
				int thisX = i;
				
				if(visited[thisY][thisX] || visited[thisX][thisY])
					continue;
				if(islands[thisY][thisX]==0)
					continue;
				
				int weight = node.possibleWeight>islands[thisY][thisX]? islands[thisY][thisX] : node.possibleWeight;
				
				queue.offer(new Node(thisY,thisX,weight));
				visited[thisY][thisX]=true;
				visited[thisX][thisY]=true;
			}//for end 
		}//while end 
		
		System.out.println(max);
		
		br.close();
	}//main() end
}
