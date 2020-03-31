package backjoonIO;

import java.util.Scanner;

public class Example23 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		int height = inputNum*2-1;
		int blankNum;
		
		for(int i=0;i<height;i++) {
			
		
			if(i<inputNum) {
				blankNum = inputNum-i-1;
			}else {
				blankNum=i-inputNum+1;
			}//if~else end

			for(int j=0;j<blankNum;j++) {
				System.out.print(" ");
			}//for end
			for(int j=0;j<inputNum-blankNum;j++) {
				System.out.print("*");
			}//for end
			System.out.println();
		}//for end
		
	}//main() end
}