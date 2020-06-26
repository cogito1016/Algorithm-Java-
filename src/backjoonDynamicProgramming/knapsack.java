package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class knapsack {

	static class Item{
		int weight,val;
		Item(int weight,int val){
			this.weight=weight;
			this.val=val;
		}//cons end
	}//Node end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N][K+1];
		Item[] items = new Item[N];
		
		int max = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			items[i]=new Item(weight,value);
		}//for end
		
		Arrays.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				if(o1.weight>o2.weight) {
					return 1;
				}else if(o1.weight==o2.weight) {
					if(o1.val<o2.val)
						return 1;
				}
				return -1;}});
		
		for(int i=0;i<N;i++) {//아이템무게
			Item thisItem = items[i];
			int thisWeight = thisItem.weight;
			int thisVal = thisItem.val;
			
			for(int j=1;j<=K;j++) {//배낭무게
				
				if(i==0) {
					if(j>=thisWeight)
						dp[i][j]=thisVal;
				}else if(j>=thisWeight) {
					dp[i][j] = Math.max(dp[i-1][j], thisVal + dp[i-1][j-thisWeight]);
				}else {
					dp[i][j] = dp[i-1][j];
				}

				if(dp[i][j]>max)
					max=dp[i][j];
			}//for end
		}//for end
		
//		for(int i=0;i<N;i++) {//아이템무게
//			Item thisItem = items[i];
//			int thisWeight = thisItem.weight;
//			int thisVal = thisItem.val;
//			
//			System.out.print("val : "+thisVal+" weight :"+thisWeight);
//			for(int j=0;j<=K;j++) {
//				System.out.print(" "+dp[i][j]);
//			}//for end
//			System.out.println();
//		}//for end
		
		System.out.println(max);
		
		br.close();
	}//main() end
}//class end