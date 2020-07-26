package backjoonRecursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColorPaper {
	
	static int blue=0;
	static int white=0;
	
	public static void cut(int current, int r, int c, int[][] map) {	
		
		boolean checkPossible = false;
		int base=0; //0->white 1->blue
		
		for(int i=r;i<r+current;i++) {
			for(int j=c;j<c+current;j++) {
				if(i==r&&j==c)
					base=map[i][j];
				if(map[i][j]!=base) {
					checkPossible = false;
					break;
				}
				checkPossible=true;
			}//for end 
			if(!checkPossible)
				break;
		}//for end 
		
		if(checkPossible) {
			if(base==0) 
				white++;
			else
				blue++;
			return;
		}//if end
		
		if(current==1)
			return;
		
		current/=2;
		cut(current,r,c,map);
		cut(current,r+current,c,map);
		cut(current,r,c+current,map);
		cut(current,r+current,c+current,map);
		
		
		
	}//cut() end

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}//for end
		}//for end 
		
		cut(N,1,1,map);
		
		System.out.println(white);
		System.out.println(blue);
		br.close();
	}//main() end 
}
