package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanSoo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int count=0;
		int first,second;
		int prevGap=0;
		
		for(int i=1;i<=num;i++) {
			String s = i+"";
			int numLength = s.length();
			
			if(numLength==1||numLength==2)
				count++;
			else {
				for(int j=0;j<numLength-1;j++) {
					first = s.charAt(j)-'0';
					second = s.charAt(j+1)-'0';
					int gap = second-first;
					if((j!=0)&&(gap==prevGap))
						count++;
					else if((j!=0)&&(gap!=prevGap))
						break;
					prevGap=gap;
				}//for end
			}//if~else end
		}//for end
		
		System.out.println(count);
		br.close(); 
	}//main() end
}//class end