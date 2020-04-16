package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BellClock {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int clock= Integer.parseInt(st.nextToken());
		int minute= Integer.parseInt(st.nextToken());
		
		int changeMin = minute-45;
		if(changeMin<0)
		{
			clock--;
			if(clock<0)
				clock=23;
			changeMin = 60-changeMin*-1;
		}//if end
		
		System.out.print(clock+" "+changeMin);
		
		br.close();
	}//main() end
}//Class end