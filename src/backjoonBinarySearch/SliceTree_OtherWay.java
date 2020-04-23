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
		
		int left=0;
		int right = size -1;
		int mid;
		int minHeight = 0;
		
		while(left<=right) {
			mid = (left+right)/2;
			long sum =0;
			for(int i=mid;i<size;i++) {
				sum+= list[i]-list[mid];
			}//for end
			
			if(sum==targetNum) {
				minHeight=list[mid];
				break;
			}//if end
			
			if(sum>targetNum)
				left=mid+1;
			if(sum<targetNum)
				right=mid-1;
			
			if(left>right) {
				for(int i=list[right]+1;i<list[left];i++) {
					sum =0;
					
					for(int j=left;j<size;j++) {
						sum+= list[j]-i;
					}//for end
					
					System.out.println(sum);
					minHeight=i;
					if(sum==targetNum) {
						break;
					}//if end
					if(sum<targetNum) {
						minHeight=i-1;
						break;
					}
				}//for end
			}//if end
		}//while end
		System.out.println(minHeight);
		br.close();
	}//main() end
}//class end