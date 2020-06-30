package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Running {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new LinkedList<Integer>();
		
		list.add(Integer.parseInt(br.readLine()));
		System.out.println(1);
		
		
		for(int i=1;i<N;i++) {
			int input = Integer.parseInt(br.readLine());
			
			int left = 0 ;
			int right = list.size();
			int mid = 0;
			
			while(left<=right && left<list.size()) {
				mid = (left+right)/2;
				int getValue = list.get(mid);
				
				if(getValue>input) {
					right = mid - 1;
				}else if(getValue<input){
					left = mid + 1;
				}//if~elseIf end
			}//while end 
			
			list.add(left,input);
			System.out.println(list.size()-left);
		}//for end
		
		br.close();
	}//main() end
}//class end