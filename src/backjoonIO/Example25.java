package backjoonIO;

import java.util.Scanner;

public class Example25 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		
		for(int i=0; i<inputNum; i++) {
			
			for(int j=0;j<inputNum-i-1;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i+1;j++) {
				System.out.print("*");
				if(j!=i) {
					System.out.print(" ");
				}
			}
			System.out.println();
			
		}//for end
		
	}//main() end
}
