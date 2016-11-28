package hash;

import hash.NumberGenerator;
import java.math.*;
import java.util.Arrays;

public class HashProbe {
	
	NumberGenerator num;
	int arraySize;
	int[] HashTable;
	String [] statusTable; 
	int down1;
	int up1;
	int c;
	int [] lastRehash;
	int nrRehash;
	int nrInsertcollision;
	int longestChain;
	int currentChain;
	int probes;
	int [] lDown;
	int [] lUp;
	
	public HashProbe(int x, NumberGenerator num, int c) {
		this.num = num;
		this.arraySize = x;
		this.HashTable = new int[arraySize];
		this.statusTable = new String[arraySize];
		probes = 0;
		this.c = c;
		this.lastRehash = new int[1];
		this.nrRehash = 0;
		this.down1 = 0;
		this.up1 = 0;
		lDown = new int [arraySize];
		lUp = new int [arraySize];

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
			currentChain = i;
			nrInsertcollision++;
			probes += i;
			
			if(currentChain > longestChain){
				longestChain = currentChain;
			}

		}
		
	}
	
	public void insert1(int x) {
		
		
		int i = 0;
		int v;
		while (i != arraySize){
			

			if (down1 <= up1){
				v = hash(x + i);
			} else {
				v = hash(x - i);
			}
			
			if (HashTable[v] == 0){
				
				HashTable[v] = x;
				
				if (i != 0 && down1 <= up1) {
					
					down1++;
					break;
					
				} else if (i != 0 && down1 > up1) {
					
					up1++;
					break;
					
				}
				break;
				
			
			} else {
				i++;
			}
			
			
		}
		if(i > 0){
			currentChain = i;
			nrInsertcollision++;
			probes += i;
			
			if(currentChain > longestChain){
				longestChain = currentChain;
			}

		}
		
		
		
	}
	
	public void insert1_2(int x) {
		

		int up = 0;
		int down = 0;
		int i = 0;
		int v;
		while (i != arraySize){
			

			if (i == 1){
				
				for(int y = 0; y < arraySize; y++ ){
					if(HashTable[y] != 0 && hash(HashTable[y]) == hash(x)){
						if (statusTable[y] == "down"){
							down++;
						}
						else if (statusTable[y] == "up"){
							up++;
						}
					}
				}
				
			}

			if (down <= up){
				v = hash(x + i);
			} else {
				v = hash(x - i);
			}
			
			
			if (HashTable[v] == 0){
				
				HashTable[v] = x;
				
				
				if (i != 0 && down <= up) {
					
					statusTable[v] = "down";
					break;
					
				} else if (i != 0 && down > up) {
					
					statusTable[v] = "up";
					break;
					
				}
				statusTable[v] = "ok";
				break;
				
			
			} else {
				i++;
			}
			
			
		}
		if(i > 0){
			currentChain = i;
			nrInsertcollision++;
			probes += i;
			
			if(currentChain > longestChain){
				longestChain = currentChain;
			}

		}
		
		
		
	}
	
public void insert1_3(int x) {
		int down = 0;
		int up = 0;
		int i = 0;
		int v = hash(x);
		int hx = hash(x);
		while (i != arraySize){
			
			if (i == 1){
				down = lDown[hx];
				up = lUp[hx];
				if(down <= up){
					lDown[hx]++;
				} else {
					lUp[hx]++;
				}
			}
			
			if(down <= up){
				v = hash(x + i);
			} else {
				v = hash(x - i);
			}
			
			
			if (HashTable[v] == 0){
				
				HashTable[v] = x;
				break;
			
			} else {
				i++;
			}
			
			
		}
		if(i > 0){
			currentChain = i;
			nrInsertcollision++;
			probes += i;
			
			if(currentChain > longestChain){
				longestChain = currentChain;
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
					break;
				} else {

					
					for(int a = hash(x); a <= hash(x + c); a++){
						
						//System.out.println("I AM IN THE FOR LOOP HOHOH");
						
						int y = HashTable[a];
						if (y != 0 && Math.abs(j - hash(y)) <= c ){
							//System.out.println("SWITCHING a:" + HashTable[a] + " with j:" + x);
							HashTable[j] = y;
							HashTable[a] = x;
							break;
						}						
						
					}
					if(Arrays.equals(lastRehash, HashTable) == false){
						lastRehash = reHash(HashTable);
						continue;
					} else {
						//System.out.println("ReHasing fail!");
						break;
					}
					

					
				}
				
			} else {
				
				i++;
				
			}
			
		}
		
		if(i > 0){
			currentChain = i;
			nrInsertcollision++;
			probes += i;
			
			if(currentChain > longestChain){
				longestChain = currentChain;
			}

		}
		
		
	}
	
	public int[] reHash(int[] OldHashTable){
		
		//System.out.println("REHASHING!!!!!!!!");
		
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
		System.out.println();
		System.out.print("[");
		for (int i = 0; i < arraySize; i++){
			System.out.print(HashTable[i] + ", ");
		}
		System.out.print("]");
		System.out.println();
		System.out.println("C = " + c);
		System.out.println("Number of rehash = " + nrRehash);
		System.out.println("Number of insert with collision = " + nrInsertcollision);
		System.out.println("Longest collision chain = " + longestChain);
		System.out.println("Number of probes = " + probes);
	}
	
	public void clearHash(){
		
		this.HashTable = new int[arraySize];
		this.lastRehash = new int[1];
		this.nrRehash = 0;
		this.nrInsertcollision = 0;
		this.longestChain = 0;
	    this.currentChain = 0;
	    this.probes = 0;
	    this.down1 = 0;
	    this.up1 = 0;
		
	}
	
	public double checkLoad() {
		double load = 0.0;
		for(int i = 0; i < arraySize; i++) {
			if(HashTable[i] != 0) {
				load++;
			}
		}
		load = load / arraySize;
		return load;
	}

}
