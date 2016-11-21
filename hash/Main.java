package hash;

import hash.NumberGenerator;
import hash.Probe_1;

public class Main {

	public static void main(String[] args) {
		
		int arraySize = 1000;
		NumberGenerator num = new NumberGenerator(arraySize);
		Probe_1 One = new Probe_1(arraySize, num);
		System.out.println(num.unsorted);
		
		
		for(int i = 0; i < arraySize; i++) {
			
			One.insert((int) num.unsorted.get(i));
			
			
			
		}
		One.getHash();
		

	}

}
