package backjoonDynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OneTwoThreeSum {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] result = new int[T];
		int max = 0;
		
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			result[i] = n;
			if(max<n)
				max=n;
		}//for end
		
		int[] dp = new int[max+3];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4;i<=max;i++) {
			dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
		}//for end
		
		for(int item : result) {
			System.out.println(dp[item]);
		}//for end
		
		br.close();
	}//main() end
}//class end