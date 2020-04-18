package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BfsLaserPoint {
	static int[][] rootMap;
	static class Node{
		int x,y,element;
		Node(int y,int x){
			this.x=x;
			this.y=y;
			element=rootMap[y][x];
		}//cons end
	}//Class Node end
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		char[][] map = new char[y][x]; 
		rootMap = new int[y][x];
		
		boolean[][] visit = new boolean[y][x];
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		
		int startX=0,startY=0;
		for(int i=0;i<y;i++) {
			String s = br.readLine();
			for(int j=0;j<x;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='C') {
					startX=j;
					startY=i; 
				}//if end
			}//for end
		}//for end
		
		queue.offer(new Node(startY,startX));
		visit[startY][startX]=true;
		int mirrorNum=0;
		Node node = null;
		int beforeX=startX,beforeY=startY;
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			for(int i=0;i<queueSize;i++) {
				if(queue.isEmpty())
					break;
				node = queue.poll();
				for(int j=0;j<4;j++) {
					int thisX = node.x+direct[j][1];
					int thisY = node.y+direct[j][0];
					char thisState;
					if(thisY>=y||thisY<0||thisX>=x||thisX<0)
						continue;
					thisState = map[thisY][thisX];
					if(visit[thisY][thisX])
						continue;
					if(thisState=='*')
						continue;
					if(thisState=='C') {
						while(!queue.isEmpty())
							queue.poll();
						break;
					}//if end
					

					int subX = Math.abs(beforeX-thisX); 
					int subY = Math.abs(beforeY-thisY); 
					if(subX==1&&subY==1) {
						int thisVal = rootMap[node.y][node.x];
						int nextVal = rootMap[thisY][thisX];
						if(nextVal!=0)
						rootMap[thisY][thisX]= rootMap[node.y][node.x]+1;
						}
					else
						rootMap[thisY][thisX]=rootMap[node.y][node.x];
					
					visit[thisY][thisX]=true;
					queue.offer(new Node(thisY,thisX));
					
				}//for end
			}//for end
			beforeX=node.x;
			beforeY=node.y;
		}//while end

		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				System.out.print(rootMap[i][j]);
			}
			System.out.println();
		}
			 
		System.out.println(mirrorNum);
		br.close();
	}//main() end
}//class end