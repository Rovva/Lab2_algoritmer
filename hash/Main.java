package hash;

import hash.NumberGenerator;
import hash.Probe_1;

public class Main {

	public static void main(String[] args) {
		
		NumberGenerator num = new NumberGenerator(7);
		int arraySize = 6;
		Probe_1 One = new Probe_1(arraySize, num);

	}

}
