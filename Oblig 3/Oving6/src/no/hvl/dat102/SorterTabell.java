package no.hvl.dat102;

import java.util.Random;

public class SorterTabell {
	
	public <T> void swap(Integer[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] =  temp;
	}
	
	// lager en tilfeldig tabell med et seed
	public Integer[] createTable(int antall, int maxTall, long seed) {
		Random generator = new Random(seed);
		
		Integer[] data = new Integer[antall];
		for (int i=0; i<antall; i++)
			data[i] = generator.nextInt(maxTall);
		
		return data;
	}
	
	// sorterer det første tallet
	public void first(Integer[] data, int antall) {
		int i = antall-1; int key = antall-1;
		while(i > -1) {
			if (data[i] < data[key]) {
				key = i;
			}
			i--;
		}
		swap(data,0,key);
	}
	// Sortering ved innsetting (Insertion sort)
	public long insertion1(Integer[] data) {
		long start = System.nanoTime();
		if (data.length <= 1) {
			return 0;
		}
		
		int n = data.length;
		for (int j = 1; j<n; j++) {
			//System.out.println("første loop");
			
			for(int i = j; i>0; i--) {
				//System.out.println("Andre loop iterasjon: " + i);
				int key = data[i];
				if (i > 0 && key < data[i-1]) {
					//System.out.println("SWAP");
					swap(data, i, i-1);
				}
			}
			
		}
		long finish = System.nanoTime();
		
		long elapsedTime = finish - start;
		return elapsedTime;
	}
	
	public long insertion2(Integer[] data) {
		long start = System.nanoTime();
		if (data.length <= 1) {
			return 0;
		}
		int n = data.length;
		
		
		for (int j = 1; j<n-1; j++) {
			//System.out.println("første loop");
			
			for(int i = j; i>0; i--) {
				//System.out.println("Andre loop iterasjon: " + i);
			
				int key1 = i; int key2 = i+1;
				if (data[key1] > data[key2]) {
					swap(data,key1,key2);
				}
					
				// sjekker om key2 det største datasettet er mindre en dataen under
				// Hvis ja flyttes key1 og key2 fram 
				if (i > 1 && data[key2] < data[i-1]) {
					//System.out.println("SWAP");
					swap(data, key2, i-1);
					swap(data, key2, key1);
				}else if (i > 0 && data[key1] < data[i-1]) {
					swap(data, key1, i-1);
				}
			}
			
		}
		
		
		
		long finish =  System.nanoTime();
		long elapsedTime = finish - start;
		return elapsedTime;
	}
	
	public long insertions1(Integer[] data, int rounds) {
		System.out.println("Progress: ");
		long totalTime = 0;
		for (int i = 0; i < rounds; i++) {
			Integer[] temp = data.clone();
			totalTime =+ insertion1(temp);
			
			float percent = i+1;
			percent = percent/rounds;
			percent = percent*100;
			int percentFinal = (int) percent;
			System.out.print(percentFinal + "%, ");
		}
		
		
		return totalTime;		
	}
	
	public long insertions2(Integer[] data, int rounds) {
		System.out.println("Progress: ");
		long totalTime = 0;
		for (int i = 0; i < rounds; i++) {
			Integer[] temp = data.clone();
			totalTime =+ insertion2(temp);
			
			float percent = i+1;
			percent = percent/rounds;
			percent = percent*100;
			int percentFinal = (int) percent;
			System.out.print(percentFinal + "%, ");
		}
		
		
		return totalTime;
	}
}
