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
	
	static class Node{
		int count;
		int number;
		Node(int number, int count){
			this.count=count;
			this.number=number;
		}//cons end
	}//class end

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
				
				if(dp[j]==0) {
					dp[j]=top+dp[bottom];
					continue;
				}//if end
				dp[j]=Math.min(top+dp[bottom],dp[j]);
				
			}//for end	
		}//for end
		
		System.out.println(dp[k]);
		
		br.close();
	}//main() end
}//class end