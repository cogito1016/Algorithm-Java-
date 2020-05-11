package backjoonQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class GoodFriend {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken())+1;
		
		List<Integer> queue = new ArrayList<Integer>();
		List<Integer> tempList = new ArrayList<Integer>() ;
		long answer = 0;
		int left;
		int right;
		int mid;
		int thisRight;
		int thisLeft;
		
		for(int i=0;i<num;i++) {
			String s = br.readLine();
			if(queue.size()>=k) {
				int removeNode = queue.remove(0);
				int removeLoc = tempList.indexOf(removeNode);
				tempList.remove(removeLoc);
			}//큐 초과시 제거
 
			int node = s.length();
			if(!queue.isEmpty()) {
				if(queue.contains(node)) {
					Collections.sort(tempList);
					left = 0;
					right = tempList.size()-1;
					mid = 0;
					thisRight=0;
					while(left<=right) {
						mid = (left+right)/2;
						if(tempList.get(mid)>node) {
							right = mid-1;
						}else if(tempList.get(mid)<=node) {
							left = mid+1;
							thisRight = mid;
						}
					}//while end
					
					left = 0;
					right = thisRight;
					mid = 0;
					thisLeft = 0;
					while(left<=right) {
						mid = (left+right)/2;
						if(tempList.get(mid)<node)
							left=mid+1;
						else if(tempList.get(mid)>=node) {
							right=mid-1;
							thisLeft=mid;
						}//if~ else if end
					}//while end
					answer+= (thisRight-thisLeft+1);
				}//if end
			}//if end 
			queue.add(node);
			tempList.add(node);
		}//for end
		
		System.out.println(answer);
		
		br.close();
	}//main() end
}//class end