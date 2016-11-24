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
	int [] lastRehash;
	int nrRehash;
	int loadFactor;
	int nrInsertcollision;
	int longestChain;
	int currentChain;
	
	public HashProbe(int x, NumberGenerator num, int c) {
		this.num = num;
		this.arraySize = x;
		this.HashTable = new int[arraySize];
		up = 0;
		down = 0;
		this.c = c;
		this.lastRehash = new int[1];
		this.nrRehash = 0;

	}
	
	public void insert(int x){
	
		int i = 0;
		while (i != arraySize){
			
			int v = hash(x + i);
			
			if (HashTable[v] == 0){
				HashTable[v] = x;
				break;
				
			} else {
				
				i++;
				
			}
			
		}
		if(i > 0){
			currentChain++;
			nrInsertcollision++;
		} else {
			if(currentChain > longestChain){
				int diff = currentChain - longestChain;
				longestChain += diff; 
			}
			currentChain = 0;
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
					break;
					
				} else if (i != 0 && down > up) {
					
					up++;
					break;
					
				}
				break;
				
			
			} else {
				i++;
			}
			
			
		}
		if(i > 0){
			currentChain++;
			nrInsertcollision++;
		} else {
			if(currentChain > longestChain){
				int diff = currentChain - longestChain;
				longestChain += diff;
			}
			currentChain = 0;
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
					break;
				} else {

					
					for(int a = hash(x); a <= hash(x + c); a++){
						
						System.out.println("I AM IN THE FOR LOOP HOHOH");
						
						int y = HashTable[a];
						if (y != 0 && Math.abs(j - hash(y)) <= c ){
							System.out.println("SWITCHING a:" + HashTable[a] + " with j:" + x);
							HashTable[j] = y;
							HashTable[a] = x;
							break;
						}						
						
					}
					if(Arrays.equals(lastRehash, HashTable) == false){
						lastRehash = reHash(HashTable);
						continue;
					} else {
						System.out.println("ReHasing fail!");
						break;
					}
					

					
				}
				
			} else {
				
				i++;
				
			}
			
		}
		if(i > 0){
			currentChain++;
			nrInsertcollision++;
		} else {
			if(currentChain > longestChain){
				int diff = currentChain - longestChain;
				longestChain += diff;
				
			}
			currentChain = 0;
		}
		
		
	}
	
	public int[] reHash(int[] OldHashTable){
		
		System.out.println("REHASHING!!!!!!!!");
		
		int[] Old = Arrays.copyOf(OldHashTable, OldHashTable.length);
		
		this.HashTable = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			
			if (Old[i] != 0){
				insert2(Old[i]);
			}
			
		}
		nrRehash++;
		return Old;
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
		System.out.println("Load factor = " + loadFactor);
		System.out.println("C = " + c);
		System.out.println("Number of rehash = " + nrRehash);
		System.out.println("Number of insert with collision = " + nrInsertcollision);
		System.out.println("Longest collision chain = " + longestChain);
	}
	
	public void clearHash(){
		
		this.HashTable = new int[arraySize];
		this.up = 0;
		this.down = 0;
		this.lastRehash = new int[1];
		this.nrRehash = 0;
		this.loadFactor = 0;
		this.nrInsertcollision = 0;
		this.longestChain = 0;
	    this.currentChain = 0;
		
	}

}
