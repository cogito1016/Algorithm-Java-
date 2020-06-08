package backjoonTwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class PartSum {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());
		
		int[] list = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}//for end 
		
		int left=0,right=0;
		long sum = list[0];
		int min = N;
		boolean ansFlag = false;
		
		while(left<=right){
//			System.out.println("left="+left+" right="+right+" sum="+sum);
			if(sum<S) {
				right++;
				if(right>N-1)
					break;
				sum+=list[right];
			}else{
				ansFlag=true;
				min = min<(right-left+1)?min:(right-left+1);
				sum-=list[left];
				left++;
			}//If~else end
			
			
		}//for end 
		if(ansFlag)
			System.out.println(min);
		else
			System.out.println(0);
		
		br.close();
	}//main() end
}//class end 