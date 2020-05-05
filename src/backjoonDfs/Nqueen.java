package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Nqueen {

	static int queenNum;
	
	static char[][] map;
	static Stack<Node> stack;
	
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
	
	public static void initMap() {
		for(int i=0;i<queenNum;i++) {
			for(int j=0;j<queenNum;j++) {
				map[i][j]='F';
				stack.push(new Node(i,j));
			}//for end
		}//for end
	}//initMap() end
	
	public static void changeMap(int thisX,int thisY,int dynamicX,int dynamicY,char c) {
		
		for(int i=0;i<queenNum/2;i++) {
			if(c=='F')
				stack.add(new Node(thisY,thisX));
			
			dynamicY=thisY+i;
			if(!(dynamicY>=queenNum)) {
				map[dynamicY][i]=c;
				if(c=='F')
					stack.add(new Node(dynamicY,i));
			}//if end
			
			dynamicX=thisX+i;
			if(!(dynamicX>=queenNum)) {
				map[i][dynamicX]=c;
				if(c=='F')
					stack.add(new Node(i,dynamicX));
			}//if end 
			
			if(!(dynamicY>=queenNum)&&!(dynamicX>=queenNum)) {
				map[dynamicY][dynamicX]=c;	
				if(c=='F')
					stack.add(new Node(dynamicY,dynamicX));
			}//if end
			
			dynamicX=thisX-i;
			dynamicY=thisY-i;
			if(dynamicX<0||dynamicY<0)
				continue;
			map[dynamicY][dynamicX]=c;
			if(c=='F')
				stack.add(new Node(dynamicY,dynamicX));
		}//for end
	}//changeMap() end
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		queenNum = Integer.parseInt(br.readLine());
		
		map = new char[queenNum][queenNum];
		stack = new Stack<Node>();
		
		initMap();
		
		Node node;
		int thisX,thisY,dynamicX = 0,dynamicY = 0,caseNum=0,result=0,queenCheck=0;
		
		while(!stack.isEmpty()) {
			node = stack.pop();
			thisX=node.getX();
			thisY=node.getY();
			
			if(map[thisY][thisX]=='T')
				continue;
			
			if(map[thisY][thisX]=='Q'){
				changeMap(thisX,thisY,dynamicX, dynamicY,'F');
				queenCheck--;
			}//if end
			
			if(queenCheck==queenNum)
			{
				caseNum++;
				initMap();
			}//if end
			
			changeMap(thisX,thisY,dynamicX, dynamicY,'T');
			
			map[thisY][thisX]='Q';
			queenCheck++;
			stack.push(new Node(thisY,thisX));
			
			for(int i=0;i<queenNum;i++) {
				for(int j=0;j<queenNum;j++) {
					System.out.print(map[i][j]);
				}//for end
				System.out.println();
			}
			
		}//while end
		
		System.out.println(result);
		br.close();
	}//main() end
}//class end