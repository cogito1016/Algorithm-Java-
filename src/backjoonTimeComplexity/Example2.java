package backjoonTimeComplexity;

import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		int totalSize = inputNum+1;
		long[] fibonacciList = new long[totalSize];
		
		
		for( int i=0; i<totalSize; i++) {
			if(i<2){
				fibonacciList[i]=i;
			}else {
				fibonacciList[i]=fibonacciList[i-2]+fibonacciList[i-1];
			}//if~elses end
		}//for end
		System.out.println(fibonacciList[fibonacciList.length-1]);
	}//main() end
}//class end
