package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MeetingRoom_OtherWay {
	
	static class Request{
		int start,end;
		Request(int start,int end){
			this.start=start;
			this.end=end;
		}//cons end
	}//class request end
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int meetingNum = Integer.parseInt(br.readLine());
		
		Request[] requestList = new Request[meetingNum];
		
		for(int i=0;i<meetingNum;i++) {
			st = new StringTokenizer(br.readLine());
			requestList[i] =new Request(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}//for end
		
		Arrays.sort(requestList, new Comparator<Request>(){
			@Override
			public int compare(Request o1, Request o2) {
				if(o1.end>o2.end)
					return 1;
				else if(o1.end==o2.end) {
					if(o1.start>o2.start)
						return 1;
				}
				return -1;
			}//Comporator end
		});

		Request thisRequest = requestList[0];
		int result =1;
		for(int i=1;i<meetingNum;i++) {
			Request nextRequest = requestList[i];
			if(thisRequest.end==nextRequest.start || thisRequest.end<nextRequest.start){
				result++;
				thisRequest = nextRequest;
			}//if end
		}//for end
		
		
		System.out.println(result);
		br.close();
		
	}//main() end
}//class end