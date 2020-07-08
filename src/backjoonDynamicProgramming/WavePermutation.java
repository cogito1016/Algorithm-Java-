package backjoonDynamicProgramming;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class WavePermutation {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[] answer = new int[T];
		
		int max = 0;
		for(int i=0;i<T;i++) {
			answer[i] = Integer.parseInt(br.readLine())-1;
			if(max<answer[i])
				max=answer[i];
		}//for end 
		
		long[] dp = new long[max+3];
		dp[0]=1;
		dp[1]=1;
		dp[2]=1;
		for(int i=3;i<=max;i++) {
			dp[i] = dp[i-3]+dp[i-2];
		}//for end
		
		for(int i=0;i<T;i++) {
			bw.write(dp[answer[i]]+"");
			if(i!=T-1)
				bw.write("\n");
		}//for end
		
		br.close();
		bw.close();
	}//main() end
}