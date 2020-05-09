package Kakao2019WinterIntership;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;


public class BlackList {
	public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        List<String> newBanned_id = new ArrayList<String>();
        
        
        for(int i=0;i<banned_id.length;i++) {
        	boolean alreadHasFlag = false;
        	for(int j=0;j<banned_id.length;j++) {
            	if(banned_id[i].equals(banned_id[j])&&i!=j)
            			alreadHasFlag= true;
            }//for end
        	if(!alreadHasFlag)
            	newBanned_id.add(banned_id[i]);
        }//for end 제재아이디목록중에 같은게있으면 지워버리자
        
        List<ArrayList<String>> possibleList = new ArrayList<ArrayList<String>>();
        
        for(int i=0;i<newBanned_id.size();i++) {
        	 possibleList.add(new ArrayList<String>());
        	 ArrayList<String> thisList = possibleList.get(possibleList.size()-1);
    		 String testCase = newBanned_id.get(i);
    		 
    		 for(int a=0; a<user_id.length;a++) {
    			 String thisUserId = user_id[a];
    			 boolean checkPossible = true;
    			 
    			 if(thisUserId.length()!=testCase.length())
    				 continue;
    			 
    			 for(int b=0;b<thisUserId.length();b++) {
    				 char testChar = testCase.charAt(b);
    				 char userChar = thisUserId.charAt(b);
    				 if(testChar=='*')
    					 continue;
    				 if(testChar!=userChar) {
    					 checkPossible=false;
    					 break;
    				 }//if end
    			 }//for end
    			 
    			 if(checkPossible)
    				 thisList.add(thisUserId);
    		 }//for end
        }//for end 각 제재목록 아이디에 가능한 경우의수 리스트를 생성하자
        
       
       //여기까진했는데 그 후로 못하겠다
        //각 경우의수에 들어갈 아이디목록들까지 도출시키는데는 성공했음..
        
        return answer;
    }
	public static void main(String[] args) {
		
//		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//		String[] banned_id = {"fr*d*", "abc1**"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		BlackList.solution(user_id, banned_id);
	}
}//class end