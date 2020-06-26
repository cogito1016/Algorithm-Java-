package backjoonDynamicProgramming;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class SquaredNumber {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int rootResult =  (int) Math.sqrt(N);
		int[] dp = new int[rootResult+1];
		int[] minList = new int[N+1];
		
		for(int i=1;i<=N;i++) { //현재 타겟 수
			int min = i;
			
			for(int j=1;j<=dp.length;j++) { //현재 제곱 수
				int pow = (int) Math.pow(j,2);
				if(i<pow)
					break;
				
				int top = i/pow;
				int bottom = i%pow;
				
				if(bottom==0)
					dp[j]=top;
				else
					dp[j]=minList[pow]*top+minList[bottom];
				
				if(dp[j]<min)
					min=dp[j];
			}//for end
			minList[i]=min;
		}//for end
		
		System.out.println(minList[N]);
		
		br.close();		
	}//main() end
}//class end