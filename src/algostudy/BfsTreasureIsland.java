package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BfsTreasureIsland {

	static class Node{
		
		private int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}
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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		
		int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		char[][] map = new char[y][x];
		boolean[][] visit;
		
		for(int i=0;i<y;i++) {
			String s = br.readLine();
			for(int j=0;j<x;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='L')
					stack.push(new Node(i,j));
			}//for end
		}//for end
		
		int range,thisX,thisY,max=0;
		Node node,originNode;
		
		while(!stack.isEmpty()) {
			visit = new boolean[y][x];
			originNode = stack.pop();
			queue.add(originNode);
			visit[originNode.getY()][originNode.getX()]=true;
			
			range=0;
			
			
			while(!queue.isEmpty()) {
				
				int queueSize = queue.size();
				
				for(int q=0;q<queueSize;q++) {				
					node = queue.poll();
					
					for(int i=0;i<4;i++) {
						thisX=node.getX()+direct[i][1];
						thisY=node.getY()+direct[i][0];
						if(thisY>=y||thisY<0||thisX>=x||thisX<0) 
							continue;
						if(visit[thisY][thisX])
							continue;
						if(map[thisY][thisX]=='W') 
							continue;
	
						visit[thisY][thisX]=true;
						queue.add(new Node(thisY,thisX));
					}//for end
				}//for end
				range++;
			}//while end

			if(range>max)
				max=range;
		}//while end
		
		
		System.out.println(max-1);
		
		br.close();
	}//main() end
}//class end
