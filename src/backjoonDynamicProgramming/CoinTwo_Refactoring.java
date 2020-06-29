package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class CoinTwo_Refactoring {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		boolean[] possible = new boolean[k+1];
		
		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}//for end
	
		possible[0] = true;
		
		for(int i=0;i<n;i++) {
			for(int j=k;j>0;j--) {
				int top = j/coin[i];
				
				for(int a=top;a>0;a--) {
					int tempTop = a * coin[i];
					int tempBottom = j-tempTop;
					
					if(!possible[tempBottom])
						continue; //if end
					
					if(dp[j]==0) {
						dp[j]=a+dp[tempBottom];
						possible[j]=true;
						continue;}//if end
					
					possible[j]=true;
					dp[j]=Math.min(a+dp[tempBottom],dp[j]);
				}//for end
			}//for end	
		}//for end
		
		if(!possible[k])
			System.out.println(-1);
		else
			System.out.println(dp[k]);
		
		br.close();
	}//main() end
}//class end