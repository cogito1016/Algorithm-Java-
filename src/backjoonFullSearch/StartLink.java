package backjoonFullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartLink {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x; 
			this.y=y;
		}//cons end
	}//class end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int size = Integer.parseInt(br.readLine());
		int[][] map = new int[size][size]; 
		boolean[][] visit = new boolean[size][size];
		
		for(int i=0;i<size;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}//for end
		}//for end

		for(int i=0;i<size;i++) {
			
			for(int j=0;j<size;j++) {
					
			}//for end
		}//for end
		
		br.close();
	}//main() end
}//class end