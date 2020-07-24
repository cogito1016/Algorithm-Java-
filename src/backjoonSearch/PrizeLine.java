package backjoonSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrizeLine {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] prizes = new int[N];
		
		for(int i=0;i<N;i++) {
			prizes[i] = Integer.parseInt(br.readLine());
		}//for end
		
		int base = prizes[0];
		int count = 1;
		for(int i=1;i<N;i++) {
			if(prizes[i]>base) {
				base=prizes[i];
				count++;
			}//if end
		}//for end
		System.out.println(count);
		
		base = prizes[N-1];
		count = 1 ;
		for(int i=N-2;i>=0;i--) {
			if(prizes[i]>base) {
				base=prizes[i];
				count++;
			}//if end
		}//for end
		System.out.println(count);
		br.close();
	}//main() end
}
