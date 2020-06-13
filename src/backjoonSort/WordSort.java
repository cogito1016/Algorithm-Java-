package backjoonSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class WordSort {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] wordList = new String[N];
		
		for(int i=0;i<N;i++) {
			wordList[i] = br.readLine();
		}//for end 옇어
		
		Arrays.sort(wordList,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()>o2.length()) {
					return 1;
				}else if(o1.length()==o2.length()) {
					for(int i=0;i<o1.length();i++) {
						if(o1.charAt(i)>o2.charAt(i)){
							return 1;
						}//if end
						else if(o1.charAt(i)<o2.charAt(i)) {
							return -1;
						}
					}//for end
					return -1;
				}//if~elseIf end 
				return -1;
			};//compare end
		});//sort end
		
		String tempStr = null;
		for(String s :wordList) {
			if(s.equals(tempStr))
				continue;
			System.out.println(s);
			tempStr=s;
		}//for end 
		
		
		br.close();
		
		
	}//main() end
}//class end