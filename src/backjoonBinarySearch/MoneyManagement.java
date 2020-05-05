package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MoneyManagement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int days = Integer.parseInt(st.nextToken());
		int chance = Integer.parseInt(st.nextToken());
		int[] list = new int[days];
		
		long total=0;
		long max=0;
		for(int i=0;i<days;i++) {
			list[i]= Integer.parseInt(br.readLine());
			total+=list[i];
			if(list[i]>max)
				max=list[i];
		}//for end
		
		long left = max;
		long right = total;
		long mid;
		long result=total;
		while(left<=right) {
			mid = (left+right)/2;
			
			long temp = mid;
			int count = 1;
			for(int i=0;i<days;i++) {
				temp -= list[i];
				if(temp==0) {
					temp=mid;
					count++;
				}
				if(temp<0) {
					temp = mid;
					temp-=list[i];
					count++;
				}//if end
			}//for end
			
			if(count<=chance) {
				right=mid-1;
				if(result>mid)
					result=mid;
			}else if(count>chance)
				left=mid+1;
			//else~if end
		}//while end
		
		System.out.println(result);
		
		br.close();
	}
}//class end