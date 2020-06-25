package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class CoinTwo {
	
	static class Node{
		int count;
		int number;
		Node(int number, int count){
			this.count=count;
			this.number=number;
		}//cons end
	}//class end

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		
		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}//for end
		
		Stack<Node> stack = new Stack<Node>();
		stack.add(new Node(k,0));
		
		List<Integer> goal = new ArrayList<Integer>();
		
		while(!stack.isEmpty()) {
			
			Node thisNode = stack.pop();
			int thisNumber = thisNode.number;
			int thisCount = thisNode.count;
			
			if(thisNumber==0)
				continue;
			
			for(int i=0;i<n;i++) {
				if(thisNumber<coin[i])
					continue;
				
				int top = thisNumber/coin[i];
				int bottom = thisNumber%coin[i];
				
				if(bottom==0)
					goal.add(thisCount+top);
				else {
					stack.add(new Node(bottom,thisCount+top));
				}//if~else end
			}//for end
		}//while end
		
		if(goal.isEmpty())
			System.out.println(-1);
		else {
			Collections.sort(goal);
			System.out.println(goal.get(0));
		}
			
		
		
		
		
		
		
		br.close();
	}//main() end
}//class end