package hash;

import hash.NumberGenerator;

import java.util.Arrays;

import hash.HashProbe;

public class Main {

	public static void main(String[] args) {
		
		
		long time;
		long startTime;


		int t = 10;
		
		for(int u = 2; u <= 5000; u += 2){
			int c = u;
			long tottime = 0;
			long tottime1 = 0;
			long tottime1_2 = 0;
			long tottime1_3 = 0;
			long tottime2 = 0;
			long tottime2_2 = 0;
			double totfact = 0;
			double totfact_2 = 0;
			int totprobe = 0;
			int totprobe1 = 0;
			int totprobe1_2 = 0;
			int totprobe1_3 = 0;
			int totprobe2 = 0;
			int totprobe2_2 = 0;
			int totrehash = 0;
			int totrehash_2 = 0;
			int totcollision = 0;
			int totcollision1 = 0;
			int totcollision1_2 = 0;
			int totcollision1_3 = 0;
			int totcollision2 = 0;
			int totcollision2_2 = 0;
			int totchain = 0;
			int totchain1 = 0;
			int totchain1_2 = 0;
			int totchain1_3 = 0;
			int totchain2 = 0;
			int totchain2_2 = 0;
			int arraySize = 10000;
			
			
			
			System.out.println("");
			System.out.println("-----------");
			System.out.println("ArraySize: " + arraySize);
			System.out.println("c: " + c);
			System.out.println("-----------");
			System.out.println("");

		

		for (int k = 0; k < t; k++){
			
		
		NumberGenerator num = new NumberGenerator(arraySize);
		HashProbe One = new HashProbe(arraySize, num, c);
		//System.out.println(num.unsorted);
		
		/*
		//INSERTION

		startTime = System.nanoTime();
		for(int i = 0; i < arraySize; i++) {
			
			One.insert((int) num.unsorted.get(i));

		}
		time = (long) ((System.nanoTime() - startTime));
		//System.out.println(time + " ns");
		tottime += time;
		
		totprobe += One.probes;
		totcollision += One.nrInsertcollision;
		totchain += One.longestChain;
		
		//One.getHash();
		One.clearHash();
		//System.out.println("");
		

		//System.out.println("-------------");
		
/*
		//INSERTION 1
		
		startTime = System.nanoTime();
		
		for(int i = 0; i < arraySize; i++) {
			One.insert1((int) num.unsorted.get(i));

		}
		
		time = (long) ((System.nanoTime() - startTime));
		//System.out.println(time + " ns");
		tottime1 += time;
		
		totprobe1 += One.probes;
		totcollision1 += One.nrInsertcollision;
		totchain1 += One.longestChain;
		
		//One.getHash();
		One.clearHash();
		
		//System.out.println("");
		//System.out.println("-------------");
		
		//INSERTION 1.2
		
				startTime = System.nanoTime();
				
				for(int i = 0; i < arraySize; i++) {
					One.insert1_2((int) num.unsorted.get(i));

				}
				
				time = (long) ((System.nanoTime() - startTime));
				//System.out.println(time + " ns");
				tottime1_2 += time;
				

				totprobe1_2 += One.probes;
				totcollision1_2 += One.nrInsertcollision;
				totchain1_2 += One.longestChain;
				
				//One.getHash();

				//System.out.print("[");
				
				//for(int i = 0; i < arraySize; i++) {
					//System.out.print(One.statusTable[i] + ", ");
				//}

				//System.out.print("]");
				//System.out.println();
				
				One.clearHash();
				
				//System.out.println("-------------");	
		
		
		//INSERTION 1.3
		
				startTime = System.nanoTime();
				
				for(int i = 0; i < arraySize; i++) {
					One.insert1_3((int) num.unsorted.get(i));

				}
				
				time = (long) ((System.nanoTime() - startTime));
				//System.out.println(time + " ns");
				tottime1_3 += time;
				

				totprobe1_3 += One.probes;
				totcollision1_3 += One.nrInsertcollision;
				totchain1_3 += One.longestChain;
				
				//One.getHash();

				//System.out.print("[");
				
				//for(int i = 0; i < arraySize; i++) {
					//System.out.print(One.statusTable[i] + ", ");
				//}

				//System.out.print("]");
				//System.out.println();
				
				One.clearHash();
				
				//System.out.println("-------------");
				

		*/
/*
		//INSERTION 2

		startTime = System.nanoTime();
		
		for(int i = 0; i < arraySize; i++) {
			//One.getHash();	
			//System.out.println("");
			One.insert2((int) num.unsorted.get(i));
			One.curRehash = 0;
			
		}
		
		time = (long) ((System.nanoTime() - startTime));
		//System.out.println(time + " ns");
		tottime2 += time;
		
		totfact += One.checkLoad();
		totrehash += One.nrRehash;
		totprobe2 += One.probes;
		totcollision2 += One.nrInsertcollision;
		totchain2 += One.longestChain;
		
		//System.out.println("Load: " + (One.checkLoad() * 100) + "%");
		//One.getHash();
		One.clearHash();

		

		//INSERTION 2.2
		
			startTime = System.nanoTime();
			
			for(int i = 0; i < arraySize; i++) {
				//One.getHash();	
				//System.out.println("");
				One.insert2_2((int) num.unsorted.get(i));
				One.curRehash = 0;
					
			}
				
			time = (long) ((System.nanoTime() - startTime));
			//System.out.println(time + " ns");
			tottime2_2 += time;
			totfact_2 += One.checkLoad();
			totrehash_2 += One.nrRehash;
			totprobe2_2 += One.probes;
			totcollision2_2 += One.nrInsertcollision;
			totchain2_2 += One.longestChain;
				
			//System.out.println("Load: " + (One.checkLoad() * 100) + "%");
			//One.getHash();
			One.clearHash();

			}
*/
		//INSERTION 2.3
		
		startTime = System.nanoTime();
		
		for(int i = 0; i < arraySize; i++) {
			//One.getHash();	
			//System.out.println("");
			One.insert2_3((int) num.unsorted.get(i));
			One.curRehash = 0;
				
		}
			
		time = (long) ((System.nanoTime() - startTime));
		//System.out.println(time + " ns");
		tottime2_2 += time;
		totfact_2 += One.checkLoad();
		totrehash_2 += One.nrRehash;
		totprobe2_2 += One.probes;
		totcollision2_2 += One.nrInsertcollision;
		totchain2_2 += One.longestChain;
			
		//System.out.println("Load: " + (One.checkLoad() * 100) + "%");
		//One.getHash();
		One.clearHash();

		}
/*
		System.out.println("-----------");
		System.out.println("Insert");
		System.out.println("-----------");
		System.out.println("Average time: " + (tottime / t)/1000000.0 + " milli seconds");
		System.out.println("Average Number of probes: " + (totprobe / t));
		System.out.println("Average Number of collisions: " + (totcollision / t));
		System.out.println("Average longest chain: " + (totchain / t));
		System.out.println("");

		System.out.println("-----------");
		System.out.println("Insert1");
		System.out.println("-----------");
		System.out.println("Average time1: " + (tottime1 / t)/1000000  + " milli seconds");
		System.out.println("Average Number of probes: " + (totprobe1 / t));
		System.out.println("Average Number of collisions: " + (totcollision1 / t));
		System.out.println("Average longest chain: " + (totchain1 / t));
		System.out.println("");
		
		System.out.println("-----------");
		System.out.println("Insert1.2");
		System.out.println("-----------");
		System.out.println("Average time1_2: " + (tottime1_2 /t)/1000000  + " milli seconds");
		System.out.println("Average Number of probes: " + (totprobe1_2 / t));
		System.out.println("Average Number of collisions: " + (totcollision1_2 / t));
		System.out.println("Average longest chain: " + (totchain1_2 / t));
		System.out.println("");

		
		System.out.println("-----------");
		System.out.println("Insert1.3");
		System.out.println("-----------");
		System.out.println("Average time1_3: " + (tottime1_3 /t)/1000000.0  + " milli seconds");
		System.out.println("Average Number of probes: " + (totprobe1_3 / t));
		System.out.println("Average Number of collisions: " + (totcollision1_3 / t));
		System.out.println("Average longest chain: " + (totchain1_3 / t));
		System.out.println("");


		System.out.println("-----------");
		System.out.println("Insert2");
		System.out.println("-----------");
		System.out.println("Average time2: " + (tottime2 / t)/1000000.0  + " milli seconds");
		System.out.println("Average Number of probes: " + (totprobe2 / t));
		System.out.println("Average Number of collisions: " + (totcollision2 / t));
		System.out.println("Average longest chain: " + (totchain2 / t));
		System.out.println("Average loadfactor: " + (totfact / t)*100 + "%");
		System.out.println("Average Number of ReHash: " + (totrehash / t));
		
*/
		System.out.println("-----------");
		System.out.println("Insert2.3");
		System.out.println("-----------");
		System.out.println("Average time2: " + (tottime2_2 / t)/1000000.0  + " milli seconds");
		System.out.println("Average Number of probes: " + (totprobe2_2 / t));
		System.out.println("Average Number of collisions: " + (totcollision2_2 / t));
		System.out.println("Average longest chain: " + (totchain2_2 / t));
		System.out.println("Average loadfactor: " + (totfact_2 / t)*100 + "%");
		System.out.println("Average Number of ReHash: " + (totrehash_2 / t));
		
		
		}
		
	}

}
