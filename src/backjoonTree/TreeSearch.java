package backjoonTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class TreeSearch {
	
	static class Node{
		String value;
		Node parent, leftChild, rightChild;
		
		void preSearch(Node node) {
			System.out.print(node.value);
			if(node.leftChild!=null)
				preSearch(node.leftChild);
			if(node.rightChild!=null)
				preSearch(node.rightChild);
		}//preSearch() end
		
		void midSearch(Node node) {
			if(node.leftChild!=null)
				midSearch(node.leftChild);
			System.out.print(node.value);
			if(node.rightChild!=null)
				midSearch(node.rightChild);
		}//midSearch() end
		
		void postSearch(Node node) {
			if(node.leftChild!=null)
				postSearch(node.leftChild);
			if(node.rightChild!=null)
				postSearch(node.rightChild);
			System.out.print(node.value);
		}//postSearch() end
		
	}//Node class end 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		List<Node> nodeList = new ArrayList<Node>();
		
		while(T-- >0) {
			st = new StringTokenizer(br.readLine());
			
			String firstValue = st.nextToken();
			
			Node firstNode=null;
			for(Node node : nodeList) {
				if(node.value.equals(firstValue)) {
					firstNode=node;
					break;
				}//if end
			}//for end
			
			if(firstNode==null) {
				firstNode = new Node();
				firstNode.value=firstValue;
				nodeList.add(firstNode);
			}//if end
			
			for(int i=0;i<2;i++) {
				String nextValue = st.nextToken();
				
				Node nextNode = null;

				if(!nextValue.equals(".")){
					for(Node node : nodeList) {
						if(node.value.equals(nextValue)) {
							nextNode=node;
						}//if end
					}//for end
					if(nextNode==null) {
						nextNode = new Node();
						nextNode.value=nextValue;
						nodeList.add(nextNode);
					}//if end
				}//if end
				
				if(i==0) {
					firstNode.leftChild=nextNode;
				}else if(i==1) {
					firstNode.rightChild=nextNode;
				}//if~elseIf end

				if(nextNode!=null)
					nextNode.parent=firstNode;
			}//for end 
			
		}//while end
		
		Node node = nodeList.get(0);
		while(node.parent!=null) {
			node = node.parent;
		}//while end
		
		node.preSearch(node);
		System.out.println();
		node.midSearch(node);
		System.out.println();
		node.postSearch(node);
		
		br.close();
	}//main() end
}
