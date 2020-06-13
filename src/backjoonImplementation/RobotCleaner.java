package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner {
	
	static int[][] map;
	static boolean[][] visit;
	static int N,M;
	
	static class Robot{
		int x,y;
		int d;
		
		Robot(int y,int x, int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}//cons end
		
		boolean leftCleanCheck() {
			if(d==0 && visit[this.y][this.x-1]) {
				return true;
			}else if(d==1 && visit[this.y-1][this.x]) {
				return true;
			}else if(d==2 && visit[this.y][this.x+1]) {
				return true;
			}else if(d==3 && visit[this.y+1][this.x]) {
				return true;
			}//if~else if end 
			return false;
		}//leftCheck() end
		
		boolean leftCheck() {
			if( d==0 && (this.y>=0 && this.y<N && this.x-1>=0 && this.x-1<M )) {
				if(map[this.y][this.x-1]==0)
					return true;
			}else if( d==1 && (this.y-1>=0 && this.y-1<N && this.x>=0 && this.x<M ) ) {
				if(map[this.y-1][this.x]==0)
					return true;
			}else if(d==2 && (this.y>=0 && this.y<N && this.x+1>=0 && this.x+1<M )) {
				if(map[this.y][this.x+1]==0)
					return true;
			}else if(d==3 && (this.y+1>=0 && this.y+1<N && this.x>=0 && this.x<M )) {
				if(map[this.y+1][this.x]==0)
					return true;
			}//if~elseIf end
			return false;
		}//leftCheck() end
		
		void turnLeft() {
			this.d = (this.d+3)%4;
		}//turnLeft() end
		
		void go() {
			if(d==0) {
				this.y--;
			}else if(d==1) {
				this.x++;
			}else if(d==2) {
				this.y++;
			}else if(d==3) {
				this.x--;
			}//if~elseif end
		}//go() end
		
		void back() {
			if(d==0) {
				this.y++;
			}else if(d==1) {
				this.x--;
			}else if(d==2) {
				this.y--;
			}else if(d==3) {
				this.x++;
			}//if~elseif end
		}//back() end
		
		boolean backCheck() {
			if( d==0 && (this.y+1>=0 && this.y+1<N && this.x>=0 && this.x<M )) {
				if(map[this.y+1][this.x]==0)
					return true;
			}else if( d==1 && (this.y>=0 && this.y<N && this.x-1>=0 && this.x-1<M ) ) {
				if(map[this.y][this.x-1]==0)
					return true;
			}else if(d==2 && (this.y-1>=0 && this.y-1<N && this.x>=0 && this.x<M )) {
				if(map[this.y-1][this.x]==0)
					return true;
			}else if(d==3 && (this.y>=0 && this.y<N && this.x+1>=0 && this.x+1<M )) {
				if(map[this.y][this.x+1]==0)
					return true;
			}//if~elseIf end
			return false;
		}//backCheck() end
		
		void clean() {
			visit[this.y][this.x]=true;
		}//clean() end
		
	}//class Robot end

	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		Robot robot = new Robot(r,c,d);
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}//for end
		}//for end
		
		int check = 0;
		int result = 1 ;
		robot.clean(); //청소 븨잉
		
		while(true) {
			 
			if(check==4) {
				if(robot.backCheck()) { //뒤 갈수있겠다
					robot.back();
					check=0;
				}else { //뒤가없는디?
					break;
				}//if~else end
			}//if end
			
			if(robot.leftCheck()) { //왼쪽이 존재해
				if(robot.leftCleanCheck()) { //근데 왼쪽 청소했어
					robot.turnLeft();//돌아
					check++;
					continue;
				}//if end 
				else { //왼쪽 청소안했어
					robot.turnLeft();//돌아
					robot.go();//가
					robot.clean();
					check=0;
					result++;
					continue;
				}//if~else end
			}//if end
			else {//왼쪽없는디??
				robot.turnLeft();
				check++;
				continue;
			}//if~else end
			
		}//while end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end