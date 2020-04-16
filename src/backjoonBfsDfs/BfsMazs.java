package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsMazs {
	static class Node{
		private int x,y; 
		Node(int y, int x){
			this.y=y;
			this.x=x;
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
	}//Node class end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y= Integer.parseInt(st.nextToken());
		int x= Integer.parseInt(st.nextToken());
		int result=0;
		
		int[][] map = new int[y][x];
		boolean[][] visit = new boolean[y][x];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i =0; i<y;i++) {
			String s = br.readLine();
			for(int j=0;j<x;j++) {
				map[i][j]= s.charAt(j)-'0';
			}//for end
		}//for end
		
		queue.offer(new Node(0,0));
		visit[0][0]=true; 
		
		while(!queue.isEmpty()) {
			
			int queueSize = queue.size();
			result++;
			
			for(int i=0;i<queueSize;i++) {
				Node node = queue.poll();
				if(node.getX()==(x-1) && node.getY()==(y-1)) {
					queue.clear();
					break;
				}
				for(int j=0;j<4;j++) {
					int thisX= node.getX()+direct[j][1];
					int thisY= node.getY()+direct[j][0];
					
					if(thisX>=x||thisX<0||thisY>=y||thisY<0)
						continue;
					if(visit[thisY][thisX])
						continue;
					if(map[thisY][thisX]==0)
						continue;
					
					visit[thisY][thisX]=true;
					queue.offer(new Node(thisY,thisX));
				}//for end
			}//for end
		}//while ned
		
		System.out.println(result);
		br.close();
	}//main() end
}
