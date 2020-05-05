package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Maze_Repeat {
	
	static class Node{
		private int x,y;
		public Node(int y ,int x) {
			this.x=x;
			this.y=y;
		}
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
		
	}//Node Class end
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

		int[][] map = new int[16][16];
		int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0} };
		int startX = 0,startY = 0;
		int thisX,thisY;
		int isExist=0;
		
		Stack<Node> stack = new Stack<Node>();
		
		for(int test=0;test<10;test++) {
			
			boolean[][] visit = new boolean[16][16];
			int testNum = Integer.parseInt(br.readLine());
			isExist=0;
			
			for(int i=0; i<16; i++) {
				String str = br.readLine();
				for(int j=0;j<16;j++) {
					map[i][j]=str.charAt(j)-'0';
					if(map[i][j]==2){
						startY=i;
						startX=j;
					}//if end 
				}//for end
			}//for end
			
		
			stack.push(new Node(startY, startX));
			visit[startY][startX]=true;
			
			while(!stack.isEmpty()) {
				
				Node node = stack.pop();
				
				for(int i=0;i<4;i++) {
					thisX = node.getX()+direct[i][0];
					thisY = node.getY()+direct[i][1];
					
					if(thisX>=16||thisX<0||thisY>=16||thisY<0)
						continue;
					if(map[thisY][thisX]==1)
						continue;
					if(visit[thisY][thisX]==true)
						continue;
					
					if(map[thisY][thisX]==3) {
						isExist=1;
					}//if end
	
					visit[thisY][thisX]=true;
					stack.push(new Node(thisY,thisX));
					
				}//for end
				
				
			}//while end
			System.out.println("#"+(testNum)+" "+isExist);
		}//for end
		
		br.close();
	}//main end
}//class end
