package backjoonImplementation;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class UniqueGame {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] visit = new int[101][3];
		int[] result = new int[N];
		String[] info = new String[N]; 
				
		for(int i=0;i<N;i++) {
			info[i] = br.readLine();
			st = new StringTokenizer(info[i]);
			for(int j=0;j<3;j++) {
				visit[Integer.parseInt(st.nextToken())][j]++;
			}//for end
		}//for end
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(info[i]);
			for(int j=0;j<3;j++) {
				int thisNum=Integer.parseInt(st.nextToken());
				if(visit[thisNum][j]==1) {
					result[i]+=thisNum;
				}//if end
			}//for end
		}//for end
		
		for(int item : result) {
			System.out.println(item);
		}//for end
		
		br.close();
	}//main() end
}//class end