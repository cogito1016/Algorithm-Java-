package backjoonBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class WeightCut_BFS_BinarySearch {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		int[][] islands = new int[N+1][N+1];
		List<ConcurrentHashMap<Integer, Integer>> islands = new ArrayList<ConcurrentHashMap<Integer,Integer>>();
		int min=1000000000,max=0;
		
		for(int i=0;i<=N;i++) {
			islands.add(new ConcurrentHashMap<Integer, Integer>());
		}//for end 
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(islands.get(first).containsKey(second) || islands.get(second).containsKey(first)) {
				if(islands.get(first).get(second)>weight) {
					islands.get(first).put(second,weight);
					islands.get(second).put(first, weight);
				}		
			}else {
				islands.get(first).put(second,weight);
				islands.get(second).put(first,weight);
			}//if~else end
			
			if(weight<min)
				min=weight;
			
			if(weight>max)
				max=weight;
			
		}//for end 
		
		st = new StringTokenizer(br.readLine());
		int goalY = Integer.parseInt(st.nextToken());
		int goalX = Integer.parseInt(st.nextToken());
		
		int mid;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visit = new boolean[N+1];
		boolean possible = false;
		Iterator<Integer> iterator;
		int result = 0;
		while(min<=max) {
			mid=(min+max)/2;
			queue = new LinkedList<Integer>();
			Arrays.fill(visit,false);
			visit[goalY]=true;
			possible=false;
			
			iterator = islands.get(goalY).keySet().iterator();
			
			while(iterator.hasNext()) {
				int thisIdx = iterator.next();
				if(islands.get(goalY).get(thisIdx)>=min) {
					if(thisIdx==goalX) {
						possible=true;
						break;
					}//if end 
					queue.offer(thisIdx);
//					visit[thisIdx]=true;
				}
			}//while end 
			
			while(!queue.isEmpty()) {
				if(possible)
					break;
				int thisIsland = queue.poll();
				iterator = islands.get(thisIsland).keySet().iterator();
				while(iterator.hasNext()) {
					int thisIdx = iterator.next();
					if(visit[thisIdx])
						continue;
					
					if(islands.get(thisIsland).get(thisIdx)>=mid) {
						if(thisIdx==goalX) {
							possible=true;
							break;
						}//if end
						queue.offer(thisIdx);
						visit[thisIdx]=true;
					}//if end
				}//for end 
				if(possible)
					break;
			}//while end 
			
			if(possible) {
				result=min;
				min=mid+1;
			}else {
				max=mid-1;
			}
		}//while end 
		
		System.out.println(result);
		
		br.close();
	}//main() end
}
