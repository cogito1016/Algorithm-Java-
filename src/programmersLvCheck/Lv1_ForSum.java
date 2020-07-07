package programmersLvCheck;

public class Lv1_ForSum {
	
	public static void main(String[] args) {
		
		int a=3;
		int b=5;
		
		long answer = 0;
		
		if(a>b) {
			int temp=a;
			a=b;
			b=temp;
		}
		
		for(int i=a;i<=b;i++) {
			answer+=i;
		}
		
		
        System.out.println(answer);
	}
}
