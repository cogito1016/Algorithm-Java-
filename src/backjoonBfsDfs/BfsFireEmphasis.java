package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BfsFireEmphasis {
	static class Node{
		int x,y;
		char state;
		Node(int y,int x,char state){
			this.y=y;
			this.x=x;
			this.state=state;
		}//cons end
	}//class end

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		char[][] map = new char[y][x];

		Deque<Node> queue = new LinkedList<Node>();
		for(int i=0;i<y;i++) {
			String s = br.readLine();
			for(int j=0;j<x;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='J') 
					queue.addLast(new Node(i,j,'J'));
				else if(map[i][j]=='F')
					queue.addFirst(new Node(i,j,'F'));
			}//for end
		}
		
		int result =0;
		boolean flag = false ;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			result++;
			for(int i=0;i<queueSize;i++) {
				if(queue.isEmpty())
					break;
				Node node = queue.poll();
				char thisState = node.state;
				
				for(int a=0;a<4;a++) {
				
					int thisX=node.x+direct[a][1];
					int thisY=node.y+direct[a][0];
					
					if(thisY>=y||thisY<0||thisX>=x||thisX<0) {
						if(thisState=='J')
						{
							flag=true;
							queue.clear();
							break;
						}
						continue;
					}
					
					if(map[thisY][thisX]=='#')
						continue;
					if(map[thisY][thisX]=='F')
						continue;
					if(thisState=='J'&&map[thisY][thisX]=='J')
						continue;
					
					map[thisY][thisX]=thisState;
					queue.offer(new Node(thisY,thisX,thisState));
					
				}
			}//for end
			
//			for(int i=0;i<y;i++) {
//				for(int j=0;j<x;j++) {
//					System.out.print(map[i][j]);
//				}//for end
//				System.out.println();
//			}
			
		}//while end
		
		if(flag)
			System.out.println(result);
		else
			System.out.println("IMPOSSIBLE");
		
		br.close();
	}
}//class end