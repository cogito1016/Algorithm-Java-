package backjoonHasing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class FindNumber {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<Integer>();
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}//for end 
		
		int M = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			if(set.add(Integer.parseInt(st.nextToken())))
				bw.write('0');
			else
				bw.write('1');
			bw.newLine();
		}//for end
		
		br.close();
		bw.close();
	}//main() end
}
