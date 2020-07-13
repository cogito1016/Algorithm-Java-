package backjoonImplementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BonusPoint {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int bonus = 0;
		int sum = 0;
		for(int i=0;i<N;i++) {
			char c = S.charAt(i);
			int point = i+1;
			
			if(c=='O') {
				sum+=point;
				sum+=bonus++;
			}else {
				bonus=0;
			}//if~else end
		}//for end 
		System.out.println(sum);
		
		br.close();
		
	}//main() end
}
