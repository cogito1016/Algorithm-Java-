package backjoonIO;

import java.util.Scanner;

public class Example26 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		int totalStarNum = inputNum*2-1;
		
		for(int i=0; i<inputNum;i++) {
			
			for(int j=0;j<inputNum-i-1;j++) {
				System.out.print(" ");
			}//for end
			
			if(i==0) {
				System.out.print("*");
			}else if(i!=inputNum-1) {
				System.out.print("*");
				for(int k=0;k<(i*2)-1;k++) {
					System.out.print(" ");
				}//for end
				System.out.print("*");
			}else {
				for(int l=0;l<totalStarNum;l++) {
					System.out.print("*");
				}//for end
			}//if~else end
			System.out.println();
		}//for end
		
		
	}//main() end
}
