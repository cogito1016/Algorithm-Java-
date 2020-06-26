package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class knapsack_Refactoring {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[K+1];
		int[] w = new int[N];
		int[] val = new int[N];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			val[i] = Integer.parseInt(st.nextToken());
		}//for end
		
		for(int i=0;i<N;i++) {
			for(int j=K;j>0;j--) //배낭무게
				if(j>=w[i]) 
					dp[j]=Math.max(dp[j], val[i]+dp[j-w[i]]);
		}//for end
		
		System.out.println(dp[K]);
		
		br.close();
	}//main() end
}//class end