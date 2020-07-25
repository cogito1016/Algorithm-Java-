package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ShareDevice_Repeat {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		List<Integer> deviceLoc = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}//for end 
		
		Arrays.sort(arr);
		deviceLoc.add(0);
		C--;
		
		int left = 0;
		int right = arr.length-1;
		int mid;
		
		while(left<=right) {
			mid = (left+right)/2;
		

		}//while end
		
		br.close();
	}//main() end
}