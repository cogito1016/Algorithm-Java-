package backjoonRecursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakeZero {

	public static void solve(int N, int current, String state) {
		
		if(current==N-1) {
			String finalStr = state.replaceAll(" ", "");
			int sum = 0;
			String firstNumber = "";
			int i;
			for(i=0;i<finalStr.length();i++) {
				char c = finalStr.charAt(i);
				if(c<='9' && '1'<=c) 
					firstNumber+=c;
				else 
					break;
			}//for end

			sum += Integer.parseInt(firstNumber);
			if(i==finalStr.length()-1) {
				System.out.println(sum);
				return;
			}//if end
			
			while(i<finalStr.length()) {
				char symbol = finalStr.charAt(i);
				i++;
				String temp = "";
				for(int j=i;j<finalStr.length();j++) {
					char c = finalStr.charAt(j);
					if(c<='9' && '1'<=c) 
						temp+=c;
					else 
						break;
					i++;
				}//for end;
				
				if(symbol=='+')
					sum+=Integer.parseInt(temp);
				else
					sum-=Integer.parseInt(temp);
			}//for end
			
			if(sum==0) {
				System.out.println(state);
			}//if end
			return;
		}//if end
		
		String s;
		s =state+' '+(current+2)+"";
		solve(N, current+1,s);
		
		s =state+'+'+(current+2)+"";
		solve(N, current+1,s);
		
		s =state+'-'+(current+2)+"";
		solve(N, current+1,s);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-- >0) {
			int N=Integer.parseInt(br.readLine());
			int current = 0;
			String state = 1+"";
			solve(N,current,state);
			System.out.println();
		}//while end
		
		br.close();
	}
}
