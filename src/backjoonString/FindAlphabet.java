package backjoonString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindAlphabet {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int[] loc = new int[26];
		Arrays.fill(loc, -1);
		
		for(int i=0;i<s.length();i++) {
			int c = s.charAt(i)-97;
			loc[c] = loc[c]==-1 ? i : loc[c];
		}//for end
		
		for(int i=0;i<26;i++) {
			System.out.print(loc[i]+" ");
		}//for end
		
		br.close();
	}//main() end
}
