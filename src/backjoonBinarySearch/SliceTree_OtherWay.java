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
		int mid,tempNum;
		long result;
		int minHeight=0;
		
		while(left<=right) {
			mid = (right+left)/2;
			result =0;
			tempNum = list[mid];
			
			for(int i=mid+1;i<size;i++) {
				result += list[i]-tempNum;
			}//for end
			
			minHeight=list[mid];
			if(result<targetNum) {
					
				right=mid-1;
				

				if(left>=right) {
					for(int i=0;i<list[mid];i++) {

						result =0;
						
						for(int j=mid;j<size;j++) {
							result+= list[j]-i;
						}//for end
						if(result<targetNum)
							break;
						minHeight=i;
						if(result==targetNum)
							break;
					}//for end
				}//if end
				
			}else if(result>targetNum) {
				left=mid+1;
			}else {
				break;
			}//if~elseIf~else end
		}//while end
		
		System.out.println(minHeight);
		
		br.close();
	}//main() end
}//class end