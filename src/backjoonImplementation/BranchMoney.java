package backjoonImplementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BranchMoney {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A =Integer.parseInt(st.nextToken());
		int B =Integer.parseInt(st.nextToken());
		int C =Integer.parseInt(st.nextToken());
		
		if(B>=C) {
			System.out.println(-1);
			return ;
		}//if end 
		
		int result = A/(C-B)+1;
		
		System.out.println(result);
		
		br.close();
		
	}//main() end
}
