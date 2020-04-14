package algostudy;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BfsFire {

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
		int test = Integer.parseInt(br.readLine());
		
		int result;
		boolean flag;
		String[] testList = new String[test];
		char[][] map;
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<Node> manQueue ;
		Queue<Node> fireQueue ;
		
		for(int i=0;i<test;i++) {
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
					if(map[a][b]=='*')
						fireQueue.offer(new Node(a,b));
					if(map[a][b]=='@')
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
						if(thisState=='*'||thisState=='#')
							continue;
						map[thisY][thisX]='*';
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
						if(thisState=='*'||thisState=='#'||thisState=='@')
							continue;
						map[thisY][thisX]='@';
						manQueue.offer(new Node(thisY,thisX));
					}//for end
				}//for end
			}//while end
			if(flag)
				testList[i]=result+"";
			else
				testList[i]="IMPOSSIBLE";
		}//for end
		
		for(String testResult : testList) {
			System.out.println(testResult);
		}//for end
		
		br.close();
	}//main() end
}//class end