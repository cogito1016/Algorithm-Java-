package backjoonBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class LaboratoryVirus_beforeMerge {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//Node class ned
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		int largestArea = 0 ;
		
		List<Node> possible = new ArrayList<Node>();
		
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					queue.offer(new Node(i,j));
					visit[i][j]=true;
				}//if end
				else if(map[i][j]==0) {
					possible.add(new Node(i,j));
				}
			}//for end
		}//for end
		
		int[][] copyMap = new int[N][M];
		for(int i = 0; i < map.length; i++) {
	        System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
	    }//for end
		int brickNum = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(stack.isEmpty()) {
			
			int standard = stack.pop();
			
			for(int a=standard;a<possible.size();a++) {
				stack.add(a);
				brickNum++;
				if(brickNum==3) {
					
					for(int b=0;b<3;b++) {
						copyMap[possible.get(stack.get(b)).y][possible.get(stack.get(b)).x]=1;
					}//for end
					
					
					
					
					
					break;
				}//if end
			}//for end			
		}//while end

		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			
			for(int i=0;i<queueSize;i++) {
				
				Node node = queue.poll();
				for(int j=0;j<4;j++) {
					int thisX = node.x + direct[j][1];
					int thisY = node.y + direct[j][0];
					
					if(thisX<0||thisX>=M||thisY<0||thisY>=N) 
						continue;
					if(visit[thisY][thisX])
						continue;
					if(map[thisY][thisX]==1)
						continue;
					
					visit[thisY][thisX]=true;
					map[thisY][thisX]=2;
					queue.offer(new Node(thisY,thisX));
				}//for end 
			}//for end 
			
			System.out.println();
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(map[i][j]+" ");
				}//for end
				System.out.println();
			}//for end
			
		}//while end
		
		
		br.close();
	}//main() end
}//class end