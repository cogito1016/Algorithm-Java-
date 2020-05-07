package backjoonFullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SubSequence_Repeat {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int[] list = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			list[i]= Integer.parseInt(st.nextToken());

		//인덱스가 스택의 팝-푸쉬니까 -1으로 하면 겹칠가능성이 없지
		stack.add(-1);
		int sum=0;
		int result=0;
		while(!stack.isEmpty()) {
			int thisIndex = stack.pop();
			if(thisIndex!=-1)
				sum-=list[thisIndex];
			
			for(int i=thisIndex+1; i<list.length;i++) {
				stack.push(i);
				sum+=list[i];
			}//for end
			if((sum==goal)&&!stack.isEmpty())
				result ++ ;
		}//while end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end