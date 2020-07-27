package backjoonDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WeightCut_DFS_FAIL {
	public static int max;
	
	public static void trace(int N,boolean[][] visited, int[][] map,int start,int goal,int value) {
		
		if(start==goal) {
			if(max<value)
				max=value;
			return;
		}//if end
		
		for(int i=1;i<=N;i++) {
			if(map[start][i]!=0 && !visited[start][i]) {
				visited[start][i]=true;
				visited[i][start]=true;
				int newValue = map[start][i]<value?map[start][i]:value;
				trace(N,visited,map,i,goal,newValue);
				visited[start][i]=false;
				visited[i][start]=false;
			}//if end
		}//for end
		
	}

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
			
			if(islands[first][second]<weight) {
				islands[first][second]=weight;
				islands[second][first]=weight;
			}//if end
		}//for end 
		
		st = new StringTokenizer(br.readLine());
		int goalY = Integer.parseInt(st.nextToken());
		int goalX = Integer.parseInt(st.nextToken());
		
		trace(N,visited,islands,goalY,goalX,1000000000);
		
		System.out.println(max);
		br.close();
	}//main() end
}
