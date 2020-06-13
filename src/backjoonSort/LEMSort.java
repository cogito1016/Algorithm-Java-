package backjoonSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class LEMSort {

	static class GradeInfo{
		String name;
		int lan,math,english;
		GradeInfo(String name, int lan, int english, int math){
			this.name=name;
			this.lan=lan;
			this.math=math;
			this.english=english;
		}//cons end
	}//class end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		GradeInfo[] list = new GradeInfo[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new GradeInfo(st.nextToken(),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}//for end 
		
		Arrays.sort(list, new Comparator<GradeInfo>() {
			@Override
			public int compare(GradeInfo o1, GradeInfo o2) {
				
				if(o1.lan<o2.lan)
					return 1;
				else if(o1.lan==o2.lan) {
					if(o1.english>o2.english)
						return 1;
					else if(o1.english==o2.english) {
						if(o1.math<o2.math)
							return 1;
						else if(o1.math==o2.math) {
							

							for(int i=0;i<o1.name.length();i++) {
								if(o1.name.charAt(i)>o2.name.charAt(i)){
									return 1;
								}//if end
								else if(o1.name.charAt(i)<o2.name.charAt(i)) {
									return -1;
								}
							}//for end
							return -1;
							
						}//if~elseIf end 
					}//if~elseIf end
				}//if~elseIf end
				return -1;
			}
		});
		
		for(GradeInfo item : list) {
			System.out.println(item.name);
		}
		
		br.close();
	}//main() end
}