package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//DynamicProgramming + Zero:One Count + Fivonacci 
public class Fibonacci {
	
	static int[] dp = new int[41];
	static Node[] oz = new Node[41];
	
	
	static class Node{
		int one,zero;
		Node(int one,int zero){
			this.one=one;
			this.zero=zero;
		}
	}
	
	static int fibo(int n){
		if(n==0) {
			return 0;}
		if(n==1) {
			return 1;}
		
		int a = dp[n-1]==0? dp[n-1]=fibo(n-1) : dp[n-1] ;
		int b = dp[n-2]==0? dp[n-2]=fibo(n-2) : dp[n-2] ;
		
		
		dp[n] = a+b;
		oz[n] = new Node(oz[n-2].one+oz[n-1].one,oz[n-2].zero+oz[n-1].zero);
		return dp[n];
	}//fibo() end

	public static void main(String[] args) throws IOException {

		oz[0] = new Node(0, 1);
		oz[1] = new Node(1, 0);
		dp[0]=0;
		dp[1]=1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n;
		for(int i=0;i<T;i++) {
			n = Integer.parseInt(br.readLine());
			fibo(n);
//			System.out.println(countZero+" "+countOne+" "+fibo(n));
			System.out.println(oz[n].zero+" "+oz[n].one);
		}//for end 
		br.close();
	}//main() end
}//Fibo class end