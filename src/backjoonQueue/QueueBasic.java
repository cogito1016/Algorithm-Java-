package backjoonQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class QueueBasic {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> queue = new ArrayList<Integer>();
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++) {
			st=new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("push")) {
				int node = Integer.parseInt(st.nextToken());
				queue.add(node);
			}//if end
			else if(s.equals("size"))
				System.out.println(queue.size());
			else if(s.equals("empty")) 
				System.out.println(queue.isEmpty()==true?1:0);
			else if(queue.isEmpty())
				System.out.println(-1);
			else
			{
				if(s.equals("pop")) {
					System.out.println(queue.get(0));
					queue.remove(0);
				}
				else if(s.equals("front"))
					System.out.println(queue.get(0));
				else
					System.out.println(queue.get(queue.size()-1));
			}
		}//for end
		
		
		
		br.close();
	}//main() end
	
}//class end