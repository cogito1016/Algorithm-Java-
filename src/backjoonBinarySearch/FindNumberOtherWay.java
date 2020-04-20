package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumberOtherWay {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int numSize = Integer.parseInt(br.readLine());
		int[] numList = new int[numSize];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<numList.length;i++) {
			numList[i]=Integer.parseInt(st.nextToken());
		}//for end
		
		int targetNumSize = Integer.parseInt(br.readLine());
		int[] targetNumList = new int[targetNumSize];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<targetNumList.length;i++) {
			targetNumList[i]=Integer.parseInt(st.nextToken());
		}//for end
		
		
		Arrays.sort(numList);
		int left,right,mid,result;
		
		for(int targetNum : targetNumList) {
			left =0;
			right = numSize-1;
			result =0;
			
			while(left<=right) {
				mid = (left+right)/2;
				
				if(numList[mid]>targetNum) {
					right=mid-1;
				}else if(numList[mid]<targetNum) {
					left=mid+1;
				}else {
					result=1; 
					break;
				}//if~elseIf~else
			}//while end
			System.out.println(result);
		}//for end
		
	}//main() end
}//class end