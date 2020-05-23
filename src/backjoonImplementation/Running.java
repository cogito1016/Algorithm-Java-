package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Running {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] abilies = new int[num];
		
		for(int i=0;i<num;i++) {
			abilies[i] = Integer.parseInt(br.readLine());
			
		}//for end
		
		
		
		br.close();
	}//main() end
	
}//class end
