package backjoonSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PaperSearch {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String goal = br.readLine();
		
		int max = 0;
		for(int i=0;i<str.length();i++) {
			int result = 0;
			int idx = 0;
			for(int j=i;j<str.length();j++) {
				
				if(str.charAt(j)==goal.charAt(idx)){
					idx++;
				}else {
					idx=0;
				}//if~else end 
				
				if(idx==goal.length()) {
					result ++;
					idx=0;
				}//if end
			}//for end
			
			if(result>max)
				max=result; 
			
		}//for end
		
		System.out.println(max);
	
		
		br.close();
	}//main() end
}
