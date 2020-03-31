package backjoonIO;

import java.util.Scanner;

public class Example21 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNum= scan.nextInt();
		
		int totalStar = (inputNum*2)-1;
		
		for(int i=1;i<=inputNum;i++) {
			
			int starNum = (i*2)-1;
			int blankNum = (totalStar-starNum)/2;
			
			for(int j=0;j<blankNum;j++) {
				System.out.print(" ");}
			for(int j=0;j<starNum;j++) {
				System.out.print("*");}
			
			System.out.println();
		}//for end
		
	}//main() end
}