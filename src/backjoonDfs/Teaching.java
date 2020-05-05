package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Teaching {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int letterNum = Integer.parseInt(st.nextToken());
		int teachingWordNum = Integer.parseInt(st.nextToken());
		
		String[] wordList = new String[letterNum];
		List<String> exceptList = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		
		int max=0;
		int possibleRead=0;
		
		
		teachingWordNum -=5;
		
		exceptList.add("a");
		exceptList.add("n");
		exceptList.add("t");
		exceptList.add("i");
		exceptList.add("c");
		
		//단어 입력 부
		for(int i=0;i<letterNum;i++) {
			String s=br.readLine(); //원래 단어
			
			// a n t i c 골라내기
			for(int j=0;j<5;j++) {
				s=s.replace(exceptList.get(j),"");
			}//for end
			
			wordList[i]=s; //골라진단어의 배열
			
			if(s.length()==0) //골라진단어의 결과가 0이면 a n t i c 만으로도 읽을 수 있는 문자
				possibleRead++;
			
			//제외될 수 있는 문자들을 모아놓는다
			for(int k=0;k<s.length();k++) {
				String newExcept = s.charAt(k)+"";
				if(exceptList.contains(newExcept))
					continue;
				exceptList.add(newExcept);
			}//for end 
		}//for end
		

		if(teachingWordNum<0)//가르칠 단어가 0보다 작으면( a n t i c 도 못가르칠거가으면)
			System.out.println("0"); //하나도 읽을 수 있는게 없지
		else if(teachingWordNum==0) //가르칠 단어가 0이면( a n t i c 만 읽을 수 있으면)
			System.out.println(possibleRead); //단어 입력부에서 나온 결과가 답
		else {// 가르칠 단어가 a n t i c 보다 많으면?
			
			//이제 a n t i c 는 필요없다(이미 단어입력부에서 걸렀으므로)
			for(int i=0;i<5;i++) 
				exceptList.remove(0);
			int exceptListNum = exceptList.size();//제외될 수 있는 단어들의 수
			possibleRead=0;//읽을 수 있는 단어의 수 초기화
			
			//DFS를 실행 최초 실행은 -1로 실행합니다. (아무의미없는 문자열)
			stack.add("-1");
			while(!stack.isEmpty()) {
				possibleRead=0;
				String s =stack.pop();
				int thisIndex;
				
				if(s.equals("-1"))
					thisIndex=-1;
				else
					thisIndex = exceptList.indexOf(s);
				
				//조합
				for(int i=thisIndex+1;i<exceptListNum;i++) {
					stack.add(exceptList.get(i));
					int stackSize=stack.size();
					if(stackSize==teachingWordNum) {
						for(int a=0;a<wordList.length;a++) {
							String tempStr = wordList[a];
							for(int b=0;b<stackSize;b++) 
								tempStr = tempStr.replace(stack.get(b),"");
							if(tempStr.length()==0) 
								possibleRead++;
						}//for end
						if(max<possibleRead)
							max=possibleRead;
						break;
					}//if end
				}//for end
			}//while end
			System.out.println(max);
		}//if~elseIf~else end
	
		
		br.close(); 
	}//main() end 
}//class end