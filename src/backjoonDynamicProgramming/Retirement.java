package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Retirement {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N];
		int[] P = new int[N];
		
		StringTokenizer st;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			T[i]=Integer.parseInt(st.nextToken());
			P[i]=Integer.parseInt(st.nextToken());
			
		}//for end
		
		int max =0;
		stack.add(-1);
		int neededDays = 1;
		int attainableValue = 0;
		int resultValue = 0;
		while(!stack.isEmpty()) {
			if(stack.size()==4 && stack.get(1)==5) {
				System.out.println("hi fuck");
			}
			int thisNum = stack.pop();

			
			if(thisNum!=-1) {
				neededDays = T[thisNum];
				attainableValue = P[thisNum];
			}//if end
			
			resultValue -= attainableValue;
			
			for(int i=thisNum+1;i<N;i++) {
				neededDays--;
				stack.add(i);
				if(neededDays!=0)
					continue;
				if(i+T[i]>=N+1)
					continue;
				
				neededDays=T[i];
				resultValue+=P[i];
				
				if(max<resultValue)
					max=resultValue;
			}//for end
			
			System.out.println(stack);
		}//while end
		
		System.out.println(max);
		br.close();
	}//main() end
	
}
