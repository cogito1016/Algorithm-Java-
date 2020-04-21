package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int size = Integer.parseInt(br.readLine());
		int[] list = new int[size];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<size;i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}//for end
		
		Arrays.sort(list);
		
		int compareSize = Integer.parseInt(br.readLine());
		int[] compareList = new int[compareSize];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<compareSize;i++) {
			compareList[i]=Integer.parseInt(st.nextToken());
		}//for end
		
		
		for(int compareNum : compareList) {

			int left =0;
			int right =size-1;
			int mid;
			int result=0;
			
			while(left<=right) {
				mid = (left+right)/2;
				
				if(list[mid]>compareNum)
					right=mid-1;
				else if(list[mid]<compareNum)
					left=mid+1;
				else {
					result =1;
					break;
				}//if~elseIf~else end
			}//while end
			System.out.println(result);
		}//for end
		
		br.close();
	}//main() end
}// class end