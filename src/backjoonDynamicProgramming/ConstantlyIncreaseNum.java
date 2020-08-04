package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConstantlyIncreaseNum {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		int[] numList = new int[N];
		int[] dp = new int[N];
		
		for(int i=0;i<N;i++) {
			numList[i]=Integer.parseInt(st.nextToken());
		}//for end

		for(int i=N-1;i>=0;i--) {
		
			int tempMaxValue = 1;
			for(int j=i;j<N;j++) {
				if(numList[i]<numList[j]) {
					int tempThisValue = dp[j]+1;
					if(tempThisValue>tempMaxValue)
						tempMaxValue=tempThisValue;
				}//if end
			}//for end
			dp[i]=tempMaxValue;
		}//for end
		
		int max = 0;
		for(int i=0;i<N;i++) {
			if(dp[i]>max)
				max=dp[i];
		}//for end
		
		System.out.println(max);
		

		br.close();
	}//main() end

}
