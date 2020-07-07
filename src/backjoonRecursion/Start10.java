package backjoonRecursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Start10 {

	static char[][] map;
	
	public static void star(int N,int r,int c) {
		
		if(N==3) {
			for(int i=r;i<r+3;i++) {
				for(int j=c;j<c+3;j++) {
					if(i==r+1&&j==c+1)
						continue;
					
					map[i][j]='*';
				}//for end
			}//for end3
			return ;
		}//if end
		
		int divideNum = N/3;
		for(int i=r;i<r+N;i+=divideNum) {
			for(int j=c;j<c+N;j+=divideNum) {
				if(i==r+divideNum&&j==c+divideNum)
					continue;
				star(divideNum,i,j);
			}//for end
		}//for end
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(map[i], ' ');
		}//for end
		star(N,0,0);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				bw.write(map[i][j]);
			}//for end
			bw.write("\n");
		}//for end
		br.close();
		bw.close();
	}//main() end
}
