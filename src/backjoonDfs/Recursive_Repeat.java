package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive_Repeat {

	static int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] map;
	static boolean[][] visit ;
	static int result;
	
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
		
	}//Node Class end
	
	public static void recursion(int y,int x) {
		
		Node node = new Node(y,x);
		int thisX,thisY;
		
		for(int i=0;i<4;i++) {
			thisX = node.getX()+direct[i][0];
			thisY = node.getY()+direct[i][1];
			
			if(thisX>=16||thisX<0||thisY>=16||thisY<0)
				continue;
			if(map[thisY][thisX]==1)
				continue;
			if(visit[thisY][thisX]==true)
				continue;
			if(map[thisY][thisX]==3) 
				result=1;
			
			visit[thisY][thisX]=true;
			recursion(thisY,thisX);
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		
		int startX = 0, startY = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test=0; test<10; test++) {
			map = new int[16][16];
			visit = new boolean[16][16];
			result = 0;
			
			int testNum = Integer.parseInt(br.readLine());
			 
			for(int i=0;i<16;i++) {
				String s = br.readLine();
				for(int j=0;j<16;j++) {
					
					map[i][j] = s.charAt(j)-'0';
					
					if(map[i][j]==2){
						startX=j;
						startY=i;
					}//if end
				}//for end
			}//for end
			
			visit[startY][startX]=true;
			
			recursion(startY,startX);
			
			System.out.println("#"+testNum+" "+result);
			
			
		}//for end
		
		br.close();
	}//main end
	
}//class end
