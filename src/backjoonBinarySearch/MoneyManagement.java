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
		}//for end
		
//		Arrays.sort(list);

		max=list[days-1];
		
		long left=max;
		long right=total;
		long mid;
		long result=0;
		if(days==chance) {
			System.out.println(left);
		}else if(chance==1) {
			System.out.println(right);
		}else {
			while(left<=right) {
			
				mid = (left+right)/2;
				
				int opp=1;
				long temp=mid;
				
				
				for(int i=0;i<days;i++) {
					temp-=list[i];
					if(temp==0) {
						temp=mid;
						opp++;
					}//if end
					else if(temp<0) {
						temp=mid;
						temp-=list[i];
						opp++;
					}//if end
				}//for end
				
				if(opp<=chance) {
					right=mid-1;
					result=mid;
				}else
					left=mid+1;		
			}//while end
			System.out.println(result);
		}
		
		
		br.close();
	}
}//class end