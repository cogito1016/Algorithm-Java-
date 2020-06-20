package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SangeunNald {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int burger = 2000;
		int juice = 2000;
		int money = 0 ;
		for(int i=0;i<5;i++) {
			money = Integer.parseInt(br.readLine());
			if(i<3 & burger>money) {
				burger=money;
			}else if(i>=3 & juice>money){
				juice=money;
			}//if~elseIf end
		}//for end
		
		System.out.println(burger+juice-50);
		br.close();
	}//main() end 
}//class end
