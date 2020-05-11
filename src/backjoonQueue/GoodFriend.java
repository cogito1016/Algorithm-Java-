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
		
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> tempList = new ArrayList<Integer>() ;
		long answer = 0;
		int left;
		int right;
		int mid;
		int thisRight;
		int thisLeft;
		int thisNum;
		
		for(int i=0;i<num;i++) {
			String s = br.readLine();
			if(queue.size()>=k) {
				int removeNode = queue.poll();
				int removeLoc = tempList.indexOf(removeNode);
				tempList.remove(removeLoc);
			}//큐 초과시 제거
 
			int node = s.length();
			if(!queue.isEmpty()) {
				if(queue.contains(node)) {
					int listSize= tempList.size();
					if(tempList.get(listSize-1)==node)
						thisRight = listSize-1;
					else {
						left = 0;
						right = listSize-1;
						mid = 0;
						thisRight=0;
						while(left<=right) {
							mid = (left+right)/2;
							thisNum = tempList.get(mid);
							if(thisNum>node) {
								right = mid-1;
							}else if(thisNum<=node) {
								left = mid+1;
								thisRight = mid;
							}//if~ elseIf end
						}//while end
					}//if~else end
					
					if(tempList.get(0)==node)
						thisLeft=0;
					else {
						left = 0;
						right = thisRight;
						mid = 0;
						thisLeft = 0;
						while(left<=right) {
							mid = (left+right)/2;
							thisNum = tempList.get(mid);
							if(thisNum<node)
								left=mid+1;
							else if(thisNum>=node) {
								right=mid-1;
								thisLeft=mid;
							}//if~ else if end
						}//while end
					}//if~else end
					
					answer+= (thisRight-thisLeft+1);
				}//if end
			}//if end 
			left=0;
			right=tempList.size()-1;
			int thisIndex=0;
			while(left<=right) {
				mid = (left+right)/2;
				thisNum = tempList.get(mid);
				if(thisNum<node) {
					left=mid+1;
				}
				else if(thisNum>=node) {
					right=mid-1;
					thisIndex=mid;
				}
			}//while end
			tempList.add(thisIndex,node);
			queue.offer(node);
		}//for end
		
		System.out.println(answer);
		
		br.close();
	}//main() end
}//class end