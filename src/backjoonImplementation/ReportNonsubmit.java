package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportNonsubmit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<30;i++) {
			list.add(i);
		}//for end
		
		for(int i=0;i<28;i++) {
			int a = Integer.parseInt(br.readLine())-1;
			list.remove(list.indexOf(a));
		}//for end
		
		Collections.sort(list);
		
		for(int i:list) {
			System.out.println(i+1);
		}//for end
		
		br.close();
	}//main() end
}//class end