package backjoonIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example14 {
	
	public static void sort(List<String> list,int num) {
		
		String temp;
		for(int i=0;i<num;i++) {
			for(int j=0;j<list.size()-1;j++) {
				temp=list.get(j);
				list.set(j, list.get(j+1));
				list.set(j+1, temp);
			}//for end
		}//for end
	}//sort() end

	public static void main(String[] args) {
		
		Scanner scan = 
				new Scanner(System.in);

		int month = scan.nextInt();
		int day = scan.nextInt();
		
		List<Integer> thirtyOne = new ArrayList<Integer>(Arrays.asList(1,3,5,7,8,10,12)) ;
		List<Integer> thirty = new ArrayList<Integer>(Arrays.asList(4,6,9,11)) ;
		List<String> days = new ArrayList<String>(Arrays.asList("SUN","MON","TUE","WED","THU","FRI","SAT"));
		
		int thisDay=0;
		
		for(int i=1; i<=month; i++) {
			//해당월이 마지막 월이 아니면 해당 월의 일수만큼 추가
			if(i!=month) {
				if(thirtyOne.contains(i)) {
					thisDay=31;
				}else if(thirty.contains(i)){
					thisDay=30;
				}else {
					thisDay=28;
				}
			}else {//해당월이 마지막 월이면 일수만큼만 추가
				thisDay=day;
			}//if~else end
			sort(days,thisDay%7);
		}//for end
		
		System.out.println(days.get(0));

	}//main() end
}