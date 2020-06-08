package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NewVolunteer{
	
	static class Volunteer implements Comparable<Volunteer>{
		int paper, meeting;
		
		Volunteer(int paper,int meeting) {
			this.paper = paper;
			this.meeting = meeting;
		}
		
		@Override
		public int compareTo(Volunteer o) {
			if(this.paper<o.paper)
				return -1;
			return 1;
		}
		
	}//class end 

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testNum = Integer.parseInt(st.nextToken());
		
		for(int test=0;test<testNum;test++) {
			int n =  Integer.parseInt(br.readLine());
			Volunteer[] volunteers = new Volunteer[n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				volunteers[i] = new Volunteer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}//for end 
			
			Arrays.sort(volunteers);
			
			int standard = volunteers[0].meeting;
			int cnt=1;
			for(int i=1;i<n;i++) {
				if(volunteers[i].meeting<standard) {
					standard=volunteers[i].meeting;
					cnt++;
				}//if end
			}//for end 
			System.out.println(cnt);
		}//for end
		
		br.close();
	}//main() end
}//class end