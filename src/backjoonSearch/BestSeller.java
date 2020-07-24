package backjoonSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BestSeller {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		int max =  1;
		
		
		for(int i=0;i<N;i++) {
			
			String s = br.readLine();
			if(!map.containsKey(s)) {
				map.put(s,1);
				continue;
			}//if end
			
			int value = map.get(s)+1;
			map.put(s,value);
			
			if(value>max) {
				max=value;
			}//if end
		}//for end
		
		List<String> titles = new ArrayList<String>();
		
		Iterator iterator  = map.keySet().iterator();
		while(iterator.hasNext()) {
			String title = iterator.next().toString();
			if(map.get(title)==max) {
				titles.add(title);
			}//if end
		}//while end
		
		Collections.sort(titles);
		
		System.out.println(titles.get(0));
		
		br.close();
	}//main() end
}
