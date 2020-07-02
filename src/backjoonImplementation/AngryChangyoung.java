package backjoonImplementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AngryChangyoung {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int D = (int) Math.sqrt(W*W+H*H);
		
		while(N-- >0) {
			int match = Integer.parseInt(br.readLine());
			if(D>=match)
				System.out.println("DA");
			else
				System.out.println("NE");
		}//while end
		
		br.close();
		
	}//main() end
}//calss end