package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Nqueen_OtherWay {

	
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
	}//class end
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int queenNum = Integer.parseInt(br.readLine());
		
		char[][] map = new char[queenNum][queenNum];
		Stack<Node> stack = new Stack<Node>();
		
		int[] col = new int[queenNum];
		
		Node node;
		int thisX,thisY,result =0,caseNum=0; 
		
		for(int i=0;i<queenNum;i++) {
			col[i]=-1;
			stack.push(new Node(0,i));
		}//for end
		
		
		while(!stack.isEmpty()) {
			node = stack.pop();
			col[node.getY()]=node.getX();
			thisX=node.getX();
			thisY=node.getY()+1;
			if(thisY>=queenNum) {
				continue;
			}
//			for(int i=0;i<queenNum;i++) {
//				if(thisX==col[i])
//					result--;
//			}//for end
			
			for(int i=0;i<queenNum;i++) {
				for(int j=0;j<queenNum;j++) {
					if(col[j]==-1)
						break;
					if(i==col[j])
						continue;
					if(Math.abs((thisY-i))==col[j] )
						continue;
					if((thisY+i)==col[j] )
						continue;
					
					stack.push(new Node(thisY,i));
					col[thisY-1]=i;
					result++;
					
					if(result==queenNum) {
						caseNum++;
					}
				}//for end
			}//for end
			
		}//while end
		
		System.out.println(caseNum);
		br.close();
	}//main() end
}//class end