package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MeetingRoom {
	
	static class Request{
		int start,end;
		Request(int start,int end){
			this.start=start;
			this.end=end;
		}//cons end
	}//class end

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		int meeting = Integer.parseInt(br.readLine());
		Request[] list = new Request[meeting];
		
		
		for(int i=0;i<meeting;i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Request(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}//for end
		
		Arrays.sort(list,new Comparator<Request>(){

			@Override
			public int compare(Request o1, Request o2) {
				if(o1.end>o2.end)
					return 1;
				if(o1.end==o2.end)
					if(o1.start>o2.start)
						return 1;
				return -1;
			}//compare end
		});//sort end

		Request thisRequest = list[0];
		int result =1;
		for(int i=1;i<meeting;i++) {
			if(thisRequest.end<=list[i].start){
				result++;
				thisRequest=list[i];
			}//if end
		}//for end
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end