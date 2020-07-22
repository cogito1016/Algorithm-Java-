package backjoonImplementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class KeyLogger {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- >0) {
		
			String s = br.readLine();
			List<Character> list = new LinkedList<Character>();
			int cursor = 0;
			
			for(int i=0;i<s.length();i++) {
				
				char c = s.charAt(i);
				
				if(c=='<') {
					cursor = cursor==0? cursor : cursor-1;
					continue;
				}else if(c=='>') {
					cursor = cursor==list.size()? cursor : cursor+1;
					continue;
				}else if(c=='-') {
					if(cursor!=0) 
						list.remove(--cursor);
					continue;
				}//if~elseIf~elseIf end
				
				list.add(cursor,c);
				cursor++;
			}//for end
			
			for(char c : list) {
				System.out.print(c);
			}//for end		
		}//while end
		
		br.close();
	}//main() end
}
