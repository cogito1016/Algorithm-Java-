package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class CombinationLotto {
	static int maximum=6;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int listNum=1;
		
		while(listNum!=0) {
			st = new StringTokenizer(br.readLine());
			listNum = Integer.parseInt(st.nextToken());
			int[] list = new int[listNum];
			for(int j=0;j<listNum;j++) {
				list[j]=Integer.parseInt(st.nextToken());
			}//for end
			
			Stack<Integer> stack = new Stack<Integer>();
			List<Integer> stackList = new ArrayList<Integer>();
			
			stack.add(-1);
			stackList.add(-1);
			int maxSize=1;
			while(!stack.isEmpty()) {
				int thisNumber = stack.pop();
				stackList.remove(stackList.size()-1);
				maxSize--;
				
				for(int i=thisNumber+1;i<listNum;i++) {
					stack.add(i);
					stackList.add(list[i]);
					maxSize++;
					if(maxSize==maximum) {
						for(int j=0;j<stackList.size();j++) 
							System.out.print(stackList.get(j)+" ");
						System.out.println();
						break;
					}//if end
				}//for end
			}//while end
			System.out.println();
		}//while end
		br.close();
	}//main() end
}//class end