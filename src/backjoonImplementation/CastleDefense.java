package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class CastleDefense {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//class node end 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M];
		List<Node> monsters = new ArrayList<Node>();
		boolean failFlag = false;
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					monsters.add(new Node(i,j));
			}//for end 
		}//for end
		
		int[] archerLoc = {0,2,4};
		
		while(!failFlag  && monsters.size()!=0) {
			
			List<Node> objMonsters = new ArrayList<Node>();
			
			for(int archerX : archerLoc) {
				for(int a=1;a<=D;a++) {
					if(archerX-1>=0) {
						int left = map[N-a][archerX-1];
						if(left==1) {
							objMonsters.add(new Node(N-a,archerX-1));
							break;
						}//if end
					}//if end

					int mid = map[N-a][archerX];
					if(mid==1) {
						objMonsters.add(new Node(N-a,archerX));
						break;
					}//if end
					if(archerX+1<M) {
						int right = map[N-a][archerX+1];
						if(right==1) {
							objMonsters.add(new Node(N-a,archerX+1));
							break;
						}//if end 
					}//if end
				}//for end
			}//for end
			
			
			
			System.out.println();
			for(int i=0;i<monsters.size();i++) {
				Node node = monsters.get(i);
				
				
				if(node.y+1>=N) {//성침입{
					System.out.println("겜끝");
					failFlag=true;
					break;
				}
				map[node.y][node.x]=0;
				monsters.get(i).y++;
				map[node.y][node.x]=1;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(map[i][j]+" ");
				}//for end 
				System.out.println();
			}//for end
			
		}
		
		br.close();
	}//main() end
}//class end 