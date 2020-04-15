package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsTermProject_OtherWay3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		int[] nonTeam = new int[testCase];
		
		for(int i=0;i<testCase;i++) {
			
			int v = Integer.parseInt(br.readLine());
			int[] map = new int[v];
			boolean[] visit = new boolean[v];
			Stack<Integer> stack = new Stack<Integer>();
			List<Integer> list;
			
			st=new StringTokenizer(br.readLine());
			for(int a=0;a<v;a++) {
				map[a]=Integer.parseInt(st.nextToken())-1;
				if(map[a]==a){
					visit[a]=true;
					nonTeam[i]++;
				}//if end
				
			}//for end

			for(int b=0;b<v;b++) {
				if(visit[b])
					continue;
				
				list = new ArrayList<Integer>();
				stack.push(b);
				list.add(b);
				visit[b]=true;
				
				while(!stack.isEmpty()) {
					int node = stack.pop();
					int nextNode = map[node];
					if(nextNode==b) {
						nonTeam[i]+=list.size();
						continue;
					}//if end
					if(list.contains(nextNode)){
						int thisIndex = list.indexOf(nextNode);
						nonTeam[i]+= list.size()-thisIndex;
						continue;
					}//if end
					if(visit[nextNode]) {
						continue;
					}
					visit[nextNode]=true;
					list.add(nextNode);
					stack.push(nextNode);
				}//while end
			}//for end
			
			System.out.println(v-nonTeam[i]);
		}//for end
		br.close();
	}//main() end
}//class end