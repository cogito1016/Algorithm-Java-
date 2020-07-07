package programmersLvCheck;

public class Lv1_CenterSpeling {

    
    public static void main(String[] args) {

    	String s ="qwer";
        String answer = "";
        answer = s.length()%2==0?
        		s.substring(s.length()/2-1,s.length()/2+1)
        		:s.substring(s.length()/2,s.length()/2+1);
        		
        System.out.println(answer);
	}
}
