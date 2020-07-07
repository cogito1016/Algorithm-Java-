package programmersFullSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



public class TrialExam {
	
	
	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		
		int[] first = {1,2,3,4,5};
		int[] second = {2,1,2,3,2,4,2,5};
		int[] third = {3,3,1,1,2,2,4,4,5,5};
		
		Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>(); 
		map.put(1, 0);
		map.put(2, 0);
		map.put(3, 0);
		
		int max = 0;
		for(int i=0;i<answers.length;i++) {
			
			int thisAnswer = answers[i];
			
			if(first[i%first.length]==thisAnswer)
				map.put(1, map.get(1)+1);
			
			if(second[i%second.length]==thisAnswer)
				map.put(2, map.get(2)+1);

			if(third[i%third.length]==thisAnswer)
				map.put(3, map.get(3)+1);
		}//for end
		
		
		List<Integer> resultList = new ArrayList<Integer>();
		
		for(int i=1;i<=3;i++) {
			if(max<map.get(i))
				max=map.get(i);
		}//for end
		
		for(int i=1;i<=3;i++) {
			if(map.get(i)==max)
				resultList.add(i);
		}//for end
		
		int[] answer = new int[resultList.size()];
		for(int i=0;i<resultList.size();i++) {
			answer[i]=resultList.get(i);
		}
		System.out.println(answer);
        
	}//main() end
}
