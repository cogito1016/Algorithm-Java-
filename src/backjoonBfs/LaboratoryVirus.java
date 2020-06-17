package backjoonBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LaboratoryVirus {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//Node class ned
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					queue.offer(new Node(i,j));
					visit[i][j]=true;
				}//if end
			}//for end
		}//for end
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			
			for(int i=0;i<queueSize;i++) {
				
				Node node = queue.poll();
				for(int j=0;j<4;j++) {
					int thisX = node.x + direct[j][1];
					int thisY = node.y + direct[j][0];
					
					if(thisX<0||thisX>=M||thisY<0||thisY>=N) 
						continue;
					if(visit[thisY][thisX])
						continue;
					if(map[thisY][thisX]==1)
						continue;
					
					visit[thisY][thisX]=true;
					map[thisY][thisX]=2;
					queue.offer(new Node(thisY,thisX));
				}//for end 
			}//for end 
			
			System.out.println();
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(map[i][j]+" ");
				}//for end
				System.out.println();
			}//for end
			
		}//while end
		
		
		br.close();
	}//main() end
}//class end