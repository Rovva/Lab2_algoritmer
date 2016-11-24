package hash;

import hash.NumberGenerator;

import java.util.Arrays;

import hash.HashProbe;

public class Main {

	public static void main(String[] args) {
		
		long time;
		long startTime;
		int arraySize = 100;
		int c = 10;
		
		
		NumberGenerator num = new NumberGenerator(arraySize);
		HashProbe One = new HashProbe(arraySize, num, c);
		System.out.println(num.unsorted);
		
		//INSERTION
		
		startTime = System.nanoTime();
		for(int i = 0; i < arraySize; i++) {
			
			One.insert((int) num.unsorted.get(i));

		}
		time = (long) ((System.nanoTime() - startTime));
		System.out.println(time + " ns");
		
		One.getHash();
		One.clearHash();
		System.out.println("");
		
		
		//INSERTION 1
		
		startTime = System.nanoTime();
		
		for(int i = 0; i < arraySize; i++) {
			One.insert1((int) num.unsorted.get(i));

		}
		
		time = (long) ((System.nanoTime() - startTime));
		System.out.println(time + " ns");
		
		One.getHash();
		One.clearHash();
		System.out.println("");
		
		//INSERTION 2
		
		startTime = System.nanoTime();
		
		for(int i = 0; i < arraySize; i++) {
			//One.getHash();	
			//System.out.println("");
			One.insert2((int) num.unsorted.get(i));
			
		}
		
		time = (long) ((System.nanoTime() - startTime));
		System.out.println(time + " ns");
		
		System.out.println("Load: " + (One.checkLoad() * 100) + "%");
		One.getHash();
		One.clearHash();
		
	}

}
