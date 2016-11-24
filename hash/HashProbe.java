package hash;

import hash.NumberGenerator;
import java.math.*;
import java.util.Arrays;

public class HashProbe {
	
	NumberGenerator num;
	int arraySize;
	int[] HashTable;
	int up;
	int down;
	int c;
	int reHash;
	
	public HashProbe(int x, NumberGenerator num, int c) {
		this.num = num;
		this.arraySize = x;
		this.HashTable = new int[arraySize];
		up = 0;
		down = 0;
		this.c = c;
		this.reHash = 0;

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
	
	public void insert1(int x) {
		
		int i = 0;
		int v;
		while (i != arraySize){
			

			if (down <= up){
				v = hash(x + i);
			} else {
				v = hash(x - i);
			}
			
			if (HashTable[v] == 0){
				
				HashTable[v] = x;
				
				if (i != 0 && down <= up) {
					
					down++;
					return;
					
				} else if (i != 0 && down > up) {
					
					up++;
					return;
					
				}
				return;
				
			
			} else {
				i++;
			}
			
			
		}
		
		
		
	}
	
	public void insert2(int x){
		
		int i = 0;
		int j = 0;
		while (i != arraySize){
			
			j = hash(x + i);
			
			if (HashTable[j] == 0){
				
				if (Math.abs(j - hash(x)) <= c){
					HashTable[j] = x;
					return;
				} else {

					
					for(int a = hash(x); a <= hash(x + c); a++){
						
						System.out.println("I AM IN THE FOR LOOP HOHOH");
						
						int y = HashTable[a];
						if (Math.abs(j - hash(y)) <= c ){
							System.out.println("SWITCHING a:" + HashTable[a] + " with j:" + HashTable[j]);
							HashTable[j] = y;
							HashTable[a] = x;
							return;
						}						
						
					}
					if(reHash > 1){
						reHash(HashTable);
					} else {
						System.out.println("ReHasing fail!");
						return;
					}
					

					
				}
				
			} else {
				
				i++;
				
			}
			
		}
		
	}
	
	public void reHash(int[] OldHashTable){
		reHash++; 
		
		System.out.println("REHASHING!!!!!!!!");
		
		int[] Old = Arrays.copyOf(OldHashTable, OldHashTable.length);
		
		this.HashTable = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			
			if (Old[i] != 0){
				insert2(Old[i]);
			}
			
		}
		
		
		
	}
	
	public int hash(int x) {
		
		return Math.floorMod(x, arraySize);
		
		
	}
	
	public void getHash() {
		System.out.print("[");
		for (int i = 0; i < arraySize; i++){
			System.out.print(HashTable[i] + ", ");
		}
		System.out.print("]");
	}
	
	public void clearHash(){
		
		this.HashTable = new int[arraySize];
		
	}

}
