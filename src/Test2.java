import java.util.Arrays;
import java.util.Collections;

public class Test2 {
	public static int[] solution(int N, int[] stages) {
        Double[] tempAnswer = new Double[N];
        int[] answer = new int[N];
        double challengers =stages.length;
        
        for(int i=1;i<=N;i++){
            double successChallengers= 0;
            for(int j=0;j<stages.length;j++){
                if(stages[j]==i)
                    successChallengers++;
            }//for end
            System.out.println(successChallengers/challengers);
            tempAnswer[i-1] = successChallengers/challengers;
            challengers-=successChallengers;
        }//for end
        
        //primitive Type에는 reverse	불가하니 래퍼클래스로.
        Double[] grade;
        grade = tempAnswer.clone();
        Arrays.sort(grade,Collections.reverseOrder());
        
        for(int i=0;i<N;i++) {
        	
        	for(int j=N-1;j>=0;j--) {
        		if(grade[i]==tempAnswer[j]) {
        			answer[j]=i+1;
        			break;
        		}
        	}//for end
        }//for end
        
        return answer;
    }
	public static void main(String[] args) {
		int[] result = new int[5];
		result = Test2.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}//main end 
}
