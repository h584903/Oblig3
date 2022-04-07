package no.hvl.dat102;

import no.hvl.dat102.SorterTabell;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int antall = 54000; // vi ser at 54000 tar cirka 5 sek
		int maxTall = 99999;
		
		long seed = 102420;
		
		int runder = 15;
		
		SorterTabell Sorter = new SorterTabell();
		
		Integer[] data = Sorter.createTable(antall, maxTall, seed);
		
		
		Sorter.first(data, antall);

		
		long gjennomsnittsTid = Sorter.insertions2(data, runder)/runder;
		System.out.println("\n\nGjennomsnittstiden ble: " + gjennomsnittsTid/1000000 + " ms");
		
		//Sorter.insertion2(data);

		
	}
}