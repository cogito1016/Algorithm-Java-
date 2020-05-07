package Kakao2019WinterIntership;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tuple {
	
    public static int[] solution(String s) {
    	int[] answer = {};
        
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();;
        
        boolean beforeIsNum=false;
        
        for(int i=0;i<s.length();i++) {
        	if(i==0||i==s.length()-1)
        		continue;
        	char thisChar = s.charAt(i);
        	if(thisChar=='{') {
        		list.add(new ArrayList<Integer>());
        		beforeIsNum=false;
        		continue;
        	}else if(thisChar>=48&&thisChar<=57) {
        		if(beforeIsNum) {
        			int goalIndex = list.get(list.size()-1).size()-1;
        			String originNum = list.get(list.size()-1).get(list.get(list.size()-1).size()-1)+"";
        			String goalNum = originNum+thisChar;
        			list.get(list.size()-1).set(goalIndex,Integer.parseInt(goalNum));
        		}
        		else
        			list.get(list.size()-1).add(thisChar-'0');
        		beforeIsNum=true;
        		continue;
        	}
    		beforeIsNum=false;
        }//for end 문자열을 처리하여 각 부분집합별로 모아놓기 위함
        
        Collections.sort(list, new Comparator<ArrayList<Integer>>(){
        	@Override
        	public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        		if(o1.size()>o2.size())
        			return 1;
        		return -1;
        	}
		});//부분집합을 크기별로 놓아놓기 위함
        
        

//    	answer = new int[list.get(list.size()-1).size()];
    	ArrayList<Integer> answerList = new ArrayList<Integer>();
        for(int i=0;i<list.size();i++) {
        	
        	ArrayList<Integer> temp = list.get(i);
        	
        	for(int j=0;j<temp.size();j++) {
            	if(answerList.contains(temp.get(j)))
            		continue;
            	answerList.add(temp.get(j));
        	}//for end
        }//for end
        
        answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++) {
        	answer[i]= answerList.get(i);
        }//for end
        
        return answer;
    }
    
	public static void main(String[] args) {
		String s = "{{20,111},{111}}";
		Tuple.solution(s);
	}//main() end
}//class end