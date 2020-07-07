package backjoonRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {

	static int[][] map;
	static int zCount;
	static int count;
	static int r,c;
	
	
	public static void recursion(int firstR,int firstC, int secondR, int secondC) {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[N][N];
//		recursion(N,N);
		
		br.close();
	}//main() end
}
