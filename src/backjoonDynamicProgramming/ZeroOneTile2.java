package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroOneTile2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int a=1,b=3,c=0;
		
		if(n==1) {
			System.out.println(a);
			return;
		}else if(n==2) {
			System.out.println(b);
			return;
		}//if~elseIf end
		
		for(int i=3;i<=n;i++) {
			c = (a*2+b)%10007;
			a = b;
			b = c;
		}//for end
		
		System.out.println(c);
		
		br.close();
	}//main() end
}//class end