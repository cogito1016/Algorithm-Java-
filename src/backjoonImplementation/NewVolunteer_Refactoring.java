package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NewVolunteer_Refactoring{
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testNum = Integer.parseInt(st.nextToken());
		
		for(int test=0;test<testNum;test++) {
			int n =  Integer.parseInt(br.readLine());
			int[] list = new int[n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				list[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken())-1;
			}//for end 
			
			
			int standard = list[0];
			int cnt=1;
			for(int i=1;i<n;i++) {
				if(list[i]<standard) {
					standard=list[i];
					cnt++;
				}//if end
			}//for end 
			System.out.println(cnt);
		}//for end
		
		br.close();
	}//main() end
}//class end