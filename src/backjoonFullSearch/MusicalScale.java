package backjoonFullSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MusicalScale {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int thisNum = Integer.parseInt(st.nextToken());
		
		int result = thisNum ;
		
			
		for(int i=0;i<7;i++) {
			int nextNum = Integer.parseInt(st.nextToken());
			if(Math.abs(thisNum-nextNum)!=1) {
				result = 0;
				break;
			}//if end
			thisNum = nextNum;
		}//for end
		
		if(result == 8) {
			System.out.println("descending");
		}else if(result == 1) {
			System.out.println("ascending");
		}else
			System.out.println("mixed");
		
		
		br.close();
		
	}//main() end
}
