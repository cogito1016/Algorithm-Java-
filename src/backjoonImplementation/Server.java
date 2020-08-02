package backjoonImplementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Server {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			T = T - Integer.parseInt(st.nextToken());
			if(T>=0)
				result++;
			else
				break;
		}//for end 
		
		System.out.println(result);
		
		br.close();
	}//main() end
}
