package backjoonSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TheBird {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 1;
		int second = 0;
		
		while(N!=0){
			if(N-count>=0) {
				N = N-count;
				count ++;
				second++;
			}else {
				count = 1;
			}//if~else end
		}//while() end
		
		System.out.println(second);
		
		br.close();
	}//main() end
}
