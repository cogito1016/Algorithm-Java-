package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsOrganicCabbage {
	
	static class Node{
		
		int x,y;
		
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//const end

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
		
		int testNum = Integer.parseInt(br.readLine());
		
		StringTokenizer st ;
		
		Stack<Node> stackOrigin ;
		Stack<Node> stackTemp ;
		
		int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		int[] result = new int[testNum];
		int row,col,thisX,thisY,bugsNum;
		Node node;

		int n,m,locationNum;
		int[][] map;
		
		for(int test=0;test<testNum;test++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			locationNum = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			stackOrigin = new Stack<Node>();
			stackTemp = new Stack<Node>();
			bugsNum=0;
			
			//입력부
			for(int i=0; i<locationNum;i++) {
				st=new StringTokenizer(br.readLine());
				row = Integer.parseInt(st.nextToken());
				col = Integer.parseInt(st.nextToken());
				map[row][col]=1;
				stackOrigin.push(new Node(row,col));
			}//for end
			
			
			while(!stackOrigin.isEmpty()) {
				Node bugsLocation = stackOrigin.pop();
				if(map[bugsLocation.getY()][bugsLocation.getX()]==1)
				{
					stackTemp.push(bugsLocation);
					bugsNum++;
					while(!stackTemp.isEmpty()) {
						node = stackTemp.pop();
						for(int i=0;i<4;i++) {
							thisY=node.getY()+direct[i][0];
							thisX=node.getX()+direct[i][1];
							
							if(thisX>=m||thisX<0||thisY>=n||thisY<0) 
								continue;
							if(map[thisY][thisX]==0)
								continue;
							
							map[thisY][thisX]=0;
							stackTemp.push(new Node(thisY,thisX));
							
						}//for end
					}//while ned
				}
			}//while end
			result[test]=bugsNum;
		}
		br.close();
		
		for(int i=0;i<testNum;i++) {
			System.out.println(result[i]);
		}
		
	}//main() end
}//class end
