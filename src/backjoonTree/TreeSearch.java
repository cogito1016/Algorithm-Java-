package backjoonTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class TreeSearch {

	static class Tree{
		Node head;
		List<Node> list = new ArrayList<Node>();
		
		public void setHead(Node head) {
			this.head=head;
		}//setHead() end
		
		public Node findNode(String value) {
			Node result = null;
			
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			
			while(!stack.isEmpty()) {
				
				Node node = stack.pop();
				if(node.value.equals(value)) {
					result = node;
					break;
				}
				if(node.left!=null) {
					stack.add(node.left);
				}
				if(node.right!=null) {
					stack.add(node.right);
				}
			}//while end 

			if(result==null) {
				for(Node node : list) {
					if(node.value.equals(value)) {
						result=node;
						break;
					}//if end
				}//for end
				if(result==null) {
					result=new Node();
					result.value=value;
					list.add(result);	
				}//if end
			}//if end
			return result;
		}//findNode() end
		
		public void preSearch(Node node) {
			System.out.print(node.value);
			if(node.left!=null)
				preSearch(node.left);
			if(node.right!=null)
				preSearch(node.right);
		}//preSearch() end
		
		public void midSearch(Node node) {
			if(node.left!=null)
				midSearch(node.left);
			System.out.print(node.value);
			if(node.right!=null)
				midSearch(node.right);
		}//midSearch() end
		
		public void postSearch(Node node) {
			if(node.left!=null)
				postSearch(node.left);
			if(node.right!=null)
				postSearch(node.right);
			System.out.print(node.value);
		}//postSearch() end
	}
	
	static class Node{
		String value;
		Node left,right,parent;
		Node(){}
		Node(String value,Node left,Node right,Node parent){
			this.value=value;
			this.left=left;
			this.right=right;
			this.parent=parent;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Tree tree =new Tree();
		
		st = new StringTokenizer(br.readLine());
		Node head = new Node();
		head.value=st.nextToken();
		
		Node headLeft = new Node();
		headLeft.value = st.nextToken();
		headLeft.parent = head;
		
		Node headRight = new Node();
		headRight.value = st.nextToken();
		headRight.parent = head;
		
		head.left=headLeft;
		head.right=headRight;
		
		tree.setHead(head);
		
		
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String value = st.nextToken();
			Node newNode = tree.findNode(value);
			
			String leftS = st.nextToken();
			Node left = leftS.equals(".")? null : tree.findNode(leftS);
			String rightS = st.nextToken();
			Node right = rightS.equals(".")? null : tree.findNode(rightS);
			
			newNode.left=left;
			if(left!=null) {
				left.parent=newNode;
			}
			newNode.right=right;
			if(right!=null) {
				right.parent=newNode;
			}
		}//for end
		
		tree.preSearch(head);
		System.out.println();
		tree.midSearch(head);
		System.out.println();
		tree.postSearch(head);
		br.close();
	}//main() end
}
