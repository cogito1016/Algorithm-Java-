package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuitarLesson {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int lessonNum = Integer.parseInt(st.nextToken());
		int bluelayNum = Integer.parseInt(st.nextToken());
		int[] lessonList = new int[lessonNum];
		
		st = new StringTokenizer(br.readLine());
		
		int total=0; //총합
		int max = 0;
		long min=2147483648L;
		for(int i=0;i<lessonNum;i++) {
			total += lessonList[i] = Integer.parseInt(st.nextToken());
			if(max<lessonList[i])
				max=lessonList[i];
		}//for end 초기화
//		System.out.println(total);
		
		if(bluelayNum==1)
			System.out.println(total);
		else if(bluelayNum==lessonNum)
			System.out.println(max);
		else {
			long left = max;
			long right = total;
			long mid;
			while(left<=right) {
				mid = (left+right)/2;
				
				long minutes = mid;
				int tempBluelay=1;
				
				for(int i=0;i<lessonNum;i++) {
					minutes-=lessonList[i];
					if(minutes==0) {
						minutes=mid;
						if(i!=lessonNum-1)
							tempBluelay++;
					}else if(minutes<0) {
						minutes=mid;
						minutes-=lessonList[i];
						tempBluelay++;
					}//if~ else if end
				}//for end 블루레이 수 구하기
				
				if(tempBluelay<=bluelayNum) {
					right=mid-1;
					if(min>mid)
						min=mid;
//					if(tempBluelay==bluelayNum)
				}
				else if(tempBluelay>bluelayNum)
					left=mid+1;
			}//while end

			System.out.println(min);
		}//if~ elseIf~ else end
		
		
		br.close();
	}//main() end
}//class end