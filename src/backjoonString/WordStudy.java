package backjoonString;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class WordStudy {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.toUpperCase();
		
		int[] list = new int[26];
		int max = 0;
		
		for(int i=0;i<s.length();i++) {
			int cIdx = s.charAt(i)-65;
			list[cIdx] = list[cIdx]==0 ? 1 : list[cIdx]+1;
			if(max<list[cIdx])
				max=list[cIdx];
		}//for end
		
		int count = 0 ;
		int maxIdx = 0 ;
		for(int i=0;i<26;i++) {
			if(max==list[i]) {
				count++;
				maxIdx=i;
			}//if end 
		}//for end
		
		if(count!=1)
			System.out.println("?");
		else
			System.out.println((char)(maxIdx+65));
		br.close();
	}//main() end
}
