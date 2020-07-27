package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retirement_Refactoring2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}//for end
		
		if(N+T[N]-1 > N)
			dp[N]=0;
		else
			dp[N] = P[N];
		
		int result=dp[N];
		for(int i=N-1;i>=1;i--) {
			if( (i+T[i]-1)>N ) 
				continue;
			
			int max = 0 ;
			if(i+T[i]<=N) {
				for(int j=i+T[i];j<=N;j++) {
					if(max<dp[j])
						max=dp[j];
				}//for end
			}
			dp[i] = P[i]+max;
			if(dp[i]>result)
				result=dp[i];
		}//for end 
		
		System.out.println(result);
		
		
		br.close();
	}//main() end
}
