package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroOneTile_Refactoring {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int a=1,b=1,c=0;

		for(int i=1;i<N;i++) {
			c = (a+b)%15746;
			a = b;
			b = c;
		}//for end
		 
		System.out.println(b);
		
		br.close();
	}//main() end
}//class end