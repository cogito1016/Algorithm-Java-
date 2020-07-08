package backjoonString;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dial {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int[] dial = {0,0,3,4,5,6,7,8,9,10};
		int[] dialIndexOfStr = 
					{2,2,2,3,3,3,4,4,4
					,5,5,5,6,6,6,7,7,7,7
					,8,8,8,9,9,9,9};
		
		int sum = 0;
	
		for(int i=0;i<s.length();i++) {
			int num = s.charAt(i)-'A';
			int dialIdx = dialIndexOfStr[num];
			int dialVal = dial[dialIdx];
			
			sum+=dialVal;
		}//for end
		System.out.println(sum);
		
		br.close();
	}//main() end
}
