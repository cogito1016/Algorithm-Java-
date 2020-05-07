package backjoonFullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SubSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		
		int number = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		List<Integer> plusList = new ArrayList<Integer>();
		List<Integer> minusList = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		int result=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<number;i++) {
			int thisNum = Integer.parseInt(st.nextToken());
			if(thisNum>0)
				plusList.add(thisNum);
			else
				minusList.add(thisNum);
		}//for end
		
		for(int victim : plusList) {
			
			int tempResult = victim;
			stack.add(-1);
			boolean startTrigger = true;
			
			while(!stack.isEmpty()) {
				int thisNum = stack.pop();
				
				if(startTrigger)
					startTrigger=false;
				else
					tempResult -=minusList.get(thisNum);
				
					
				for(int i=thisNum+1;i<minusList.size();i++) {
					tempResult +=minusList.get(i);
					stack.add(i);
				}//for end
				if(tempResult==goal)
					result++;
			}//while end
		}//for end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end