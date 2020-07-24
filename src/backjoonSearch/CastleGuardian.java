package backjoonSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CastleGuardian {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] row = new boolean[N];
		boolean[] column = new boolean[M];
		int rowNum = N;
		int colNum = M;
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)=='X') {
					if(!row[i]) {
						row[i]=true;
						rowNum--;
					}
					
					if(!column[j]) {
						column[j]=true;
						colNum--;
					}
				}//if end
			}//for end 
		}
		
		System.out.println(rowNum>colNum?rowNum:colNum);
		br.close();
	}//main() end
}
