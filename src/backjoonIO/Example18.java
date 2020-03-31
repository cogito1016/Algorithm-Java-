package backjoonIO;

import java.util.Scanner;

public class Example18 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNum= scan.nextInt();
		
		for(int i=0;i<inputNum;i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}//for end
			System.out.println();
		}//for end

		
	}//main() end
}