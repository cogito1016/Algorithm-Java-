package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int numSize = Integer.parseInt(br.readLine());
		int[] numList = new int[numSize];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<numList.length;i++) {
			numList[i]=Integer.parseInt(st.nextToken());
		}//for end
		
		Arrays.sort(numList);
		
		int left = 0;
		int right = numSize-1;
		int mid;
		
		int findNum = 4 ;
		
		int leftPin=-1,rightPin=-1;
		if(numList[left]==findNum)
			leftPin=left;
		if(numList[right]==findNum)
			rightPin=right;
		
		int result=0;
		
		while(leftPin!=-1&&rightPin!=-1) {
			
			mid = (left+right)/2;
			
			if(numList[mid]>findNum)
				right = mid-1;
			if(numList[mid]<findNum)
				left = mid+1;
				
		}//while end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end