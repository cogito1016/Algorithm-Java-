package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SliceTree_OtherWay {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int targetNum = Integer.parseInt(st.nextToken());
		
		int[] list = new int[size];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<size;i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}//for end
		
		Arrays.sort(list);
		
		int right = size-1;
		int left = 0;
		int mid;
		int tempResult;
		int thisHeight;
		int maxHeight=0;
		
		while(left<=right) {
			mid = (left+right)/2;
			thisHeight = list[mid];
			tempResult =0;
			for(int i=mid+1;i<size;i++) {
				tempResult+=list[i]-thisHeight;
			}//for end
			
			if(tempResult>targetNum) {
				left = mid+1;
			}else if(tempResult<targetNum) {
				right = mid-1;
			}else {
				maxHeight=thisHeight;
				break;
			}//If~elseIf~If
			
			if(left>=right) {

				
				for(int i=list[mid-1];i<list[mid];i++) {
					
					tempResult =0;
					for(int j=mid;j<size;j++) {
						tempResult+=list[j]-i;	
					}//for end
					if(tempResult<targetNum)
						break;
					maxHeight = i;
				}//for end
				
				
				break;
			}//if end
			
		}//while end
		
		System.out.println(maxHeight);
		
		br.close();
	}//main() end
}//class end