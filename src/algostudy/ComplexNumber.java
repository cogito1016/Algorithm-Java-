package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ComplexNumber {

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
		
		
	}//Class Node end
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNum = Integer.parseInt(br.readLine());
		int[][] map = new int[inputNum][inputNum];
		boolean[][] visit = new boolean[inputNum][inputNum];
		int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		int thisX,thisY,complexNum=1;

		
		Stack<Node> stack = new Stack<Node>();
		
		for(int i=0;i<inputNum;i++) {
			String s = br.readLine();
			for(int j=0;j<inputNum;j++) {
				map[i][j] = s.charAt(j)-'0';
			}//for end
		}//for end
		
		stack.push(new Node(0,0));
		visit[0][0]=true;
		
		while(!stack.isEmpty()) {
			
			Node node = stack.pop();
			
			for(int i=0;i<4;i++) {
				thisX=node.getX()+direct[i][1];
				thisY=node.getY()+direct[i][0];
				
				if(thisX>=inputNum||thisX<0||thisY>=inputNum||thisY<0)
					continue;
				if(map[thisY][thisX]==0)
					continue;
				if(visit[thisY][thisX]==true)
					continue;
				
				// 만약 1 찾으면 여길 기점으로 BFS를 또 진행!
				if(map[thisY][thisX]==1) {
					Stack<Node> complexStack = new Stack<Node>();
					complexStack.push(new Node(thisY,thisX));
					
					while(!complexStack.isEmpty()) {
						Node complexNode = complexStack.pop();
						
						for(int j=0;j<4;j++) {
							int complexX=complexNode.getX()+direct[j][1];
							int complexY=complexNode.getY()+direct[j][0];
							
							if(complexX>=inputNum||complexX<0||complexY>=inputNum||complexY<0)
								continue;
							if(map[complexY][complexX]==0)
								continue;
							if(visit[complexY][complexX]==true)
								continue;
							
							visit[complexY][complexX]=true;
							stack.push(new Node(complexY,complexX));
							map[complexY][complexX]=complexNum;
						}//for end
					}//while end
					complexNum++;
				}
				
				//
				visit[thisY][thisX]=true;
				stack.push(new Node(thisY,thisX));
				
				
			}//for end
			
			
		}//while end
		br.close();
		
		for(int i=0;i<inputNum;i++) {
			for(int j=0;j<inputNum;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		
	}//main() end
	
}//class end