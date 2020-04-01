package backjoonTimeComplexity;

import java.util.Scanner;

public class ChessPanel {
	
	public static void copyList(String[][] arr1, String[][] arr2,int width,int height) {
		
		for(int i=0; i<height;i++) {
			for(int j=0; j<width;j++) {
				
				String temp = arr2[i][j];
				arr1[i][j]= temp;
			}//for end
		}//for end
	}//copyList end

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int height = scan.nextInt();
		int width = scan.nextInt();

		String[][] chessPanel = new String[height][width];
		String[][] fakeChessPanel = new String[height][width];
		
		//자르기가능한 8X8의 정사각형의 수
		int possibleRectNum = 1+(height-8)*(width-8)+width-8+height-8;
		//각 정사각형마다의 바꿔야할 수를 기록해놓는 리스트
		int[] changeNumList = new int[possibleRectNum];
		
		//체스판 입력부
		for(int i=0;i<height;i++) {
			String oneLine = scan.next();
			for(int j=0;j<width;j++) {
				chessPanel[i][j]=String.valueOf(oneLine.charAt(j));
				fakeChessPanel[i][j]=String.valueOf(oneLine.charAt(j));
			}//for end
		}//for end
		
		
		String standard = "Empty";
		int thisRectNum =0;
		
		for(int i=0;i<height-7;i++) {
			for(int j=0;j<width-7;j++) {
			
				for(int k=0;k<8;k++) {
					if(k==0) {
						standard=fakeChessPanel[i][j];
						
					}else {
						standard=fakeChessPanel[i+k-1][j];
					}//if~else end
					
					for(int l=0;l<8;l++) {
						if(k==0&&l==0) {
							if(standard.equals("W")) {
								standard="B";
								fakeChessPanel[i+k][j+l]="B";}
							else {
								standard="W";
								fakeChessPanel[i+k][j+l]="W";}
							//if~else end
						}
						else if(fakeChessPanel[i+k][j+l].equals(standard)) {
							if(standard.equals("W")) {
								standard="B";
								fakeChessPanel[i+k][j+l]="B";}
							else {
								standard="W";
								fakeChessPanel[i+k][j+l]="W";}
							//if~else end
						}else {
							changeNumList[thisRectNum]++;
							if(standard.equals("W"))
								standard="B";
							else
								standard="W";
							//if~else end
						}//if~else end

					}//for l end
				}//for k end 
				thisRectNum++;
				copyList(fakeChessPanel,chessPanel,width,height);
			}//for j end
		}//for i end
		
		int min=64;
		
		for(int i=0;i<changeNumList.length;i++) {
			if(changeNumList[i]<min)
				min=changeNumList[i];
		}//for end
		
		System.out.print(min);
	}//main() end
}//class end
