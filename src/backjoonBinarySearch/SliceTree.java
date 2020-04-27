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
		
		long left =1;
		long right = list[list.length-1];
		long mid;
		long answer=0;
		
		while(left<=right) {
			mid = (left+right)/2;
			
			long total=0;
			for(int i=0;i<size;i++) {
				long cuttingTree = list[i]-mid;
				if(cuttingTree<0)
					continue;
				else
					total+= cuttingTree;
			}//for end

			if(total<targetNum)
				right=mid-1;
			if(total>=targetNum) {
				answer=mid;
				left=mid+1;
			}
			
		}//while end
		
		
		System.out.println(answer);
		br.close();
	}//main() end
}//class end