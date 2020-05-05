package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EscapeHongIk {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[100000];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		
		int click=-1;
		boolean flag=false;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			click++;
			for(int i=0;i<queueSize;i++) {
				int number = queue.poll();
				
				if(click>t) {
					queue.clear();
					break;
				}//if end 클릭수 넘으면
				
				if(number==g) {
					flag=true;
					queue.clear();
					break;
				}//if end 정답 맞추면
				
				
				for(int a=0;a<2;a++) {
					if(a==0) {//ButtonA
						int resultA=number+1;
						if(resultA>99999)
							continue;
						if(visit[resultA])
							continue;
						visit[resultA]=true;
						queue.offer(resultA);
					}else {//ButtonB
						int resultB= 2*number;
						if(resultB>99999||resultB==0)
							continue;
						else{
							String s = resultB+"";
							int trans = s.charAt(0)-'0';
							trans-=1;
							String transResult = trans+s.substring(1,s.length());
							int result = Integer.parseInt(transResult);
							if(visit[result])
								continue;
							visit[result]=true;
							queue.offer(result);
						}//if~else end ButtonB
					}//if~else end
				}//for end ButtonA~B
				
			}//for end
		}//while end
		
		if(flag)
			System.out.println(click);
		else
			System.out.println("ANG");
		
		br.close();

	}//main() end
}//class end