package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsChessHorse {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//class Node end
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int testCase = Integer.parseInt(br.readLine());
		
		int[][] direct = {{2,1},{2,-1},{-2,1},{-2,-1},{1,-2},{1,+2},{-1,-2},{-1,+2}};
		List<Integer> resultList =new ArrayList<Integer>();
		
		for(int i=0;i<testCase;i++) {
			
			int size = Integer.parseInt(br.readLine());
			boolean[][] map = new boolean[size][size];
			Queue<Node> queue = new LinkedList<Node>();
			
			st= new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			
			queue.offer(new Node(startY,startX));
			map[startY][startX]=true;
			
			int result =0;
			boolean flag = false;
			
			while(!queue.isEmpty()) {
				result++;
				int queueSize=queue.size();
				for(int j=0;j<queueSize;j++) {
					if(queue.isEmpty())
						break;
					Node node = queue.poll();
					
					for(int a=0;a<8;a++) {
						
						int thisX = node.x+direct[a][1];
						int thisY = node.y+direct[a][0];
						
						if(thisX>=size||thisX<0||thisY>=size||thisY<0)
							continue;
						if(map[thisY][thisX])
							continue;
						if((thisX==endX)&&(thisY==endY)){
							flag=true;
							while(!queue.isEmpty())
								queue.poll();
							break;
						}//if end
						map[thisY][thisX]=true;
						queue.offer(new Node(thisY,thisX));
					}//for end
				}//for end
			}//while end
			
			if(flag)
				resultList.add(result);
			else
				resultList.add(0);
		}//for end
		
		for(int result : resultList) {
			System.out.println(result);
		}//for end
		br.close();
	}//main() end
}//class end