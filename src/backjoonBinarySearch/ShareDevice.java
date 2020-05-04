package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShareDevice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int houseNum = Integer.parseInt(st.nextToken());
		int deviceNum = Integer.parseInt(st.nextToken());
		
		int[] house = new int[houseNum];
		
		for(int i=0;i<houseNum;i++) {
			house[i] = Integer.parseInt(br.readLine());
		}//for end
		
		Arrays.sort(house);
		
		
		
		
		br.close();
	}//main() end
}//class end