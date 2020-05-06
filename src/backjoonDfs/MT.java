package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class MT {

	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int totalPeople = Integer.parseInt(st.nextToken());
		int possiblePeople = Integer.parseInt(st.nextToken());
		
		boolean[] visit = new boolean[totalPeople+1];
		int[] map = new int[totalPeople+1];
		Stack<Integer> stack = new Stack<Integer>();
		int answer =0;
		List<Integer> list ;
		
		st= new StringTokenizer(br.readLine());
		for(int i=1;i<=totalPeople;i++)//초기화
			map[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=totalPeople;i++) {
			if(visit[i])
				continue;
			list = new ArrayList<Integer>();
			
			list.add(i);
			stack.push(i);
			visit[i]=true;
			
			while(!stack.isEmpty()) {
				int thisPerson = stack.pop();
				int hopePerson = map[thisPerson];
				
				//처음시작했던 애랑 연결되어있어? 그럼 리스트 전부가 가능해!
				if(hopePerson==i) {
					break;
				}//if end
				
				//리스트안에 포함되어있어? 그럼 포함된 애부터 마지막까지가 가능해!
				if(list.contains(hopePerson)) {
					int goalIndex = list.indexOf(hopePerson)-1;
					for(int a=0;a<=goalIndex;a++) {
						list.remove(0);
					}//for end
					break;
				}//if end
					
				//그럼 이게 이미 방문된정점이야? 그럼 다 나가리야;
				if(visit[hopePerson]) {
					list.clear();
					break;
				}
				visit[hopePerson]=true;
				stack.push(hopePerson);
				list.add(hopePerson);
			}//while end
			
			if(!list.isEmpty()) {
				int possibleTemp = list.size();
				if(possibleTemp<=possiblePeople) {
					if((answer+possibleTemp)<=possiblePeople) {
						answer +=possibleTemp;
					}else if(answer<possibleTemp) {
						answer=possibleTemp;
					}//if~else if end
				}//if end
			}//if end
		}//for end
		
		System.out.println(answer);
		
		br.close();
	}//main() end
}//class end