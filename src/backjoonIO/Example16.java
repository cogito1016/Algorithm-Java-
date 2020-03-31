package backjoonIO;

import java.util.Scanner;

public class Example16 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		int min=1000000, max =-1000000;
		
		int[] list = new int[inputNum];
		
		for(int i=0;i<inputNum;i++) {
			list[i]=scan.nextInt();

			if(min>list[i])
				min=list[i];
			if(max<list[i])
				max=list[i];
			
		}//for end
		
		System.out.println(min+" "+max);
		
		

	}//main() end
}