package backjoonSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BestSeller {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		int max =  1;
		
		String title=null;
		
		for(int i=0;i<N;i++) {
			int value = 0;
			String s = br.readLine();
			if(!map.containsKey(s)) {
				map.put(s,1);
				value = 1;
			}else {
				value = map.get(s)+1;
				map.put(s,value);
			}//if~else end
			
			if(value==max) {
				if(title==null)
					title=s;
				else {
					int result = title.compareTo(s);
					if(result>0)
						title=s;
				}//if~else end 
			}//if end
			
			if(value>max) {
				max=value;
				title = s;
			}
			
		}//for end
		
		System.out.println(title);
		
		br.close();
	}//main() end
}
