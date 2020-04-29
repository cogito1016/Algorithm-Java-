package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BillPlease {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		
		for(int i=0;i<9;i++) {
			total -= Integer.parseInt(br.readLine());
		}//for end
		
		System.out.println(total);
		
		br.close();
	}//main() end
}//class end