package backjoonIO;

import java.util.Scanner;

public class Example15 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int inputNum = scan.nextInt();
		int result = 0;
		for(int i=1;i<=inputNum;i++) 
			result +=i;
		System.out.println(result);
	}//main() end
}