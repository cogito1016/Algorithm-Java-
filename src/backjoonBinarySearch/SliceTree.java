package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SliceTree {

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
		int answer=0;
		long sum;
		boolean flag = false ;
		while(left<=right) {
			mid = (left+right)/2;
			sum=0;
			for(int i=mid;i<size;i++) {
				sum += list[i];
			}//for end
			int birTreeSize = size-mid;
			long bigTreeTotal = list[mid]*birTreeSize;
			long finalSum = sum - bigTreeTotal;
			if(finalSum==targetNum) {
				answer=list[mid];
				break;
			}//if end
			
			if(finalSum<targetNum) {
				right=mid-1;
				if(left>right) {
					int temp = left;
					right = list[left+1]-1;
					left = list[temp-1]+1;
					flag=true;
				}
			}//if end
			
			if(finalSum>targetNum) {
				left=mid+1;
				if(left>right) {
					int temp = left;
					left = list[left-1]+1;
					right = list[temp+1]-1;
					flag=true;
				}
			}//if end
				
			if(flag) {
				
				while(left<=right) {
					mid = (left+right)/2;
					finalSum=sum - mid*birTreeSize;
					if(finalSum==targetNum){
						answer=mid;
						break;
					}//if end
					
					if(finalSum>targetNum) {
						answer=mid;
						left= mid+1; 
					}//if end
					if(finalSum<targetNum)
						right= mid-1;
				}//while end
				break;
			}//if end
			
		}//while end
		
		System.out.println(answer);
		
		br.close();
	}//main() end
}//class end