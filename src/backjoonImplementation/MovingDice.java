package backjoonImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MovingDice {
	
	static class Dice{
		int x,y; 
		int front,back,up,down,left,right;
		
		public Dice(int y,int x) {
			this.x=x;
			this.y=y;
		}
		
		int getUp() {
			return this.up;
		}
		
		int getDown() {
			return this.down;
		}
		
		void turnSouth() {
			int temp = this.up;
			this.up=this.back;
			this.back=this.down;
			this.down=this.front;
			this.front=temp;
			this.y++;
		}//turnSouth() end
		
		void turnNorth() {
			int temp = this.up;
			this.up=this.front;
			this.front=this.down;
			this.down=this.back;
			this.back=temp;
			this.y--;
		}//turnNorth() end
		
		void turnEast() {
			int temp = this.right;
			this.right=this.up;
			this.up=this.left;
			this.left=this.down;
			this.down=temp;
			this.x++;
		}//turnEast() end
		
		void turnWest() {
			int temp = this.left;
			this.left=this.up;
			this.up=this.right;
			this.right=this.down;
			this.down=temp;
			this.x--;
		}//turnWest() end 
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		String[] direction = new String[5];
		direction[1]="EAST";
		direction[2]="WEST";
		direction[3]="NORTH";
		direction[4]="SOUTH";
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}//for end
		}//for end 
		
		Dice dice = new Dice(y,x);
		
		st = new StringTokenizer(br.readLine());
		while(K-- >0) {
			String direct = direction[Integer.parseInt(st.nextToken())];
			
			switch (direct) {
			case "SOUTH":
				dice.turnSouth();
				break;
			case "WEST":
				dice.turnWest();
				break;
			case "NORTH":
				dice.turnNorth();
				break;
			case "EAST":
				dice.turnEast();
				break;
			}//switch end
			
			if(dice.y>=R || dice.y<0 || dice.x>=C || dice.x<0) {
				switch (direct) {
				case "SOUTH":
					dice.turnNorth();
					break;
				case "WEST":
					dice.turnEast();
					break;
				case "NORTH":
					dice.turnSouth();
					break;
				case "EAST":
					dice.turnWest();
					break;
				}//switch end
				continue;
			}//if end
			
			int thisValue = map[dice.y][dice.x];
			
			if(thisValue==0) {
				map[dice.y][dice.x]=dice.getDown();
			}else {
				dice.down=thisValue;
				map[dice.y][dice.x]=0;
			}//if~else end
			bw.write(dice.getUp()+"\n");
			bw.flush();
		}//while end
		
		bw.close();
		br.close();
	}//main() end 
}
