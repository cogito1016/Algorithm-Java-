package programmersLvCheck;

import java.util.ArrayList;
import java.util.List;

public class Lv2_NewsClustering {
	public static void main(String[] args) {
		
		String str1="aa1+aa2";
		String str2="AAAA12";
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		List<String> multiSet1 = new ArrayList<String>();
		List<String> multiSet2 = new ArrayList<String>();
		
		for(int i=0;i<str1.length()-1;i++) {
			char str1First=str1.charAt(i);
			char str1Second=str1.charAt(i+1);
			if(('A'<=str1First&& str1First<='Z')
					&&'A'<=str1Second&& str1Second<='Z') {
				multiSet1.add(str1First+""+str1Second+"");
			}//if end
		}//for end
		
		for(int i=0;i<str2.length()-1;i++) {
			char str2First=str2.charAt(i);
			char str2Second=str2.charAt(i+1);
			if(('A'<=str2First&& str2First<='Z')
					&&'A'<=str2Second&& str2Second<='Z') {
				multiSet2.add(str2First+""+str2Second+"");
			}//if end
		}//for end
		
		int n=0;
		int u=0;
		
		boolean[] visited1 = new boolean[multiSet1.size()];
		boolean[] visited2 = new boolean[multiSet2.size()];
		
		for(int i=0;i<multiSet1.size();i++) {
			String s1 = multiSet1.get(i);
			boolean equalsFlag = false; 
			for(int j=0;j<multiSet2.size();j++) {
				String s2 = multiSet2.get(j);
				if(visited2[j])
					continue;
				
				if(s1.equals(s2)) {
					equalsFlag=true;
					visited2[j]=true;
					break;
				}
			}//for end
			
			if(equalsFlag) {
				visited1[i]=true;
				n++;
			}//if end
		}//for end
		
		double jacad = 0.0;
		
		if(multiSet1.size()==multiSet2.size() &&
				multiSet1.size()==n) {
			jacad=1;
		}else {
			u= multiSet1.size()+multiSet2.size()-n;
			jacad = (double)n/(double)u;
		}
		
		System.out.println((int)Math.floor(jacad*65536));
	}
}
