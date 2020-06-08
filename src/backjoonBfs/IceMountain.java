package backjoonBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class IceMountain {

	static class Node{
		int x,y;
		public Node(int y,int x) {
			this.x=x;
			this.y=y;
		}
	}//Node class end 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0)
					queue.offer(new Node(i,j));
			}//for end 
		}//for end 
		
		int year = 1;
		boolean ansFlag = false;
		
		while(!queue.isEmpty()) {
			visit = new boolean[N][M];
			int queueSize = queue.size();
			
			for(int i=0;i<queueSize;i++) {
				
				Node node = queue.poll();
				int nodeVal = map[node.y][node.x];
				visit[node.y][node.x]=true;
				
				for(int j=0;j<4;j++) {
					int thisX = node.x+direct[j][1];
					int thisY = node.y+direct[j][0];
					
					if(thisX<0||thisX>=M||thisY<0||thisY>=N)
						continue;
					if(visit[thisY][thisX])
						continue;
					if(map[thisY][thisX]==0) {
						nodeVal--;
						map[node.y][node.x]= nodeVal<0? 0:nodeVal;
					}
					
				}//for end
				
				if(nodeVal>0) {
					queue.offer(node);
					
				}
			}//for end


			
			
			if(!queue.isEmpty()) {

				int count=1;
				Queue<Node> tempQueue = new LinkedList<Node>();
				visit = new boolean[N][M];
				Node n = queue.peek();
				tempQueue.offer(n);
				visit[n.y][n.x]=true;
				
				while(!tempQueue.isEmpty()) {
					
					Node tempNode = tempQueue.poll();
					for(int j=0;j<4;j++) {
						int thisX = tempNode.x+direct[j][1];
						int thisY = tempNode.y+direct[j][0];
						if(thisX<0||thisX>=M||thisY<0||thisY>=N)
							continue;
						if(visit[thisY][thisX])
							continue;
						if(map[thisY][thisX]==0)
							continue;
						count++;
						visit[thisY][thisX]=true;
						tempQueue.offer(new Node(thisY,thisX));
					}//for end 
				}//while end 
				
				if(count!=queue.size()) {
					ansFlag=true;
					break;	
				}
				
			}//if end 
			year++;
		}//while end 

		if(ansFlag)
			System.out.println(year);
		else
			System.out.println(0);
		
		br.close();
	}//main() end
	
}//빙산이영어로 뭘까