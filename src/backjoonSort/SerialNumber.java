package backjoonSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class SerialNumber {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] list = new String[N];
		
		for(int i=0;i<N;i++) {
			list[i] = br.readLine();
		}//for end 
		
		Arrays.sort(list,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				if(o1.length()>o2.length())
					return 1;
				else if(o1.length()==o2.length()) {
					
					int size = o1.length();
					int tempOne = 0;
					int tempTwo = 0;
					boolean firstFlag = false;
					boolean firstSide = false;
					for(int i=0;i<size;i++) {
						int one = o1.charAt(i);
						int two = o2.charAt(i);
						if(one<='9'&&one>='0') {
							tempOne+= one-'0';
						}
						if(two<='9'&&two>='0') {
							tempTwo+= two-'0';
						}
						if(!firstFlag) {
							if(one>two) {
								firstSide = true;
								firstFlag = true;
							}else if(one<two) {
								firstSide = false;
								firstFlag = true;
							}
						}//if end
					}
					if(tempOne>tempTwo)
						return 1;
					else if(tempOne==tempTwo) {
						if(firstSide)
							return 1;
						else
							return -1;
					}//if~else If end
				}//if~else If end
				return -1;
			}//compare end
		});//sort end
		
		
		for(String item : list) {
			System.out.println(item);
		}//for end
		
		br.close();
	}//main() end
}//class end