package backjoonTwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class TurningSueshi_Refactoring {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int kinds = Integer.parseInt(st.nextToken());
		int flow = Integer.parseInt(st.nextToken());
		int coupon = Integer.parseInt(st.nextToken());
		
		int[] dishes = new int[size];
		
		for(int i=0;i<size;i++) {
			dishes[i]=Integer.parseInt(br.readLine());
		}//for end 
		

		int max = 0;
		boolean[] visit;
		
		
		for(int i=0;i<size;i++) {
			
			int cnt = 0; 
			visit = new boolean[kinds+1];
			
			for(int j=i;j<i+flow;j++) {
				
				int nextIndex = j ;
				
				if(nextIndex>=size) {
					nextIndex -=size;
				}//if end 
				
				if(!visit[dishes[nextIndex]]) {
					visit[dishes[nextIndex]]=true;
					cnt++;
				}//if end
				
			}//for end 
			
			if(!visit[coupon])
				cnt++;
			
			if(cnt>max)
				max=cnt;
		}//for end 
		
		
		System.out.println(max);
		
		br.close();
	}//main() end
}//TurningSueshi