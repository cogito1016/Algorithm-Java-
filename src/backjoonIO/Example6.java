package backjoonIO;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Example6 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int caseNum = scan.nextInt();
		
		List<Integer> resultSet = new ArrayList<>();

		while(caseNum>0) {
			
			int a = scan.nextInt();
			int b = scan.nextInt();
			resultSet.add(a+b);
			caseNum--;
		}//while end
		
		for(int i=0; i<resultSet.size();i++) {
			System.out.println("Case #"+(i+1)+": "+resultSet.get(i));
		}//for end
		
	}//main() end
}//Example4 end
