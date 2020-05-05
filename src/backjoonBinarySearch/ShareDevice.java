package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShareDevice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int houseNum = Integer.parseInt(st.nextToken());
		int deviceNum = Integer.parseInt(st.nextToken());
		
		int[] house = new int[houseNum];
		
		for(int i=0;i<houseNum;i++) {
			house[i] = Integer.parseInt(br.readLine());
		}//for end
		
		Arrays.sort(house);
		
		int left=1;
		int right=house[house.length-1]-house[0];
		int mid;
		int result=0;
		
		while(left<=right) {
			int installedDevice=1;
			
			mid=(left+right)/2;
			
			int thisDevice=house[0];

			int tempMin=1000000000;
			
			for(int i=1;i<houseNum;i++) {
				int sub = house[i]-thisDevice;
				if(sub>=mid) {
					thisDevice=house[i];
					installedDevice++;
					if(sub<tempMin)
						tempMin=sub;
				}//if end
			}//for end
			
			if(installedDevice<deviceNum) {
				right = mid-1;
			}else if(installedDevice>=deviceNum) {
				left = mid+1;
				
				if(result<tempMin)
					result=tempMin;
			}//if~else if end
			
		}//while end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end