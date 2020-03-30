package backjoonIO;

import java.util.Scanner;

public class Example10 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int numSize = scan.nextInt();
		long number = scan.nextLong();
		int result = 0;
		
		for(int i=numSize-1; i>=0; i--) {
			long gettedNum = (number/(long)Math.pow(10, i));
			result += gettedNum;
			number -= gettedNum*(long)Math.pow(10, i);
		}//for end
		
		System.out.println(result);
		

	}//main() end
}