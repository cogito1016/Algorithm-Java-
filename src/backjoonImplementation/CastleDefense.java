package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class CastleDefense {

	static class Monster{
		int x,y;
		Monster(int y,int x){
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
		List<Monster> monsters = new ArrayList<Monster>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					monsters.add(new Monster(i,j));
			}//for end
		}//for end
		
		int[] archersLoc = new int[3];
		boolean failFlag = false;
		archersLoc[0]=0;
		archersLoc[1]=2;
		archersLoc[2]=4;
		
		while(!monsters.isEmpty()&&!failFlag) {
			//궁수가 다쏴죽임
			for(int i=0;i<3;i++) {
				//왼쪽
				for(int j=0;j<D;j++) {
//					System.out.println(map[N-1][archersLoc[i]] );
				}//for end
				
				//가운데
				
				//오른쪽
			}//for end
			
			//몬스터움직임
			
		}//while end
		
		
		
		br.close();
	}//main() end
}//class end 