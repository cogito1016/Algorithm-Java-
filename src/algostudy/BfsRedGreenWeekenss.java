package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BfsRedGreenWeekenss {

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
		boolean[][] visit = new boolean[size][size];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<Node> queue = new LinkedList<Node>();
		List<Character> resultList = new ArrayList<Character>();
		
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
				
				queue.offer(new Node(i,j));
				char thisColor = 0;
				while(!queue.isEmpty()) {
					Node node = queue.poll();
					thisColor=map[node.y][node.x];
					
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
				resultList.add(thisColor);
			}//for end
		}//for end
		
		int listSize = resultList.size();
		int weekMan=listSize;
		int normalMan=listSize;
		char beforeColor=0;
		for(int i=0;i<listSize;i++) {
			char thisColor = resultList.get(i);
			
			if(thisColor=='R'&& (beforeColor=='G'||beforeColor=='R'))
				weekMan--;
			else if(thisColor=='G'&& (beforeColor=='G'||beforeColor=='R'))
				weekMan--;
			
			beforeColor=thisColor;	
		}//for end
		
		System.out.println(normalMan+" "+weekMan);
		
		br.close();
	}//main() end
}//class end