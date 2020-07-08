package backjoonString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;



public class StringRepeat {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(T-- >0) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			
			String P = "";
			for(int i=0;i<S.length();i++) {
				String temp = S.charAt(i)+"";
				for(int j=0;j<R;j++) {
					P+=temp;
				}//for end
			}//for end
			System.out.println(P);
		}//while end
		
		
		br.close();
	}//main() end
}
