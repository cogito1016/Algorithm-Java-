package backjoonDynamicProgramming;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class SquaredNumber {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[1]=1;

		int rootResult =  (int) Math.sqrt(N);
		int powResult = (int) Math.pow(rootResult, 2);
		
		
		
		System.out.println(dp[N]);
		br.close();		
	}//main() end
}//class end