package backjoonFullSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BlackJack {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cards[i] = Integer.parseInt(st.nextToken()); 
		}//for end
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int count = 0;
		int max = 0;
		int tempResult = 0;
		stack.add(-1);
		
		while(!stack.isEmpty()) {
			int thisNum = stack.pop();
			
			if(thisNum!=-1) {
				count --;
				tempResult -= cards[thisNum];
			}//if end
			
			for(int i=thisNum+1;i<N;i++) {
				tempResult += cards[i];
				count ++ ;
				stack.add(i);
				if(count==3) {
//					System.out.println(stack);
					if(tempResult>max && tempResult<=M)
						max=tempResult;
					break;
				}//if end
			}//for end
			
		}//while end
		System.out.println(max);
		br.close();
	}//main() end
}
