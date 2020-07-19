package backjoonGreedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin0 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		int neededCoin = 0;
		
		for(int i=0;i<N;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}//for end
		
		for(int i=N-1;i>=0;i--) {
			if(coins[i]>K)
				continue;
			neededCoin += K/coins[i];
			K = K%coins[i];
		}//for end
		
		System.out.println(neededCoin);
		 
		br.close();
	}//main() end
}