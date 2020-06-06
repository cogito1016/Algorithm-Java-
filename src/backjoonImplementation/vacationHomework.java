package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class vacationHomework {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine());
		float math = Float.parseFloat(br.readLine());
		float lan = Float.parseFloat(br.readLine());
		float mathOfDay = Float.parseFloat(br.readLine());
		float lanOfDay = Float.parseFloat(br.readLine());
		
		int mathTotal = (int) Math.ceil(math/mathOfDay);
		int lanTotal = (int) Math.ceil(lan/lanOfDay);
		
		int max = mathTotal > lanTotal ? mathTotal:lanTotal;
		
		System.out.println(total-max);
		
		br.close();
	}//main() end
}//class end