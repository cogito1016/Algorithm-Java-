package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Antatica {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		
		//가르칠 스펠링 후보이다.
		//중복이필요없으므로 Set이 적당할것같다.
		Set<Character> set = new HashSet<Character>();
		
		//a,n,t,i,c는 공통이므로 제외한다.
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			s = s.replaceAll("a","");
			s = s.replaceAll("n","");
			s = s.replaceAll("t","");
			s = s.replaceAll("i","");
			s = s.replaceAll("c","");
			for(int j=0;j<s.length();j++) {
				set.add(s.charAt(j));
			}//for end
		}//for end
		
		//antatica 는 공통
		//따라서 antic(5개)은 무조건 가르쳐야할 스펠링이다.
		//K<5면 fail
		if(K<5) {
			System.out.println(0);
			return ;
		}//if end
		K-=5;//이제 K는 a,n,t,i,c를 제외하고 가르칠 수 있는 스펠링 수
		
		
		
		br.close();
	}//main() end
}//class end