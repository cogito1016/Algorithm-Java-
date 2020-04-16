package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class BfsMaze {
	
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
	
	public static void main(String[] args) throws IOException {

		

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		int[][] result = new int[10][2];
		
		int testCaseNum;

		//입력부
		for(int test=0; test<10; test++) {
			
			Queue<Node> queue = new LinkedList<Node>();
			
			int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
			int[][] map = new int[16][16];
			boolean[][] visit = new boolean[16][16]; 
			int startX,startY,endX,endY;
			int possibleState=0;
			
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
						queue.add(new Node(startX,startY));
					}else if(thisNum==3) {
						endX=j;
						endY=i;
					}//if~else end
				}//for end
			}//for end
			
	
			
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
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
					if(map[thisY][thisX]==3) {
						possibleState=1 ;
					}
					
					visit[thisY][thisX]=true;
					queue.add(new Node(thisY,thisX));
				}//for end
			}//while end
			

			result[test][0]=testCaseNum;
			result[test][1]=possibleState;
			possibleState=0;
		}//for end

		br.close();
		
		
		//출력부
		for(int i=0;i<10;i++) {
			System.out.println("#"+result[i][0]+" "+result[i][1]);
		}
	}//main() end
}//class end
