package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsTermProject_OtherWay2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		int[] nonTeam = new int[testCase];
		
		for(int i=0;i<testCase;i++) {
			
			int v = Integer.parseInt(br.readLine());
			int[] map = new int[v];
			boolean[] visit = new boolean[v];
			boolean[] team = new boolean[v];
			Stack<Integer> stack = new Stack<Integer>();
			List<Integer> list;
			st=new StringTokenizer(br.readLine());
			for(int a=0;a<v;a++) {
				map[a]=Integer.parseInt(st.nextToken())-1;
				if(map[a]==a){
					visit[a]=true;
					team[a]=true;
				}//if end
			}//for end

			for(int b=0;b<v;b++) {
				if(visit[b])
					continue;
				
				list = new ArrayList<Integer>();
				stack.push(b);
				list.add(b);
				
				while(!stack.isEmpty()) {
					int node = stack.pop();
					int nextNode = map[node];

					if(visit[nextNode]) {
						for(int state : list){
							visit[state]=true;
						}//for end
						continue;
					}
					if(nextNode==b) {
						for(int state : list){
							team[state]=true;
							visit[state]=true;
						}//for end
						continue;
					}//if end
					if(list.contains(nextNode)){
						int thisIndex = list.indexOf(nextNode);
						for(int index=0;index<thisIndex;index++) {
							visit[list.get(index)]=true;
						}//for end
						for(int index=thisIndex;index<list.size();index++) {
							team[list.get(index)]=true;
							visit[list.get(index)]=true;
						}//for end
						continue;
					}//if end
					list.add(nextNode);
					stack.push(nextNode);
				}//while end
			}//for end
			
			for(int j=0;j<v;j++) {
				if(!team[j]) 
					nonTeam[i]++;
			}//for end
		}//for end
		
		for(int i=0;i<testCase;i++) {
			System.out.println(nonTeam[i]);
		}//for end
		
		br.close();
	}//main() end
}//class end