package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TenRuleCar {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int standardNum = Integer.parseInt(br.readLine());
		int result=0;
		st = new StringTokenizer(br.readLine());
		
		
		for(int i=0;i<5;i++) {
			if(standardNum==Integer.parseInt(st.nextToken()))
				result++;
		}//for end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end