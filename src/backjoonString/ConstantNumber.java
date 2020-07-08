package backjoonString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConstantNumber {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0 ;
		while(st.hasMoreTokens()) {
			StringBuffer sb = new StringBuffer();
			String s = st.nextToken();
			sb.append(s);
			int thisNum = Integer.parseInt(sb.reverse().toString());
			if(max<thisNum)
				max=thisNum;
		}//while end
		System.out.println(max);
		br.close();
	}//main() end
}
