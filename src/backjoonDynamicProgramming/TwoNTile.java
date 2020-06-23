package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoNTile {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n+1];
		dp[0]=1;
		dp[1]=1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = (dp[i-2]+dp[i-1])%10007;
		}//for end
		
		System.out.println(dp[n]);
		
		br.close();
	}//main() end
}//class end