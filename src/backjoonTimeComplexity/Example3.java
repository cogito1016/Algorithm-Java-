package backjoonTimeComplexity;

import java.util.Scanner;

public class Example3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		
		int[] abilityList = new int[inputNum];
		
		for(int i=0;i<inputNum;i++) {
			abilityList[i]= scan.nextInt();

			int thisScore=i+1;
			if(i!=0){
				for(int j=i-1;j>=0;j--) {
					if(abilityList[i]>abilityList[j])
						thisScore--;
				}//for end
			}//if end
			System.out.println(thisScore);
		}//for end
	}//main() end
}//class end
