package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CuttingLan {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int havingLanNum = Integer.parseInt(st.nextToken());
		int necesarryLanNum = Integer.parseInt(st.nextToken());
		
		int[] lanList = new int[havingLanNum];
		
		for(int i=0;i<havingLanNum;i++) {
			lanList[i]=Integer.parseInt(br.readLine());
		}//for end
		
		Arrays.sort(lanList);
		
		long left = 1;
		long right = lanList[lanList.length-1]; 
		long mid;
		long answer=0;
		
		while(left<=right) {
			mid = (left+right)/2;
			
			long total = 0;
			for(int i=0;i<lanList.length;i++) {
				total += lanList[i]/mid;
			}//for end
			
			if(total<necesarryLanNum) 
				right = mid-1;
			if(total>=necesarryLanNum) {
				answer=mid;
				left=mid+1;
			}//if end
		}//while end
		System.out.println(answer);
		br.close();
	}//main() end
}//class end