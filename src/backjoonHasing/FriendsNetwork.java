package backjoonHasing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class FriendsNetwork {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		while(T-- >0) {
			int N = Integer.parseInt(br.readLine());
			
			Map<String, Integer> relationMap = new ConcurrentHashMap<String, Integer>(); //Key=이름 Value=관계도
			int[] networkValueArray = new int[N]; //관계도=Index 관계수=Value
			
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String firstKey = st.nextToken();
				String secondKey = st.nextToken();
				
				
				int result = 0;
				int firstIdx,secondIdx;
				
				if(relationMap.containsKey(firstKey) && relationMap.containsKey(secondKey)) {
					
					firstIdx = relationMap.get(firstKey);
					secondIdx = relationMap.get(secondKey);
					result = networkValueArray[firstIdx]+networkValueArray[secondIdx];
					networkValueArray[firstIdx] = result;
					networkValueArray[secondIdx] = result; 
					
				}else if(relationMap.containsKey(secondKey)) {
					
					secondIdx = relationMap.get(secondKey);
					relationMap.put(firstKey,secondIdx);
					result = networkValueArray[secondIdx]+1;
					networkValueArray[secondIdx] = result; 
					
				}else if(relationMap.containsKey(firstKey)) {
					
					firstIdx = relationMap.get(firstKey);
					relationMap.put(secondKey,firstIdx);
					result = networkValueArray[firstIdx]+1;
					networkValueArray[firstIdx] = result;
					
				}else {
					
					result = 2;
					relationMap.put(firstKey,i);
					relationMap.put(secondKey,i);
					networkValueArray[i]=result;
					
				}
				
				bw.write(result+"\n");
			}//for end
			bw.flush();
		}//while end
		
		
		bw.close();
		br.close();
	}//main() end
}
