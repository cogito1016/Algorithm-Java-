package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		int max = 0;
		
		System.out.println(max);
		
		br.close();
	}//main() end
}
