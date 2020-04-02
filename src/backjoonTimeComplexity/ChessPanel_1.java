package backjoonTimeComplexity;

import java.util.Scanner;

public class ChessPanel_1 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int height = scan.nextInt();
		int width = scan.nextInt();

		String[][] chessPanel = new String[height][width];
		
		//자르기가능한 8X8의 정사각형의 수
		int possibleRectNum = 1+(height-8)*(width-8)+width-8+height-8;

		int min=64;
		
		//체스판 입력부
		for(int i=0;i<height;i++) {
			String oneLine = scan.next();
			for(int j=0;j<width;j++) {
				chessPanel[i][j]=String.valueOf(oneLine.charAt(j));
			}//for end
		}//for end
		
		
		String standard = "Empty";
		int thisRectNum =0;
		
		for(int i=0;i<height-7;i++) {
			for(int j=0;j<width-7;j++) {

				
				
				for(int check=0;check<2; check++) {
					if(check==1) {
						if(chessPanel[0][0].equals("B")) {
							chessPanel[0][0]="W";
							thisRectNum=1;
						}else {
							chessPanel[0][0]="B";
							thisRectNum=1;
						}
					}
					
					for(int k=0;k<8;k++) {
						
						if(k==1||k==0) {
							standard = chessPanel[i][j];
						}else if(k%2==0){
							if(chessPanel[i][j].equals("B")) {
								standard="W";
							}else {
								standard="B";
							}
						}else {
							standard = chessPanel[i][j];
						}
						//if~else end
						
						for(int l=0;l<8;l++) {
	//						System.out.println((i+k)+"행의 "+(l+j)+"열은 현재 "+chessPanel[i+k][j+l]+" 이고 기준은"+standard);
							if(k==0&&l==0) {
								continue;
							}
							else if(chessPanel[i+k][j+l].equals(standard)) {
	//							System.out.println("현재색깔과 기준이 같으니 다르게 칠합니다!");
								thisRectNum++;
							}
	//						System.out.println("현재색깔과 기준이 다르니 넘어갑니다!");
							if(standard.equals("W"))
								standard="B";
							else
								standard="W";
						}//for l end
					}//for k end 
					if(min>thisRectNum)
						min=thisRectNum;
					thisRectNum=0;
				}
			}//for j end
		}//for i end
		
		
		System.out.print(min);
	}//main() end
}//class end
