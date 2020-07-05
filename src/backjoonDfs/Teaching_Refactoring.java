package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;


public class Teaching_Refactoring {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//가르칠 스펠링 후보이다.
		//중복이필요없으므로 Set이 적당할것같다.
		Set<Character> set = new HashSet<Character>();
		Map<String,Integer> targetWord = new ConcurrentHashMap<String, Integer>(); 
		

		Set<Character> neededCheckSpeling = new HashSet<Character>();
		//a,n,t,i,c는 공통이므로 제외한다.
		for(int i=0;i<N;i++) {
			String s = br.readLine();

			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				if(c=='a'||c=='n'||c=='t'||c=='i'||c=='c') {
					continue;
				}//if end

				neededCheckSpeling.add(c);
				set.add(c);
			}//for end

			StringBuilder sb = new StringBuilder();
			Iterator<Character> iterator = neededCheckSpeling.iterator();
			
			while(iterator.hasNext()) {
				sb.append(iterator.next());
			}//while end
			
			if(targetWord.get(sb.toString())==null) {
				targetWord.put(sb.toString(),1);	
			}else {
				targetWord.put(sb.toString(),targetWord.get(sb.toString())+1);
			}//if~else end
			
			neededCheckSpeling.clear();
		}//for end
		
		//antatica 는 공통
		//따라서 antic(5개)은 무조건 가르쳐야할 스펠링이다.
		//K<5면 fail
		if(K<5) {
			System.out.println(0);
			return ;
		}//if end

		K-=5;//이제 K는 a,n,t,i,c를 제외하고 가르칠 수 있는 스펠링 수
		//그리고 set은 가르칠수 있는 스펠링의 종류
		
		if(K>=set.size()) {
			System.out.println(N);
			return ;
		}//if end
		
		
		Character[] targetSpeling = new Character[set.size()];
		Iterator<Character> iterator = set.iterator();
		int targetIdx=0;
		while(iterator.hasNext()) {
			targetSpeling[targetIdx++] = iterator.next();
		}//while end
		
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(-1);
		int count = 1 ;
		int max = 0 ;

		Set<String> keySet = targetWord.keySet();
		//조합을 사용하여 판단
		while(!stack.isEmpty()) {
			
			int thisNum = stack.pop();
			count--;
			
			for(int i=thisNum+1;i<targetSpeling.length;i++) {
				stack.add(i);
				count++;
				if(count==K) {
					int possibleWord = 0;
					
				
					for(String s : keySet) {
						
						boolean possibleFlag = true;
						
						for(int b=0;b<s.length();b++) {
							char c = s.charAt(b);
							for(int a=0;a<K;a++) {
								if(c==targetSpeling[stack.get(a)]) {
									possibleFlag=true;
									break;
								}//if end
								possibleFlag=false;
							}//for end
							
							if(!possibleFlag)
								break;
						}//for end
						
						if(!possibleFlag)
							continue;

						possibleWord+=targetWord.get(s);
					}//for end
					
					if(possibleWord>max)
						max=possibleWord;
					break;
				}//if end
			}//for end
		}//while end
		
		System.out.println(max);
		
		br.close();
	}//main() end
}//class end