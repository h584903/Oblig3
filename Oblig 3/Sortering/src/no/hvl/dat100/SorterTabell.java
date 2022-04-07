package no.hvl.dat100;

public class SorterTabell {
	// Byter om a[i] og a[j]. Antar at både i og j er lovlege indeksar i tabellen.
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Utvalgssortering / Plukksortering (DAT100) (Selction sort)
	// Sorterer dei første n elmementa i tabellen. Kanskje litt uvanlig
	// Kunne også utelatt n og sortert heile tabellen.

	public static <T extends Comparable<? super T>> void utvalgssortering(T[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			int minstePos = finnMinstePos(a, i, n - 1);
			swap(a, i, minstePos);
		}
	}
	
	private static <T extends Comparable<? super T>> int finnMinstePos(T[] a, int fra, int til) {
		int p = fra;
		for (int i = fra + 1; i <= til; i++) {
			if (a[i].compareTo(a[p]) < 0) {
				p = i;
			}
		}
		
		return p;
	}

	// Sortering ved innsetting (Insertion sort)
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int n) {
		sorteringVedInssetting(a, 0, n - 1);
	}

	// Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
		for (int i = start + 1; i <= slutt; i++) {
			T temp = a[i];
			int j = i - 1;
			boolean ferdig = false;
			while (!ferdig && j >= 0) {
				if (temp.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				} else {
					ferdig = true;
				}
			}
			a[j+1] = temp;
		}
		
	} 

}
