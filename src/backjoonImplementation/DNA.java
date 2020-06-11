package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;


public class DNA {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] dna = new String[N];
		String result = "";
		int total = 0 ;
		
		//대안3번 맵으로 DNA관리
		Map<Character,Integer> map = new ConcurrentHashMap<Character, Integer>();
		
		for(int i=0;i<N;i++) {
			dna[i] = br.readLine();
		}//for end
		
		
		String s = dna[0];
		for(int a=0;a<M;a++) {
			map = new ConcurrentHashMap<Character, Integer>();
			for(int j=0;j<N;j++) {
				char thisChar = dna[j].charAt(a);
				if(map.containsKey(thisChar))
					map.put(thisChar, map.get(thisChar)+1);
				else
					map.put(thisChar, 1);
			}//for end

			Iterator it = sortByValue(map).iterator();
			Character temp = (Character) it.next();
			result+=temp;
			total+= N-map.get(temp);
			
		}//for end

		System.out.println(result);
		System.out.println(total);
		br.close();
	}//main() end
	
	public static List sortByValue(final Map map) {

		List<String> list = new ArrayList();
		list.addAll(map.keySet());
		
		Collections.sort(list,new Comparator<Object>() {
			public int compare(Object o1,Object o2) {
			Object v1 = map.get(o1);
			Object v2 = map.get(o2);
			
			if( ((Comparable) v2).compareTo(v1)==0){
				return ((Comparable) o1).compareTo(o2);
			}
				
			return ((Comparable) v2).compareTo(v1);
			}
		});
		//Collections.reverse(list); // 주석시 오름차순
		
		return list;

	}
}//class end 

