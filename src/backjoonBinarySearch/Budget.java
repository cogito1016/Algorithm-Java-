package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Budget {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int citiesNum = Integer.parseInt(br.readLine());
		int[] cities = new int[citiesNum];
		
		st=new StringTokenizer(br.readLine());
		int max=0;
		int total=0;
		for(int i=0;i<citiesNum;i++) {
			total+=cities[i]=Integer.parseInt(st.nextToken());
			if(max<cities[i])
				max=cities[i];
		}//for end
		
		int budget = Integer.parseInt(br.readLine());
		int result = 0;
		if(budget==total)
			System.out.println(max);
		else {
			int left = 1;
			int right = max;
			int mid;
			
			while(left<=right) {
				mid = (left+right)/2;
				
				int tempBudget=0;
				for(int i=0;i<citiesNum;i++) {
					int temp = cities[i]-mid;
					if(temp>0)
						tempBudget+=mid;
					else if(temp<=0)
						tempBudget+=cities[i];
				}//for end
				
				if(tempBudget<=budget) {
					left=mid+1;
					result=mid;
					if(tempBudget==budget)
						break;
				}
				else if(tempBudget>budget)
					right=mid-1;
				
			}//while end
			System.out.println(result);
		}//if~else end
		br.close();
	}//main() end
}//class end