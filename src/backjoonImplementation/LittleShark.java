package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LittleShark {

	static class Node{
		int x,y;
		
		Node(int y,int x){
			this.x=x;
			this.y=y; 
		}//cons end 
	}//class end 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		int[][] direct = {{-1,0},{0,-1},{0,1},{1,0}};
		Queue<Node> queue = new LinkedList<Node>();
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
		
		
		int result = 0;
		
		while(!queue.isEmpty()) {
			
			int queueSize = queue.size();
			boolean reFlag = false;
			boolean possible = false;
			
			for(int i=1;i<babyShark;i++) {
				System.out.println("status"+i+"="+status[i]);
				if(status[i]!=0)
					possible=true;
			}//for end 
			if(!possible) {
				System.out.println("엄마헬프");
				break;
			}
			
			result++;
			
			
			
			for(int i=0;i<queueSize;i++) {
				if(reFlag)
					break;
				Node node = queue.poll();
				
				for(int j=0;j<4;j++) {
					if(reFlag)
						break;
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
							queue.clear();
							visit = new boolean[N][N];
							
							babyStomach++;
							status[map[thisY][thisX]]--;
							map[thisY][thisX]=0;
							if(babyStomach==babyShark) {
								babyShark++;
								System.out.println("업그레이드를하여"+babyShark+"가 되었다");
								babyStomach=0;
							}//if end
							visit[thisY][thisX]=true;
							reFlag=true;
						}//if end
						queue.offer(new Node(thisY,thisX));
						continue;
					}//if end
				}//for end 
			}//for end 

			System.out.println();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(map[i][j]+" ");
				}//for end 
				System.out.println();
			}//for end
			System.out.println();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(visit[i][j]+" ");
				}//for end 
				System.out.println();
			}//for end
		}//while end 
		
		System.out.println(result);
		
		br.close();		
	}//main() end
}//class end 
