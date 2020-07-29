package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KnapSack_Repeat {
	
	static class Item{
		int w,v;
		Item(int w,int v){
			this.w=w;
			this.v=v;
		}//cons end
	}//class end

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Item> list = new ArrayList<Item>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Item(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}//while end
		
		int[] dp = new int[K+1];
		for(Item item : list) {
			for(int i=K;i>=1;i--) {
				if(item.w<=i) {
					dp[i]=Math.max(dp[i],item.v+dp[i-item.w]);
				}//if end
			}//for end	
		}//for end
		System.out.println(dp[K]);
		br.close();
	}//main() end
}
