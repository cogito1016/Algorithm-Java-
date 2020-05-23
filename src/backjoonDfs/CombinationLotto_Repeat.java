package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class CombinationLotto_Repeat {
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
			}//for end 입력 초기화
			
			Stack<Integer> stack = new Stack<Integer>();
			stack.add(-1);
			while(!stack.isEmpty()) {
				int thisIndex = stack.pop();
				
				for(int i= thisIndex+1;i<list.length;i++) {
					stack.add(i);
					if(stack.size()==maximum) {
						for(int a=0;a<stack.size();a++) {
							System.out.print(list[stack.get(a)]+" ");
						}//출력
						System.out.println();
						break;
					}//로또개수만큼 선택된거면	
				}//for end 스택에 추가부분
			}//Dfs로 조합구현
			
			
			System.out.println();
			
		}//while end
		br.close();
	}//main() end
}//class end