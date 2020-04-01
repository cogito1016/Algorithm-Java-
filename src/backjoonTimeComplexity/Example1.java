package backjoonTimeComplexity;

import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int arrayNum = scan.nextInt();
		int goalNum = scan.nextInt();
		scan.nextLine();
		String numList = scan.nextLine();
		
		int[] intList = new int[arrayNum];
		String[] numListParsed = numList.split(" ");

		for(int i=0;i<arrayNum;i++) {
			intList[i] = Integer.parseInt(numListParsed[i]);
		}//for end
		
		int result=0;
		int numCase=0;
		
		for(int j=0; j<arrayNum;j++) {
		
			for(int k=j;k<arrayNum; k++) {
				result+=intList[k];
				
				if(result>goalNum) {
					result=0;
					break;
				}else if(result==goalNum) {
					numCase++;
					break;
				}//if~else end
			}//for end
			result =0;
		}//for end
		
		System.out.println(numCase);
		
	}//main() end
}//class end
