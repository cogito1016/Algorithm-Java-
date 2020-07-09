package backjoonImplementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubinPermutation {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int bSum = 0;
		int result = 0;
		
		for(int i=1;i<=N;i++) {
			int thisNum = Integer.parseInt(st.nextToken());
			
			result = thisNum*i - bSum;
			bSum+=result;
			
			System.out.print(result+" ");
			
		}//for end 
		
		br.close();
	}//main() end
}
