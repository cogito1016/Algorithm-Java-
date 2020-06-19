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

public class LaboratoryVirus_Submit {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//Node class end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		int largestArea = 0 ;
		int originZeroArea = 0;
		
		List<Node> possible = new ArrayList<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		List<Node> viruses = new ArrayList<Node>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					viruses.add(new Node(i,j));
					visit[i][j]=true;
				}//if end
				else if(map[i][j]==0) {
					possible.add(new Node(i,j));
					originZeroArea++;
				}//if~elseIf end
			}//for end
		}//for end
		originZeroArea-=3;
		
		int[][] copyMap = new int[N][M];
		int brickNum = 1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(-1);
		
		while(!stack.isEmpty()) {
			
			int standard = stack.pop();
			brickNum--;
			
			for(int a=standard+1;a<possible.size();a++) {
				stack.add(a);
				brickNum++;
				if(brickNum==3) {

					copyMap = new int[N][M];
					for(int i = 0; i < map.length; i++) {
				        System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
				    }//for end
					
					for(int b=0;b<3;b++) {
						copyMap[possible.get(stack.get(b)).y][possible.get(stack.get(b)).x]=1;
					}//for end

					visit = new boolean[N][M];
					
					for(Node item : viruses) {
						queue.add(item);
						visit[item.y][item.x]=true;
					}//for end
					
					int resultNum = originZeroArea;
					
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
								if(copyMap[thisY][thisX]==1)
									continue;
								
								visit[thisY][thisX]=true;
								copyMap[thisY][thisX]=2;
								resultNum--;
								queue.offer(new Node(thisY,thisX));
							}//for end 
						}//for end 
					}//while end
					if(resultNum>largestArea)
						largestArea=resultNum;
					break;
				}//if end
			}//for end			
		}//while end
		System.out.println(largestArea);
		br.close();
	}//main() end
}//class end