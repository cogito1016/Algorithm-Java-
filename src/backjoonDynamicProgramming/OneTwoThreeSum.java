package backjoonDynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OneTwoThreeSum {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- >0) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n+3];
			dp[1]=1;
			dp[2]=2;
			dp[3]=4;
			
			for(int i=4;i<=n;i++) {
				dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
			}//for end
			
			System.out.println(dp[n]);
		}//while end
		br.close();
	}//main() end
}//class end