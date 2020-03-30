package backjoonIO;

import java.util.Scanner;

public class Example11 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String wordString = scan.next();
		
		while(true) {
			if(wordString.length()>=10) {
				String str = wordString.substring(0,10);
				wordString = wordString.substring(10);
				System.out.println(str);
			}else {
				System.out.println(wordString);
				break;
			}//if~else end
		}//while end
	}//main() end
}