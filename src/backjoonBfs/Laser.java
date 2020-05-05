package backjoonBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Laser {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons Node end
	}//class Node end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		char[][] map = new char[y][x];
		int[][] valMap = new int[y][x];
		boolean[][] visit = new boolean[y][x];
		int[][] sameDirect = {{0,1},{1,0},{0,-1},{-1,0}};  
		int[][] otherDirect = {{1,1},{1,-1},{-1,1},{-1,-1}};  
		
		Queue<Node> queue = new LinkedList<Node>();
		int startX=0, startY=0;
		
		for(int i=0;i<y;i++) {
			String s = br.readLine();
			for(int j=0;j<x;j++) {
				valMap[i][j]=11000;
				map[i][j] = s.charAt(j);
				if(map[i][j]=='C'){
					startX=j;
					startY=i;
				}//if end
			}//for end
		}//for end 
		
		valMap[startY][startX]=0;
		queue.add(new Node(startY,startX));
		visit[startY][startX]=true;
		int result=0;
		while(!queue.isEmpty()) {

			if(queue.isEmpty())
				break;
			
			Node node = queue.poll();
			int thisX,thisY;
			
			for(int i=0;i<4;i++) {
				thisX= node.x+sameDirect[i][1];
				thisY= node.y+sameDirect[i][0];
				
				if(thisX>=x||thisX<0||thisY>=y||thisY<0)
					continue;
				if(map[thisY][thisX]=='*')
					continue;
				if(visit[thisY][thisX])
					continue;
				if(valMap[thisY][thisX]>valMap[node.y][node.x])
					valMap[thisY][thisX]=valMap[node.y][node.x];
				
				if(map[thisY][thisX]=='C') {
					result=valMap[thisY][thisX];
					queue.clear();
					break;
				}//if end
				
				visit[thisY][thisX]=true;
				queue.add(new Node(thisY,thisX));
			}//for end
			
			if(queue.isEmpty())
				break;
			
			for(int i=0;i<4;i++) {
				thisX= node.x+otherDirect[i][1];
				thisY= node.y+otherDirect[i][0];
				
				if(thisX>=x||thisX<0||thisY>=y||thisY<0)
					continue;
				if(map[thisY][thisX]=='*')
					continue;

				if(visit[thisY][thisX])
					continue;
				if(valMap[thisY][thisX]>valMap[node.y][node.x]+1)
					valMap[thisY][thisX]=valMap[node.y][node.x]+1;
				
				if(map[thisY][thisX]=='C') {
					result=valMap[thisY][thisX];
					queue.clear();
					break;
				}//if end
				
				visit[thisY][thisX]=true;
				queue.add(new Node(thisY,thisX));
			}//for end
		}//while end
		System.out.println(result);
		
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				System.out.print(valMap[i][j]+"  ");
			}//for end
			System.out.println();
		}//for end 
		
		br.close();
	}//main() end
}//class end