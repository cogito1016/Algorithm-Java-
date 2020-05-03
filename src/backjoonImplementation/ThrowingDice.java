package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThrowingDice {
	
	
	class Dice{
		int x,y;
		int[][] map = new int[4][3];
	
		Dice(){
			this.x=1;
			this.y=2;
		}//cons end
		
		public void turnNorth() {
			if(x==1) {
				y-=1;
				if(y<0)
					y=3;
			}//if end
			if(x==0||x==2) {
				x=1;
				y=0;
			}
		}
		
		public void turnSouth() {
			if(x==1) {
				y+=1;
				if(y>3)
					y=0;
			}//if end
		}
		
	}//dice class end

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		int instruction = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[y][x];
		for(int i=0;i<y;i++) {
			
			for(int j=0;j<x;j++) {
				
			}//for end
		}//for end
		
		br.close();
	}//main() end
}//class end