package backjoonIO;

import java.util.Scanner;

public class Example24 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		int height = inputNum*2-1;
		int blankNum;
		for(int i=0;i<height;i++) {
			
			if(i<inputNum) {
				blankNum =i;
			}else {
				blankNum=height-i-1;
			}//if~else end

			for(int j=0;j<blankNum;j++){
				System.out.print(" ");
			}//for end
			for(int j=0;j<height-blankNum*2;j++) {
				System.out.print("*");
			}//for end
			System.out.println();
		}//for end
		
		
	}//main() end
}
