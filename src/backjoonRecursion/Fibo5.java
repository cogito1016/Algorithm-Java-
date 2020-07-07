package backjoonRecursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibo5 {
	
	public static int fibo(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fibo(n-2)+fibo(n-1);
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		
		System.out.println(fibo(n));
		
		br.close();
		 
	}//main() end
}
