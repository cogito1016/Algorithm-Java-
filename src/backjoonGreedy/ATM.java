package backjoonGreedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] timeList = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			timeList[i] = Integer.parseInt(st.nextToken());
		}//for end
		
		Arrays.sort(timeList);
		
		int result = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				result += timeList[j];
			}//for end 
		}//for end 
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end 