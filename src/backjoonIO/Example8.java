package backjoonIO;


import java.util.Scanner;

public class Example8 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String inpStr ;
		int max=100;
		boolean condition=true;
		
		while(scan.hasNext()&&max>0) {
			inpStr=scan.nextLine();
			
			if(inpStr.charAt(0)==32||inpStr.charAt(inpStr.length()-1)==32) {
				break;
			}//if end
			
			for(int i=0;i<inpStr.length();i++) {
				char ch = inpStr.charAt(i);
				if( (ch>64 && ch<91 ) || (ch>96 && ch<123 ) ||
						(ch>47 && ch<58 )|| (ch==32)){
				}else {
					condition=false;
					break;
				}//if~else end
			}
			

			if(condition==true) {
				System.out.println(inpStr);
			}else {
				break;
			}
			max--;
		}//while end
	}//main() end
}