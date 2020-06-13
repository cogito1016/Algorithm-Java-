package backjoonSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class LocationSort {
	
	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//Node end

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Node[] list = new Node[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}//for end
		
		Arrays.sort(list,new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.y>o2.y)
					return 1;
				else if(o1.y<o2.y){
					return -1;
				}else {
					if(o1.x>o2.x)
						return 1;
				}
				return -1;
			}//
		});//
		
		for(Node node : list) {
			System.out.println(node.y+" "+node.x);
		}//for end
		
		br.close();
	}//main() end
	
}//cllass end