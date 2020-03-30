package backjoonIO;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Example3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int caseNum = scan.nextInt();
		
		List<Integer> resultSet = new ArrayList<Integer>();
		
		while(caseNum>0) {
			int a = scan.nextInt();
			int b= scan.nextInt();
			resultSet.add(a+b);
			caseNum--;
		}
		
		for(int result : resultSet) {
			System.out.println(result);
		}
		
	}
}
