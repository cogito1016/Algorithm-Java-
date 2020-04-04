package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;

public class DfsMazeRecursive {
	static int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] map;
	static boolean[][] visit;
	static int result;
	
	static class Node{
		int x,y;
		Node(int x, int y){
			this.x =x ;
			this.y =y ;
		}//Node() end
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
	}//Node end
	
	public static void recursion(int x, int y) {

		Node node = new Node(x,y);
		
		if (map[y][x] == 3) {
			result =1;
			return;
		}//if end
		
		for(int j=0;j<4;j++) {
			int thisX = node.getX()+direct[j][0];
			int thisY = node.getY()+direct[j][1];
			
			if(thisX>=16||thisX<0||thisY>=16||thisY<0) {
				continue;
			}//if end
			if(map[thisY][thisX]==1) {
				continue;
			}//if end
			if(visit[thisY][thisX]==true) {
				continue;
			}//if end
			
			visit[thisY][thisX]=true;
			recursion(thisX, thisY);
			
		}//for end
		
	}//recursion end
	
	public static void main(String[] args) throws IOException {

		

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
//		int[][] result = new int[10][2];
		
		int testCaseNum;

		//입력부
		for(int test=0; test<10; test++) {
			
			Stack<Node> stack = new Stack<Node>();
			
			
			map = new int[16][16];
			visit = new boolean[16][16]; 
			int startX = 0,startY = 0,endX,endY;

			result = 0;
			
			testCaseNum = Integer.parseInt(br.readLine());
			
			for(int i=0; i<16;i++) {
				String s =br.readLine();
				for(int j=0;j<16;j++){
					map[i][j]=s.charAt(j)-'0';
					
					int thisNum = map[i][j];
					
					if(thisNum==2){
						startX=j;
						startY=i;
						visit[j][i]=true;
						stack.push(new Node(startX,startY));
					}else if(thisNum==3) {
						endX=j;
						endY=i;
					}//if~else end
				}//for end
			}//for end
			
			//리커시브
			recursion(startX, startY);
			System.out.println("#"+testCaseNum+" "+result);
		}//for end

		br.close();
	}//main() end
}//class end
