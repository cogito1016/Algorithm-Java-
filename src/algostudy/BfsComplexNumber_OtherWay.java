package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BfsComplexNumber_OtherWay {

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
		
	}//class node end
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mapSize = Integer.parseInt(br.readLine());
		int[][] map = new int[mapSize][mapSize];
		int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		boolean[][] visit = new boolean[mapSize][mapSize];
		
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		List<Integer> list = new  ArrayList<Integer>();
		
		String s;
		int thisNum,thisX,thisY,complexNum=0;
		Node node,stackNode;
		
		for(int i=0;i<mapSize;i++) {
			s = br.readLine();
			for(int j=0;j<mapSize;j++) {
				thisNum = s.charAt(j)-'0';
				map[i][j]=thisNum;
				if(map[i][j]==1)
					stack.push(new Node(i,j));
			}//for end
		}//for end
		
		while(!stack.isEmpty()) {

			stackNode = stack.pop();
			
			if(visit[stackNode.getY()][stackNode.getX()])
				continue;

			list.add(0);
			visit[stackNode.getY()][stackNode.getX()]=true;
			list.set(complexNum, list.get(complexNum)+1);
			queue.add(stackNode);
			
			while(!queue.isEmpty()) {
				node = queue.poll();
				
				for(int i=0;i<4;i++) {
					thisY = node.getY()+direct[i][0];
					thisX = node.getX()+direct[i][1];
					
					if(thisY>=mapSize||thisY<0||thisX>=mapSize||thisX<0) 
						continue;
					if(map[thisY][thisX]==0)
						continue;
					if(visit[thisY][thisX])
						continue;
					
					visit[thisY][thisX]=true;
					list.set(complexNum, list.get(complexNum)+1);
					map[thisY][thisX]=complexNum+2;
					queue.add(new Node(thisY,thisX));
					
				}//for end
			}//while end
			complexNum++;
		}//while end
		
		System.out.println(list.size());
		int nextComplexTotal;
		int thisComplexTotal;
		
		for(int j=0;j<list.size();j++) {
			for(int i=0;i<list.size()-1;i++) {
				thisComplexTotal = list.get(i);
				nextComplexTotal = list.get(i+1);
				if(thisComplexTotal>nextComplexTotal)
				{
					list.set(i, nextComplexTotal);
					list.set(i+1,thisComplexTotal);
				}//if end
			}//for end
		}//for end
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		

		br.close();
	}//main() end
	
}//calss end
