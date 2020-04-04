package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class BfsLedder {
	
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
		int rootX = 0;
		
		//입력부
		for(int test=0; test<10; test++) {
			
			Stack<Node> stack = new Stack<Node>();
			
			int[][] direct = new int[][] {{0,1},{1,0},{-1,0}};
			int[][] map = new int[100][100];
			boolean[][] visit = new boolean[100][100]; 
			int startX,startY,endX,endY;
			
			testCaseNum = Integer.parseInt(br.readLine());
			
			for(int i=0; i<100;i++) {
				String[] s =br.readLine().split(" ");
				for(int j=0;j<100;j++){

					map[i][j]=Integer.parseInt(s[j]);
					
					if(i==0) {
						int thisNum = map[0][j];
						
						if(thisNum==1){
							startX=j;
							startY=0;
							visit[startY][startX]=true;
							stack.push(new Node(startX,startY));
						}//if end
					}
					
				}//for end
			}//for end
			
	
			
			while(!stack.isEmpty()) {
				
				Node node = stack.pop();
				
				for(int j=0;j<3;j++) {
					int thisX = node.getX()+direct[j][0];
					int thisY = node.getY()+direct[j][1];
					
					if(thisX>=100||thisX<0||thisY>=100||thisY<0) {
						continue;
					}//if end
					if(map[thisY][thisX]==0) {
						continue;
					}//if end
					if(visit[thisY][thisX]==true) {
						continue;
					}//if end

					if(node.getY()==0) {
						rootX = node.getX();
						System.out.println("x는 "+node.getX()+" y는"+node.getY());
					}					
					
					if(map[thisY][thisX]==2) {
						result[test][0]=testCaseNum;
						result[test][1]=rootX;
						System.out.println("root 엑스좌표는"+rootX);
					}
					
					visit[thisY][thisX]=true;
					stack.push(new Node(thisX,thisY));
				}//for end
			}//while end
			
		}//for end

		br.close();
		
		//출력부
		for(int i=0;i<10;i++)
		{
			System.out.println("#"+result[i][0]+" "+result[i][1]);
		}
		
	}//main() end
}//class end
