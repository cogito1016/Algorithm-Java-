package backjoonFullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SubSequence_OterWay {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		
		int number = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		int result=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<number;i++) {
			int thisNum = Integer.parseInt(st.nextToken());	
			list.add(thisNum);
		}//for end
		

		int tempResult = 0;
		stack.add(-1);
		boolean startTrigger = true;
		
		while(!stack.isEmpty()) {
			int thisNum = stack.pop();
			
			if(startTrigger)
				startTrigger=false;
			else
				tempResult -=list.get(thisNum);
				
			for(int i=thisNum+1;i<list.size();i++) {
				tempResult +=list.get(i);
				stack.add(i);
			}//for end
			if((tempResult==goal)&&!stack.isEmpty())
				result++;
		}//while end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end