package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {

	static class Node{
		
		private int x,y;
		Node(int y,int x){
			
			this.x=x;
			this.y=y;
		}//cons end
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
	}//class end
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[y][x];
		boolean[][] visit = new boolean[y][x];
		int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<Node> queue = new LinkedList<Node>();
		
		int nonTomato=0;
		
		for(int i=0;i<y;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<x;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
				{
					queue.offer(new Node(i,j));
					visit[i][j]=true;
				}//if end
				
				if(map[i][j]==0)
					nonTomato++;
				
			}//for end
		}//for end
		
		
		Node node;
		int thisX,thisY,queueSize,days=0,min=x*y;
		
			
		while(!queue.isEmpty()) {
			
			queueSize = queue.size();
			for(int j=0;j<queueSize;j++) {
				node = queue.poll();
				for(int i=0;i<4;i++) {
					
					thisX= node.getX()+direct[i][1];
					thisY= node.getY()+direct[i][0];
					if(thisX>=x||thisX<0||thisY>=y||thisY<0)
						continue;
					if(visit[thisY][thisX])
						continue;
					if(map[thisY][thisX]==-1)
						continue;
					
					visit[thisY][thisX]=true;
					queue.offer(new Node(thisY,thisX));
					nonTomato--;
				}//for end
			}//for end
			days++;
		}//while end
		
		if(nonTomato==0)
			System.out.println(days-1);
		else
			System.out.println(-1);
		
		br.close();
	}//main() end
}//class end
