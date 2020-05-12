package backjoonQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int testCase=0;testCase<test;testCase++) {
			String instruction = br.readLine();
			
			boolean reverseflag = false;
			boolean errorFlag = false;
			Deque<Integer> deque = new ArrayDeque<Integer>();
			
			int num = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			arr=arr.replace("[", "");
			arr=arr.replace("]", "");
			String[] arrSplit = arr.split(",");
			for(int i=0;i<num;i++) {
				deque.add(Integer.parseInt(arrSplit[i]));
			}//for end 문자열처리 및 디큐에 초기화 N= 100,000
			
			for(int i=0;i<instruction.length();i++) {
				char c = instruction.charAt(i);
				if(c=='R') {
					if(reverseflag)
						reverseflag=false;
					else
						reverseflag=true;
				}//if end 리버스의 경우
				if(c=='D') {
					if(deque.isEmpty()) {
						errorFlag=true;
						break;
					}//if end 비어있을 경우
					if(reverseflag) 
						deque.removeLast();
					else 
						deque.removeFirst();
				}//if end 제거의 경우
			}//for end N= 100,000

			if(!errorFlag) {
				int i=0;
				int dequeSize = deque.size();
				System.out.print("[");
				if(!reverseflag) {
					for(i=0;i<dequeSize;i++) {
						System.out.print(deque.removeFirst());
						if(i!=dequeSize-1)
							System.out.print(",");
					}//for end
				}else {
					for(i=0;i<dequeSize;i++) {
						System.out.print(deque.removeLast());
						if(i!=dequeSize-1)
							System.out.print(",");
					}//for end
				}//if~else if end
				System.out.print("]");
			}else {
				System.out.print("error");
			}
			System.out.println();
		}//for end
		br.close();
	}//main() end
}//class end