package backjoonBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HedgehogRunning {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}
	}//class Node end
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[y][x];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		
		int hogX=0,hogY=0,waterX=0,waterY=0;
		
		Queue<Node> hogQueue = new LinkedList<Node>();
		Queue<Node> waterQueue = new LinkedList<Node>();
		
		for(int i=0;i<y;i++) {
			String s = br.readLine();
			for(int j=0;j<x;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='S') {
					hogX=j;
					hogY=i;
					hogQueue.offer(new Node(hogY,hogX));
				}else if(map[i][j]=='*') {
					waterX=j;
					waterY=i;
					waterQueue.offer(new Node(waterY,waterX));
				}//if ~ elseif ~ elseif
			}//for end
		}//for end
		
		
		boolean flag=false;
		int result =0;
		
		while(!hogQueue.isEmpty()) {
			result++;
			
			
			int waterQueueSize = waterQueue.size();
			for(int i=0;i<waterQueueSize;i++) {
				Node node = waterQueue.poll();
				for(int j=0;j<4;j++) {
					int thisX= node.x+direct[j][1];
					int thisY= node.y+direct[j][0];
					char thisInfo;
					
					if(thisX>=x||thisX<0||thisY>=y||thisY<0)
						continue;
					thisInfo = map[thisY][thisX];
					if(thisInfo=='*'||thisInfo=='D'||thisInfo=='X')
						continue;
					waterQueue.offer(new Node(thisY,thisX));
					map[thisY][thisX]='*';
				}//for end
			}//for end 
			
			int hogQueueSize = hogQueue.size();
			for(int i=0;i<hogQueueSize;i++) {
				if(hogQueue.isEmpty())
					break;
				Node node = hogQueue.poll();
				for(int j=0;j<4;j++) {
					int thisX= node.x+direct[j][1];
					int thisY= node.y+direct[j][0];
					char thisInfo;
					
					if(thisX>=x||thisX<0||thisY>=y||thisY<0)
						continue;
					thisInfo = map[thisY][thisX];
					if(thisInfo=='*'||thisInfo=='S'||thisInfo=='X')
						continue;
					if(thisInfo=='D'){
						flag=true;
						while(!waterQueue.isEmpty()) 
							waterQueue.poll();
						while(!hogQueue.isEmpty())
							hogQueue.poll();
						break;
						
					}//if end
					hogQueue.offer(new Node(thisY,thisX));
					map[thisY][thisX]='S';
				}//for end
			}//for end 
		}//while end
		
		
		if(flag)
			System.out.println(result);
		else
			System.out.println("KAKTUS");
		br.close();
	}//main() end
}//class end