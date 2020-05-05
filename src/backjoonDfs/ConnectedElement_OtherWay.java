package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ConnectedElement_OtherWay {

	static class Node{
		
		private int x,y;
		
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
		
		
	
		
		//정점개수와 간선개수입력부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int elementNum = Integer.parseInt(s[0]);
		int lineNum = Integer.parseInt(s[1]);
		
		boolean[] visit = new boolean[elementNum];
		int[][] map = new int[elementNum][elementNum];
		Stack<Node> stack = new Stack<Node>();
		
		int connectedElementNum=0;
		int firstElement,secondElement;
		
		for(int i=0;i<lineNum;i++) {
			String[] lineInfo = br.readLine().split(" ");
			firstElement = Integer.parseInt(lineInfo[0]);
			secondElement = Integer.parseInt(lineInfo[1]);
			
			map[firstElement-1][secondElement-1]=1;
			map[secondElement-1][firstElement-1]=1;
			
		}//for end
		
		
		for(int i=0;i<elementNum;i++) {
			
			if(!visit[i]) {
				connectedElementNum++;
				
				for(int j=0;j<elementNum;j++) {

					if(visit[j])
						continue;
					if(map[i][j]==0)
						continue;
					
					visit[j]=true;
					stack.push(new Node(i,j));
				}//for end
				
				while(!stack.isEmpty()) {
					Node node = stack.pop();
					for(int j=0;j<elementNum;j++) {
						
						if(visit[j])
							continue;
						if(map[node.getX()][j]==0)
							continue;
						
						visit[j]=true;
						stack.push(new Node(node.getX(),j));
					}//for end
				}//while end
			}//if end
		}//for end
		
		
		System.out.println(connectedElementNum);
		
		br.close();
	}//main() end 
}//Class end