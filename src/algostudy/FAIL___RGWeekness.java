package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class FAIL___RGWeekness {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//class Node end
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		char[][] map = new char[size][size];
		boolean[][] visit = new boolean[size][size];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		
		int weekness=0,normal=0;
		
		Deque<Node> deque = new ArrayDeque<Node>();
		
		for(int i=0;i<size;i++) {
			String s = br.readLine();
			for(int j=0;j<size;j++) {
				map[i][j]=s.charAt(j);
			}//for end
		}//for end
		

		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(visit[i][j])
					continue;
				
				deque.addLast(new Node(i,j));
				visit[i][j]=true;
				weekness++;
				normal++;
				
				char beforeColor='X';
				
				while(!deque.isEmpty()) {
					Node node = deque.pollLast();
					char thisColor = map[node.y][node.x];
					char compareColor ='X';
					
					if(thisColor=='R')
						compareColor='G';
					else if(thisColor=='G')
						compareColor='R';
					
					if( (beforeColor!='X')&&(beforeColor!=thisColor)) {
						normal++;
						System.out.println("색깔체인지!");
					}
					

					beforeColor=thisColor;
					
					for(int a=0;a<4;a++) {
						int thisX=node.x+direct[a][1];
						int thisY=node.y+direct[a][0];
						
						if(thisX>=size||thisX<0||thisY>=size||thisY<0)
							continue;
						if(visit[thisY][thisX])
							continue;
						char nextColor = map[thisY][thisX];
						
						if(compareColor=='X')
						{
							if(nextColor!='B')
								continue;
							visit[thisY][thisX]=true;
							deque.addLast(new Node(thisY,thisX));
						}else {
							if(nextColor=='B')
								continue;
							
							if(nextColor==compareColor)
								deque.addFirst(new Node(thisY,thisX));
							else if(nextColor==thisColor) 
								deque.addLast(new Node(thisY,thisX));
							
							visit[thisY][thisX]=true;
							
						}//if~else end
					}//for end
					
					System.out.println("한번 돈 결과 디큐사이즈="+deque.size());
				}//while end
			}//for end
		}//for end
		
		System.out.println(normal+" "+weekness);
		
		br.close();
	}//main() end
}//class end