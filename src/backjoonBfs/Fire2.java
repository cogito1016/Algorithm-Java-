package backjoonBfs;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Fire2 {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//class Node end
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int result;
		boolean flag;
		char[][] map;
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<Node> manQueue ;
		Queue<Node> fireQueue ;
		
		manQueue = new LinkedList<Node>();
		fireQueue = new LinkedList<Node>();
		st = new StringTokenizer(br.readLine());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		map=new char[y][x];
		flag=false;
		result=0;
		
		for(int a=0;a<y;a++) {
			String s = br.readLine();
			for(int b=0;b<x;b++) {
				map[a][b]=s.charAt(b);
				if(map[a][b]=='F')
					fireQueue.offer(new Node(a,b));
				if(map[a][b]=='J')
					manQueue.offer(new Node(a,b));
			}//for end
		}//for end
		
		while(!manQueue.isEmpty()) {
			
			result++;
			
			int fireQueueSize = fireQueue.size();
			for(int a=0;a<fireQueueSize;a++) {
				Node node = fireQueue.poll();
				for(int b=0;b<4;b++) {
					int thisX = node.x+direct[b][1];
					int thisY = node.y+direct[b][0];
					char thisState;
					if(thisX>=x||thisX<0||thisY>=y||thisY<0)
						continue;
					thisState=map[thisY][thisX];
					if(thisState=='F'||thisState=='#')
						continue;
					map[thisY][thisX]='F';
					fireQueue.offer(new Node(thisY,thisX));
				}//for end
			}//for end
			
			int manQueueSize = manQueue.size();
			for(int a=0;a<manQueueSize;a++) {
				if(manQueue.isEmpty())
					break;
				Node node = manQueue.poll();
				for(int b=0;b<4;b++) {
					int thisX = node.x+direct[b][1];
					int thisY = node.y+direct[b][0];
					char thisState;
					
					if(thisX>=x||thisX<0||thisY>=y||thisY<0){
						flag=true;
						while(!manQueue.isEmpty())
							manQueue.poll();
						break;
					}//if end
					
					thisState=map[thisY][thisX];
					if(thisState=='F'||thisState=='#'||thisState=='J')
						continue;
					map[thisY][thisX]='J';
					manQueue.offer(new Node(thisY,thisX));
				}//for end
			}//for end
		}//while end
		if(flag)
			System.out.println(result+"");
		else
			System.out.println("IMPOSSIBLE");

		
		
		
		br.close();
	}//main() end
}//class end