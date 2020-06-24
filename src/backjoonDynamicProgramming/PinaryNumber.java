package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		dp[0]=1;
		dp[1]=1;
		
		for(int i=2;i<=N;i++) {
			dp[i]=dp[i-2]+dp[i-1];
		}//for end
		
		System.out.println(dp[N-1]);
		
		br.close();
	} //main() end
	
}//class end