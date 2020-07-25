package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShareDevice_Repeat {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}//for end 
		
		Arrays.sort(arr);
		
		int min = arr[1]-arr[0];
		int max = arr[N-1]-arr[0];
		int avg;
		int result = 0;
		while(min<=max) {
			avg = (min+max)/2;
			
			int base = arr[0];
			int installedDevice = 1;
			int minDistance = 1000000000;
			
			for(int i=1;i<N;i++) {
				int gap = arr[i]-base;
				if(gap>=avg) {
					installedDevice++;
					base=arr[i];
					if(minDistance>gap)
						minDistance=gap;
				}//if end
			}//for end
			
			if(installedDevice>=C) {
				min=avg+1;
				if(minDistance>result)
					result=minDistance;
			}else if(installedDevice<C) {
				max=avg-1;
			}//if end
		}//while end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}