package backjoonImplementation;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		
		
		Scanner scan= new Scanner(System.in);
		int inputNum = scan.nextInt();
		long result = 1 ;
		if(inputNum==0) {
			result=0;
		}
		
		for(int i=inputNum; i>0;i--) {
			result*=i;
		}//for end
		
		System.out.println(result);
	}//main end

}//class end 
