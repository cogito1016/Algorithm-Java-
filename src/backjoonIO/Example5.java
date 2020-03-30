package backjoonIO;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Example5 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		List<Integer> resultSet = new ArrayList<>();

		int a = scan.nextInt();
		int b = scan.nextInt();
		
		while(a!=0&&b!=0) {
			resultSet.add(a+b);
			a = scan.nextInt();
			b = scan.nextInt();
		}//while end;
		
		for(int result : resultSet) {
			System.out.println(result);
		}//for end
		
	}//main() end
}//Example4 end
