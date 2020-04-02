package backjoonImplementation;

import java.util.Scanner;

public class UnderX {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int listNum=scan.nextInt();
		int baseNum=scan.nextInt();
		
		int[] list = new int[listNum];
		
		for(int i=0;i<listNum;i++) {
			list[i]=scan.nextInt();
		}//for end
		
		for(int i=0;i<listNum;i++) {	
			if(list[i]<baseNum) {
				System.out.print(list[i]);
				if(i!=listNum-1)
					System.out.print(" ");
			}//if end
		}//for end
		
		
	}//main end
}//class end
