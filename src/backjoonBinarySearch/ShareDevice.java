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
		
		int max=house[houseNum-1]-house[0];
		int min=0;
		int left=house[0];
		int right = house[houseNum-1];
		int mid;
		int recentHouse;
		int count;
		
		while(left<=right) {
			mid = (left+right)/2;
			min=max;
			recentHouse=house[0];
			count=1;
			
			for(int thisHouse : house) {
				int gap = thisHouse - recentHouse;
				if(gap>=mid) {
					if(gap<min)
						min=gap;
					recentHouse=thisHouse;
					count++;
				}//if end
			}//for end
		
			if(count<deviceNum) {
				right=mid-1;
			}else if(count>deviceNum) {
				left=mid+1;
			}else {
				break;
			}//if~elseIf~else end 
		}//while end
		
		
		System.out.println(min);
		
		br.close();
	}//main() end
}//class end