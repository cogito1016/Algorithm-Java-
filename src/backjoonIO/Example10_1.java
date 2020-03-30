package backjoonIO;

import java.util.Scanner;

public class Example10_1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int numSize = scan.nextInt();
		String number = scan.next();
		int result = 0;
		
		for(int i=0; i<numSize; i++) {
			result += Character.getNumericValue(number.charAt(i));
		}//for end
		System.out.println(result);
		

	}//main() end
}