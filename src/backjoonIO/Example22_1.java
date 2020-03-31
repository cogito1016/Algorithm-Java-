package backjoonIO;

import java.util.Scanner;

public class Example22_1 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNum= scan.nextInt();
		int totalStar = inputNum*2;
		int blankNum;
		for(int i=0;i<totalStar;i++) {
			
			if(i<inputNum) {
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}//for end
				blankNum=(inputNum-i-1)*2;
				for(int j=blankNum;j>0;j--) {
					System.out.print(" ");
				}//for end
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}//for end
			}else {
				for(int j=totalStar-i-1;j>0;j--) {
					System.out.print("*");
				}
				blankNum = (i-inputNum+1)*2;
				for(int j=0;j<blankNum;j++) {
					System.out.print(" ");
				}

				for(int j=totalStar-i-1;j>0;j--) {
					System.out.print("*");
				}
			}

			System.out.println();
		}//for end
		
		
	}//main() end
}