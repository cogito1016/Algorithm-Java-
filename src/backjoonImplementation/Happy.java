package backjoonImplementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Happy {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int min=1000,max=0;
		for(int i=0;i<N;i++) {
			int score = Integer.parseInt(st.nextToken());
			if(score>max)
				max=score;
			if(score<min)
				min=score;
		}//for end
		
		System.out.println(max-min);
		
		br.close();
	}//main() end
}
