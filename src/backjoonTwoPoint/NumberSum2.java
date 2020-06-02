package backjoonTwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberSum2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] list = new int[size];
		for(int i=0;i<size;i++) {
			list[i]= Integer.parseInt(st.nextToken());
		}//for end
		
		int left = 0;
		int right = 0;
		int result = 0;
		int sum = list[left];
		while(left<size) {
			
			if(sum==goal){
				result++;
				sum-=list[left];
				left++;
				right++;
				if(right>=size)
					break;
				sum+=list[right];
			}else if(sum<goal) {
				right++;
				if(right>=size)
					break;
				sum+=list[right];
			}else if(sum>goal) {
				sum-=list[left];
				left++;
			}//if~ elseIf ~ elseIf end
			
		}//while end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//NumberSum2 end