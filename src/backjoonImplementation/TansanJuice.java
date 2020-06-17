package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TansanJuice {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int sum = 0;
		
		while(e>=c) {
			int top = e/c;
			int bottom = e%c;
			sum+=top;
			e=top+bottom;
		}//while end
		
		System.out.println(sum);
		br.close();
	}//main() end
}//class end