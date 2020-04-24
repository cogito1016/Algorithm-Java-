package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsTermProject {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0;i<testCase;i++) {
			
			int v = Integer.parseInt(br.readLine());
			int[] map = new int[v];
			boolean[] visit = new boolean[v];
			Stack<Integer> stack = new Stack<Integer>();
			List<Integer> list;
			
			st=new StringTokenizer(br.readLine());
			for(int a=0;a<v;a++) {
				map[a]=Integer.parseInt(st.nextToken())-1;
				stack.push(a);
			}//for end
			
			int result =0;

			for(int a=0;a<v;a++) {
				if(visit[a])
					continue;
				list = new ArrayList<Integer>();
				visit[a]=true;
				stack.push(a);
				list.add(a);
				while(!stack.isEmpty()) {
					int thisVal = stack.pop();
					
					int nextVal = map[thisVal];
					
					if(visit[nextVal])
					{

						if(nextVal==thisVal){
							result+= list.size()-1;
							stack.clear();
							break;
						}
						else if(list.get(0)==nextVal)
						{
							stack.clear();
							break;
						}
						else if(list.contains(nextVal)){
							result += list.indexOf(nextVal);
							break;
						}//if ~ else if ~ if
						
						result+=list.size();
						stack.clear();
						break;
					}//if end
					
					visit[nextVal]=true;
					list.add(nextVal);
					stack.push(nextVal);
					
				}//while end
			}//for end
			System.out.println(result);
		}//for end

		br.close();
	}//main() end
}//class end