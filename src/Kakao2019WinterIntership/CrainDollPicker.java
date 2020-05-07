package Kakao2019WinterIntership;

import java.util.Stack;

public class CrainDollPicker {


    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
       
        for(int i=0;i<moves.length;i++) {
        	int crainLoc = moves[i]-1; //크레인이 내려갈 위치 
        	
        	for(int a=0;a<board.length;a++) {
        		if(board[a][crainLoc]!=0) {
        			int thisDoll = board[a][crainLoc];
        			if(stack.isEmpty())
        				stack.push(thisDoll);
        			else {
        				int beforeDoll = stack.peek();
        				if(beforeDoll==thisDoll) {
        					stack.pop();
        					answer+=2;
        				}//if end
        				else
        					stack.add(thisDoll);
        			}//if end
        			board[a][crainLoc] = 0 ;
        			break;
        		}//if end 내려가는데 인형이 집힐 경우
        	}//for end board의 y만큼 반복
        }//for end 어느 위치로 움직여서 인형을 집을지 차례대로
        
        return answer;
    }
    
	public static void main(String[] args) {
		
		int[][] board = 
				{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}
						;
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(CrainDollPicker.solution(board, moves));
		
	}//main() end
}//class end