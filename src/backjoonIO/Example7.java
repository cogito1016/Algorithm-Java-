package backjoonIO;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Example7 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int caseNum = scan.nextInt();
		
		List<int[]> resultSet = new ArrayList<int[]>();
		
		while(caseNum>0) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = a+b;
			resultSet.add(new int[] {a,b,c} );
			caseNum--;
		}//while end
		
		for(int i=0; i<resultSet.size();i++) {
			System.out.println("Case #"+(i+1)+": "+resultSet.get(i)[0]+" + "+resultSet.get(i)[1]+" = "+resultSet.get(i)[2]);
		}//for end
		
		
	}//main() end
}//Example4 end
