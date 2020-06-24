package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ZeroOneTile {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if(N==1||N==2){
			System.out.println(N);
			return;
		}
		
		int[] dp = new int[100001];
		dp[0]=1;
		dp[1]=2;
		

		N-=2;
		int idx = 2;
		while(N-- >0) {
			if(idx==100001) {
				dp[0]=dp[99999];
				dp[1]=dp[100000];
				idx=2;
			}
			dp[idx] = (dp[idx-2]+dp[idx-1])%15746;
			idx++;
		}
		 
		System.out.println(dp[idx-1]);
		
		br.close();
	}//main() end
}//class end