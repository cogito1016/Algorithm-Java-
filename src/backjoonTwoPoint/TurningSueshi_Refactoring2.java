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

public class TurningSueshi_Refactoring2 {

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
		int[] visit = new int[kinds+1];
		
		int cnt = 0;
		for(int i=0;i<flow;i++) {
			visit[dishes[i]]++;
			if(visit[dishes[i]]==1)
				cnt++;
		}//for end
		
		for(int i=0;i<size;i++){
			if(visit[coupon]==0) {
				max = max>cnt+1? max:cnt+1 ;
			}else {
				max = max>cnt? max:cnt;
			}//if~else end
			
			visit[dishes[i]]--;
			if(visit[dishes[i]]==0) cnt--;
			
			int nextIndex = (flow+i)%size;
			visit[dishes[nextIndex]]++;
			if(visit[dishes[nextIndex]]==1) cnt++;
		}//for end
		
		System.out.println(max);
		
		br.close();
	}//main() end
}//TurningSueshi