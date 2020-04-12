package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberNum {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long result=1;
		for(int i=0;i<3;i++) {
			int thisNum = Integer.parseInt(br.readLine());
			result*=thisNum;
		}//for end
		
		
		String s = result+"";
		int[] numberList = new int[10];
		
		for(int i=0;i<s.length();i++) {
			int thisNum = s.charAt(i)-'0';
			numberList[thisNum]++;
		}//for end
		
		for(int i=0;i<10;i++) {
			System.out.println(numberList[i]);
		}//for end
		
		br.close();
	}//main() end
}//class end