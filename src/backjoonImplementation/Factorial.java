package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int inputNum =  Integer.parseInt(br.readLine());
		
		long result = 1;
		
		for(int i=1;i<=inputNum;i++) {
			result*=i;
		}//for end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end
