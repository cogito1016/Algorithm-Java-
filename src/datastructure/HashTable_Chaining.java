package datastructure;

public class HashTable_Chaining {
	
	static int hashSize = 3;
	
	public static int hashing(String str) {
		
		int key = 0;
		
		for(int i=0;i<str.length();i++) {
			
			key += str.charAt(i);
		}//for end 
		
		key = key%hashSize;
		System.out.println(key);
		return key;
	}
	
	public static void main(String[] args) {
		
		
		String[] hashTable = new String[hashSize];
		
		String test1 ="Hello";
		int key1 = hashing(test1);
		hashTable[key1]=test1;
		
		String test2 ="Mra";
		int key2 = hashing(test2);
		hashTable[key2]=test2;
		
		String test3 ="Hello";
		int key3 = hashing(test3);
		hashTable[key3]=test3;
		
		
		
		for(String item : hashTable) {
			System.out.println(item+" ");
		}
		
		
	}//main() end
}//HashTable_chaining class end