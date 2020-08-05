package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class NumCard2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int thisNum = Integer.parseInt(st.nextToken());
			if(map.containsKey(thisNum)) {
				map.put(thisNum,map.get(thisNum)+1);
			}else {
				map.put(thisNum,1);
			}//if~else end
		}//for end 
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int thisNum = Integer.parseInt(st.nextToken());
			if(map.containsKey(thisNum)) {
				bw.write(map.get(thisNum)+" ");
			}else {
				bw.write("0 ");
			}//if~else end
		}//for end
		
		br.close();
		bw.close();
	}//main() end
}
