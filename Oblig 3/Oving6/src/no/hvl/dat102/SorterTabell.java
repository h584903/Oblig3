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
	
	public long selection(Integer[] data) {
		long start = System.nanoTime();
		for (int i = 0; i < data.length-1; i++) {
			for (int j = i; j < data.length; j++) {
				if (data[i] > data[j])
					swap(data, j, i);
			}
		}
		long finish = System.nanoTime();
		long elapsedTime = finish-start;
		return elapsedTime;
	}
	
	public long merge(Integer[] data) {
		long start = System.nanoTime();
		
		int length = data.length;
		
		if (length < 2) {
	        return 0;
	    }
	    int left = length / 2;
	    int right = length-left;
	    Integer[] leftData = new Integer[left];
	    Integer[] rightData = new Integer[right];

	    // Plasserer dataene i tabellene
	    for (int i = 0; i < left; i++) {
	        leftData[i] = data[i];
	    }
	    for (int i = left; i < length; i++) {
	        rightData[i - left] = data[i];
	    }
	    
	    // rekursivt kaller metoden på venstre og høyre siden
	    merge(leftData);
	    merge(rightData);
	    
	    
	    // samler sammen alt
	    int i = 0, j = 0, k = 0;
	    while (i < left && j < right) {
	        if (leftData[i] <= rightData[j]) {
	            data[k++] = leftData[i++];
	        }
	        else {
	            data[k++] = rightData[j++];
	        }
	    }
	    while (i < left) {
	        data[k++] = leftData[i++];
	    }
	    while (j < right) {
	        data[k++] = rightData[j++];
	    }
		
		long finish = System.nanoTime();
		long elapsedTime = finish-start;
		return elapsedTime;
	}
	
	
	public long insertions1(Integer[] data, int rounds) {
		System.out.println("Progress: ");
		long totalTime = 0;
		for (int i = 0; i < rounds; i++) {
			Integer[] temp = data.clone();
			totalTime =+ insertion1(temp);
			
			progress(i,rounds);
		}
		
		
		return totalTime;		
	}
	
	public long insertions2(Integer[] data, int rounds) {
		System.out.println("Progress: ");
		long totalTime = 0;
		for (int i = 0; i < rounds; i++) {
			Integer[] temp = data.clone();
			totalTime =+ insertion2(temp);
			
			progress(i,rounds);
		}
		
		
		return totalTime;
	}
	
	public static void progress(int round, int rounds) {
		float percent = round+1;
		percent = percent/rounds;
		percent = percent*100;
		int percentFinal = (int) percent;
		System.out.print(percentFinal + "%, ");
	}
	
}
