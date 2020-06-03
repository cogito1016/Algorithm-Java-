package backjoonTwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class TurningSueshi {

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
		
		Set<Integer> eatList = new HashSet<Integer>();
		
		int max = 0;
		eatList.add(coupon);
		
		for(int i=0;i<flow;i++) {
			if(!eatList.contains(dishes[i])) {
				eatList.add(dishes[i]);
			}//if end
		}//for end 
		if(eatList.size()>max)
			max=eatList.size();
		
		for(int i=1;i<size;i++) {
			
			eatList.clear();
			eatList.add(coupon);
			
			for(int j=i;j<i+flow;j++) {
				
				int nextIndex = j ;
				
				if(nextIndex>=size) {
					nextIndex -=size;
				}//if end 
				
				if(!eatList.contains(dishes[nextIndex])) {
					eatList.add(dishes[nextIndex]);
				}//if end
			}//for end 
			
			if(eatList.size()>max)
				max=eatList.size();
		}//for end 
		
		
		System.out.println(max);
		
		br.close();
	}//main() end
}//TurningSueshi