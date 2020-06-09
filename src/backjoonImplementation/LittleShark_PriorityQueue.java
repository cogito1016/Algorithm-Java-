package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class LittleShark_PriorityQueue{

	static class Node implements Comparable<Node>{
		int x,y;
		
		Node(int y,int x){
			this.x=x;
			this.y=y; 
		}//cons end 
		
		@Override
		public int compareTo(Node o) {
			
			if(this.y>o.y)
				return 1;
			if(this.y==o.y) {
				if(this.x>o.x)
					return 1;	
				return -1;
			}
			
			return -1;
		}
		
	}//class end 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		int[][] check = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		int[][] direct = {{-1,0},{0,-1},{0,1},{1,0}};
		Queue<Node> queue = new LinkedList<Node>();
		PriorityQueue<Node> priQue = new PriorityQueue<Node>();
		
		int[] status = new int[10];
		int babyShark = 2;
		int babyStomach = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					map[i][j]=0;
					queue.add(new Node(i,j));
					visit[i][j]=true;
				}
				if(map[i][j]!=0)
					status[map[i][j]]++;
			}//for end 
		}//for end
		
		int answer = 0;
		int result = 0;
		int checkIndx = 1;
		while(!queue.isEmpty()) {
			
			int queueSize = queue.size();
			boolean reFlag = false;
			boolean possible = false;
			
			for(int i=1;i<babyShark;i++) {
				if(status[i]!=0)
					possible=true;
			}//for end 
			if(!possible) {
				break;
			}
			
			result++;
			
			for(int i=0;i<queueSize;i++) {
				Node node = queue.poll();
				for(int j=0;j<4;j++) {
					int thisX = node.x+direct[j][1];
					int thisY = node.y+direct[j][0];
					
					if(thisX<0||thisX>=N||thisY<0||thisY>=N) 
						continue;
					if(visit[thisY][thisX])
						continue;

					if(map[thisY][thisX]==0) {
						visit[thisY][thisX]=true;
						queue.offer(new Node(thisY,thisX));
						continue;
					}//if end
					
					if(map[thisY][thisX]!=0) {
						if(map[thisY][thisX]>babyShark) {
							continue;
						}//if end
						if(map[thisY][thisX]<babyShark) {
							
							//우선순위큐에 집어넣어!
							priQue.offer(new Node(thisY,thisX));
							reFlag=true;
							
						}//if end
						visit[thisY][thisX]=true;
						queue.offer(new Node(thisY,thisX));
						continue;
					}//if end
				}//for end 
			}//for end 
			
			if(reFlag) {
				//우선순위 큐 중에 제일좋은걸로 이동하고 아래걸 연산하믄댐

				Node objNode = priQue.poll();
				priQue.clear();
				int objX=objNode.x;
				int objY=objNode.y;
				
				queue.clear();
				visit = new boolean[N][N];
				answer=result;
				babyStomach++;
				status[map[objY][objX]]--;
				map[objY][objX]=0;
				check[objY][objX]=checkIndx++;
				if(babyStomach==babyShark) {
					babyShark++;
					babyStomach=0;
				}//if end

				visit[objY][objX]=true;
				queue.offer(new Node(objY,objX));
				continue;
			}//if end
		}//while end 

		System.out.println(answer);
		
		br.close();		
	}//main() end
}//class end 
