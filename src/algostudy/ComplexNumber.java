package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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

		
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i=0;i<inputNum;i++) {
			String s = br.readLine();
			for(int j=0;j<inputNum;j++) {
				map[i][j] = s.charAt(j)-'0';
			}//for end
		}//for end
		
		queue.add(new Node(0,0));
		visit[0][0]=true;
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			
			for(int i=0;i<4;i++) {
				thisX=node.getX()+direct[i][1];
				thisY=node.getY()+direct[i][0];
				
				if(thisX>=inputNum||thisX<0||thisY>=inputNum||thisY<0)
					continue;

				if(visit[thisY][thisX]==true)
					continue;
				
				if(map[thisY][thisX]==1) {
					map[thisY][thisX]=2;
				}
				
				visit[thisY][thisX]=true;
				queue.add(new Node(thisY,thisX));
				
				
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