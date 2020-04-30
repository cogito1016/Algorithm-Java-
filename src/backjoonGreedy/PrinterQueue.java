package backjoonGreedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PrinterQueue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i=0;i<testCaseNum;i++) {
			st = new StringTokenizer(br.readLine());
			int paperNum = Integer.parseInt(st.nextToken());
			int findPaper = Integer.parseInt(st.nextToken());
			int targetIndex = findPaper;
			int count=0;
			List<Integer> list = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			for(int a=0;a<paperNum;a++) {
				list.add(Integer.parseInt(st.nextToken()));
			}//for ends
			
			while(!list.isEmpty()) {
				
				//맨 처음 뽑고
				int thisNum = list.remove(0);
				//나머지 중에 큰게 있니 없니?
				boolean flag = false;
				
				for(int b=0;b<list.size();b++) {
					if(thisNum<list.get(b)) {
						flag=true;
						break;
					}//if end
				}//for end
				
				//있으면 뽑은거 마지막에 다시 넣어 
				//근데 타겟인덱스0이야?(타겟이야?) 그럼 타겟 마지막인덱스로 초기화 아니면 인덱스 그냥 내려
				if(flag) {
					list.add(thisNum);
					if(targetIndex==0)
						targetIndex=list.size()-1;
					else
						targetIndex--;
				}//if end
				
				//없으면 카운터올려 
				//근데 타겟이야? 브레끼하고 카운터출력해
				//아니야? 타겟 인덱스내려
				if(!flag) {
					count++;
					if(targetIndex==0)
					{
						System.out.println(count);
						break;
					}else
						targetIndex--;
				}//if end
				
			}//for end
			
		}//for end
		br.close();
	}//main() end
}//class end