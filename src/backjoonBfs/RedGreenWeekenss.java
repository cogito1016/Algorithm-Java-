package backjoonBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class RedGreenWeekenss {

	static class Node{
		
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//Node Class end
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		char[][] map = new char[size][size];
		char[][] weekMap = new char[size][size];
		
		boolean[][] visit = new boolean[size][size];
		boolean[][] weekVisit = new boolean[size][size];
		
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i=0;i<size;i++) {
			String s = br.readLine();
			for(int j=0;j<size;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='R'||map[i][j]=='G')
					weekMap[i][j]='W';
				else
					weekMap[i][j]='B';
			}//for end
		}//for end
		
		int normal=0;
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(visit[i][j])
					continue;
				queue.offer(new Node(i,j));
				normal++;
				while(!queue.isEmpty()) {
					Node node = queue.poll();
					char thisColor=map[node.y][node.x];
					
					for(int a=0;a<4;a++) {
						int thisX = node.x+direct[a][1];
						int thisY = node.y+direct[a][0];
						
						if(thisX>=size||thisX<0||thisY>=size||thisY<0)
							continue;
						if(visit[thisY][thisX])
							continue;
						if(map[thisY][thisX]!=map[node.y][node.x])
							continue;
						
						visit[thisY][thisX]=true;
						queue.offer(new Node(thisY,thisX));
						
					}//for end
				}//while end
			}//for end
		}//for end
		
		int week=0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(weekVisit[i][j])
					continue;
				queue.offer(new Node(i,j));
				week++;
				while(!queue.isEmpty()) {
					Node node = queue.poll();
					char thisColor=weekMap[node.y][node.x];
					
					for(int a=0;a<4;a++) {
						int thisX = node.x+direct[a][1];
						int thisY = node.y+direct[a][0];
						
						if(thisX>=size||thisX<0||thisY>=size||thisY<0)
							continue;
						if(weekVisit[thisY][thisX])
							continue;
						if(weekMap[thisY][thisX]!=weekMap[node.y][node.x])
							continue;
						
						weekVisit[thisY][thisX]=true;
						queue.offer(new Node(thisY,thisX));
						
					}//for end
				}//while end
			}//for end
		}//for end
		
		
		System.out.println(normal+" "+week);
		
		br.close();
	}//main() end
}//class end