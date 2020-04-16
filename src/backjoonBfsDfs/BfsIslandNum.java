package backjoonBfsDfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BfsIslandNum {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons Node end
	}//Class Node end
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StringTokenizer st;
		
		int x,y;
		
		int[][] map;
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
		Queue<Node> queue;
		List<Integer> resultList = new ArrayList<Integer>();
		
		while(scan.hasNext()) {
			st = new StringTokenizer(scan.nextLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if(x==0) 
				break;
			
			map = new int[y][x];
			queue = new LinkedList<Node>();
			int result =0;
			
			for(int i=0;i<y;i++) {
				st = new StringTokenizer(scan.nextLine());
				for(int j=0;j<x;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}//for end
			}//for end
			

			for(int i=0;i<y;i++) {
				for(int j=0;j<x;j++) {
					if(map[i][j]==0||map[i][j]==2)
						continue;
					
					queue.offer(new Node(i,j));
					map[i][j]=2;
					result++;
					while(!queue.isEmpty()) {
						Node node = queue.poll();
						for(int a=0;a<8;a++) {
							int thisX= node.x+direct[a][1];
							int thisY= node.y+direct[a][0];
							if(thisX>=x||thisX<0||thisY>=y||thisY<0)
								continue;
							if(map[thisY][thisX]==0 || map[thisY][thisX]==2)
								continue;
							
							map[thisY][thisX]=2;
							queue.offer(new Node(thisY,thisX));
						}//for end
					}//while end
				}//for end
			}//for end

			resultList.add(result);
		}//while end
		
		for(int result : resultList) {
			System.out.println(result);
		}
	}//main() end
}//class end