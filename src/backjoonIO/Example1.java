package backjoonIO;

import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자 두개를 입력해주세요!!( ex. 2 3 ) 첫번째수는 0보다 커야하고 두번째수는 10보다 작아야함");
		int a = scan.nextInt();
		int b = scan.nextInt();
		if(0<a&&b<10) 
			System.out.println("두 수의 결과는"+(a+b)+"입니다!");
		else 
			System.out.println("조건에 안맞는데요.");
		
	}
}
