package backjoonQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class GoodFriendHashMapVer {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken())+1;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Map<Integer,Integer> board = new ConcurrentHashMap<Integer,Integer>() ;
		long answer = 0;
		
		for(int i=0;i<num;i++) {
			String s = br.readLine();
			if(queue.size()>=k) {
				int removeNode = queue.poll();
				int thisVal = board.get(removeNode);
				if(thisVal == 1)
					board.remove(removeNode);
				else
					board.replace(removeNode, thisVal-1);
			}//큐 초과시 큐와 맵에서 노드 제거(맵의 노드의 벨류가 1일시 제거 아님 기존벨류-1)
 
			int node = s.length();
			
			
			//큐와 맵에 노드 추가(맵에 노드있을시 기존값에 +1)
			queue.offer(node);
			if(board.containsKey(node)) {
				answer+= board.get(node);
				board.replace(node, board.get(node)+1);
			}
			else
				board.put(node, 1);
		}//for end
		
		System.out.println(answer);
		
		br.close();
	}//main() end
}//class end