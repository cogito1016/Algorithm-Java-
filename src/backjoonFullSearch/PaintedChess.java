package backjoonFullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaintedChess {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[y][x];
		
		for(int i=0;i<y;i++) {
			String s = br.readLine();
			for(int j=0;j<x;j++) {
				map[i][j]=s.charAt(j);
			}//for end 
		}//for end
		int result =100;
		for(int i=0;i<=y-8;i++) {
			for(int j=0;j<=x-8;j++) {
				
				for(int possible=0;possible<2;possible++) {
					char hopeColor;
					if(possible==0)
						hopeColor='W';
					else
						hopeColor='B';
					int count=0;
					
					for(int a=i;a<i+8;a++) {
						for(int b=j;b<j+8;b++) {
							
							
							char thisColor = map[a][b];
							if(hopeColor!=thisColor)
								count++;
							
							if(hopeColor=='W')
								hopeColor='B';
							else
								hopeColor='W';
							
						}//for end
						if(hopeColor=='W')
							hopeColor='B';
						else
							hopeColor='W';
					}//for end 
					if(count<result)
						result = count;
				}
			}//for end
		}//for end
		
		System.out.println(result);
		
		br.close();
	}//main() end
}//class end