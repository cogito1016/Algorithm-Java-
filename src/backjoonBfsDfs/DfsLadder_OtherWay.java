package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DfsLadder_OtherWay {
	
	static class Node{
		int x,y;
		
		Node(int y, int x){
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
		
		
	}//class Node end

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int[][] direct = new int[][] {{0,1},{0,-1},{-1,0}};
		
		for(int test=0;test<10;test++) {
			
			int testNum = Integer.parseInt(br.readLine());
			Stack<Node> stack = new Stack<Node>();
			int[][] map = new int[100][100];
			boolean[][] visit = new boolean[100][100];
			int startX=0, startY=0, thisX,thisY, resultX = 0;
			for(int i=0;i<100; i++) {
				String[] s =br.readLine().split(" ");
				
				for(int j=0;j<100;j++) {
					map[i][j]= Integer.parseInt(s[j]);
					
					if(map[i][j]==2) {
						startX=j;
						startY=i;
					}//if end
				}//for end
			}//for end
			
	
			stack.push(new Node(startY,startX));
			visit[startY][startX]=true;
			
			
			while(!stack.isEmpty()) {
				
				Node node = stack.pop();
				
				for(int i=0;i<3;i++) {
					
					thisX= node.getX()+direct[i][1];
					thisY= node.getY()+direct[i][0];
					
					if(thisX>=100||thisX<0||thisY>=100||thisY<0)
						continue;
					if(map[thisY][thisX]==0)
						continue;
					if(visit[thisY][thisX]==true)
						continue;
					
					if(thisY==0)
						resultX=thisX;
					
					visit[thisY][thisX]=true;
					stack.push(new Node(thisY,thisX));
					break;
					
				}//for end
			}//while end
			System.out.println("#"+testNum+" "+resultX);
		}
		br.close();
		
	}//main() end
	
}//class end
