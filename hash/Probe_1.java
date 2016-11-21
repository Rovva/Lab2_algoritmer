package hash;

import hash.NumberGenerator;

public class Probe_1 {
	
	NumberGenerator num;
	int arraySize;
	int[] HashTable;
	
	public Probe_1(int x, NumberGenerator num) {
		this.num = num;
		this.arraySize = x;
		this.HashTable = new int[arraySize];

	}
	
	public void insert(int x){
	
		int i = 0;
		while (i != arraySize){
			
			int v = hash(x + i);
			
			if (HashTable[v] == 0){
				HashTable[v] = x;
				return;
				
			} else {
				
				i++;
				
			}
			
		}
		
	}
	
	public int hash(int x) {
		
		return (x % arraySize);
		
		
	}
	
	public void getHash() {
		System.out.print("[");
		for (int i = 0; i < arraySize; i++){
			System.out.print(HashTable[i] + ", ");
		}
		System.out.print("]");
	}

}
