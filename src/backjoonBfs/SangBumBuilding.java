package backjoonBfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SangBumBuilding {
	
	static class Node{
		
		int x,f,y;
		
		Node(int f, int y,int x){
			this.f=f;
			this.y=y;
			this.x=x;
		}
	}//Class Node end
	
	public static void main(String[] args) throws IOException {
	
		Scanner scan = new Scanner(System.in);
		StringTokenizer st;
		Queue<Node> queue ;
		char[][][] map ;
		boolean flag;
		int[][] direct = {{0,0,1},{0,1,0},{0,0,-1},{0,-1,0},{1,0,0},{-1,0,0}};
		List<Integer> resultList = new ArrayList<Integer>();
		
		int startX,startY,startF;

		while(scan.hasNext()) {
			
			st = new StringTokenizer(scan.nextLine());
			int f = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			if(f==0)
				break;
			
			queue = new LinkedList<Node>();
			map = new char[f][y][x];
			startX=0;
			startY=0;
			startF=0;
			flag=false;
			
			for(int i=0;i<f;i++) {
				for(int j=0;j<y;j++) {
					String s = scan.nextLine();
					for(int k=0;k<x;k++) {
						map[i][j][k]= s.charAt(k);
						if(map[i][j][k]=='S')
						{
							startF=i;
							startY=j;
							startX=k;
						}//if end 
					}//for end
				}//for end
				scan.nextLine();
			}//for end 
			
			queue.offer(new Node(startF,startY,startX));
			
			int minutes =0;
			
			while(!queue.isEmpty()) {
				
				int queueSize = queue.size();
				minutes++;
				
				for(int i=0;i<queueSize;i++) {
					Node node = queue.poll();
					
					if(flag)
						break;
					
					for(int j=0;j<6;j++) {
						int thisF = node.f+direct[j][0];
						int thisY = node.y+direct[j][1];
						int thisX = node.x+direct[j][2];
						
						if(thisF>=f||thisF<0||thisY>=y||thisY<0||thisX>=x||thisX<0)
							continue;
						if(map[thisF][thisY][thisX]=='#'||map[thisF][thisY][thisX]=='S')
							continue;
						if(map[thisF][thisY][thisX]=='E')
						{
							flag=true;
							while(!queue.isEmpty()) {
								queue.poll();
							}//while end
							break;
						}//if end
						
						map[thisF][thisY][thisX]='S';
						queue.offer(new Node(thisF,thisY,thisX));
					}//for end
				}//for end
				
			}//while end
			if(flag)
				resultList.add(minutes);
			else
				resultList.add(-1);
			
		}//while end
		
		for(int result : resultList) {
			if(result!=-1)
				System.out.println("Escaped in "+result+" minute(s).");
			else
				System.out.println("Trapped!");
		}
		
	}//main() end
}//class end