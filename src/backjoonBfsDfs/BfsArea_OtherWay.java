package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsArea_OtherWay {

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
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int rectNum = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[y][x];
		int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		
		Queue<Node> queue = new LinkedList<Node>();
		Queue<Node> queueTemp = new LinkedList<Node>();
		List<Integer> resultSet = new ArrayList<Integer>();
		
		int firstY,firstX,secondX,secondY;		
		
		for(int i=0;i<rectNum;i++) {
			st = new StringTokenizer(br.readLine());
			firstX = Integer.parseInt(st.nextToken());
			firstY = Integer.parseInt(st.nextToken());
			secondX = Integer.parseInt(st.nextToken());
			secondY = Integer.parseInt(st.nextToken());
			
			for(int j=(y-secondY);j<(y-firstY);j++) {
				for(int k=firstX;k<secondX;k++) {
					if(map[j][k])
						continue;
					map[j][k]=true;
				}//for end
			}//for end
		}//for end
		

		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				if(!map[i][j])
					queue.offer(new Node(i,j));
			}//for end
		}//for end
		
		int result=0;
		
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int thisX = node.getX();
			int thisY = node.getY();
			if(map[thisY][thisX])
				continue;
			
			queueTemp.offer(node);
			map[thisY][thisX]=true;
			result=1;
			
			while(!queueTemp.isEmpty()) {
				Node tempNode = queueTemp.poll();
				for(int i=0;i<4;i++) {
					int tempX = tempNode.getX()+direct[i][1];
					int tempY = tempNode.getY()+direct[i][0];
					
					if(tempY>=y||tempY<0||tempX>=x||tempX<0)
						continue;
					if(map[tempY][tempX])
						continue;
					
					map[tempY][tempX]=true;
					result++;
					queueTemp.offer(new Node(tempY,tempX));
				}//for end
			}//while end
			
			resultSet.add(result);
		}//while end
		
		Collections.sort(resultSet);
		
		System.out.println(resultSet.size());
		for (int item : resultSet) {
			System.out.print(item + " ");
		}
		
		br.close();
	}//main() end
}//class end
