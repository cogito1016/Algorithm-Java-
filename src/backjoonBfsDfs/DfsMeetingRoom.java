package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsMeetingRoom {
	
	static class Request implements Comparable<Request>{
		int start,end;
		Request(int start, int end){
			this.start=start;
			this.end=end;
		}//cons end
		
		@Override
		public int compareTo(Request o) {
			if(end>o.end)
				return 1;
			if(end==o.end){
				if(start>o.start)
					return 1;
			}
			return -1;
		}
	}//class end

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int requestNum = Integer.parseInt(br.readLine());
		Request[] requestList = new Request[requestNum];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int max=0;
		
		for(int i=0; i<requestNum; i++) {
			st=new StringTokenizer(br.readLine());
			Request request = new Request(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			requestList[i]=request;
		}//for end
		
		Arrays.sort(requestList);
		
		stack.add(-1);

		int possibleTime=1;
		
		while(!stack.isEmpty()) {
			int thisIndex=stack.pop();
			possibleTime--;
			Request thisRequest = null;
			
			if(thisIndex==-1) {
				possibleTime++;
				thisIndex=0;
				stack.add(thisIndex);
			}//if end
			
			thisRequest = requestList[thisIndex];
			
			for(int i=thisIndex+1;i<requestNum;i++) {
				Request nextRequest = requestList[i];

				if(thisRequest.end<=nextRequest.start){
					stack.add(i);
					possibleTime++;
					thisRequest=nextRequest;
				}//if end
				
			}//for end
			
			if(max<possibleTime)
				max=possibleTime;
			
		}//while end
		System.out.println(max);
		
		br.close();
	}//main() end
}//class end