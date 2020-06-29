package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class CoinTwo {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		
		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}//for end
		
		
		
		for(int i=0;i<n;i++) {
			for(int j=k;j>0;j--) {
				int top = j/coin[i];
				int bottom = j%coin[i];
				
//				if(dp[j]==0 && bottom==0) {
//					dp[j]=top;
//					continue;}//if end
//				
				for(int a=top;a>0;a--) {
					int tempTop = a * coin[i];
					int tempBottom = j-tempTop;
					
					if(dp[tempBottom]==0 && tempBottom!=0)
						continue; //if end
					
					if(dp[j]==0) {
						dp[j]=a+dp[tempBottom];
						continue;}//if end
					
					dp[j]=Math.min(a+dp[tempBottom],dp[j]);
				}

//				if(dp[j]==0) {
//					dp[j]=top+dp[bottom];
//					continue;
//				}//if end
//				dp[j]=Math.min(top+dp[bottom],dp[j]);
				
			}//for end	
		}//for end
		
		if(dp[k]==0)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
		
		br.close();
	}//main() end
}//class end