package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuteGuy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int man = Integer.parseInt(br.readLine());
		int result=0;
		for(int i=0;i<man;i++) {
			int input =Integer.parseInt(br.readLine());
			if(input==0)
				input=-1;
			result += input;
		}//for end
		if(result>0)
			System.out.println("Junhee is cute!");
		else
			System.out.println("Junhee is not cute!");
			
		
		br.close();
	}//main() end
}//class end