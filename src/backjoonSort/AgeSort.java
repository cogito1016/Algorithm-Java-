package backjoonSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AgeSort {
	
	static class Person implements Comparable<Person>{
		String name;
		int age;
		int register;
		
		public Person(int age,String name,int register) {
			this.name=name;
			this.age=age;
			this.register=register;
		}//cons end
		
		@Override
		public int compareTo(Person o) {
			
			if(this.age > o.age) {
				return 1;
			}else if(this.age == o.age) {
				if(this.register > o.register)
					return 1;
			}//if~elseIf end
			
			return -1;
		}//compareTo() end
	}//class Person end
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Person[] list = new Person[N]; 
		
		for(int i=0;i<N;i++) {	
			st = new StringTokenizer(br.readLine());
			list[i] = new Person(Integer.parseInt(st.nextToken()),st.nextToken(),i);
		}//for end 
		
		Arrays.sort(list);
		
		for(Person item : list) {
			System.out.println(item.age+" "+item.name);
		}//for end
		
		br.close();
	}//main() end
}//class end