package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Sequence {

	public static void main(String[] args) {
		
		int[] list = {4,5,6,5,4,3};
		
		Map<Integer,Integer> map = new ConcurrentHashMap<Integer, Integer>();
		
		
		for(int i=0;i<list.length;i++) {
			
			if(map.containsKey(list[i])) {
				map.put(list[i],map.get(list[i])+1);
				continue;
			}//if end
			
			map.put(list[i],1);
		}//for end
		
		Iterator<Integer> iterator = map.keySet().iterator();
		
		List<Integer> keyList = new ArrayList<Integer>();
		
		while(iterator.hasNext()) {
			keyList.add(iterator.next());
		}//while end
		
		Collections.sort(keyList,new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(map.get(o1)>map.get(o2)) {
					return 1;
				}else if(map.get(o1)==map.get(o2) && o1>o2) {
					return 1;
				}//if~else If end
				return -1;
			};
		});
		
		for(int item : keyList) {
			for(int i=0;i<map.get(item);i++) {
				System.out.print(item+" ");
			}//for end
			
		}//for end
		
		
		
	}//main() end
}
