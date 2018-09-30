package nlogn;

import java.util.Arrays;

import util.Swap;

public class QuickSort<T extends Comparable<T>> {
	
	public void quickSort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex) {		// verificações importantíssimas!!
			int pivo = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivo - 1);
			quickSort(array, pivo + 1, rightIndex);
		}
	}
	
	private int partition(T[] array, int leftIndex, int rightIndex ) {
		int pivo = leftIndex;
		int k = leftIndex + 1;		// primeira pos. dps do pivo para colocar os menores
		
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(array[pivo]) < 0)
				Swap.swap(array, k++, i);
		}
		Swap.swap(array, pivo, --k);	// troca o pivo com o ultimo valor encontrado menor q ele
										// de modo q todos os val antes do pivo sao menores e o resto maiores
		return k;
	}
	
	
	public static void main(String[] args) {
		//Integer[] array = new Integer[] {10,21,24,12,46,99,52,76,133,457,650,25,432,40,271,101,420};
		Integer[] array = new Integer[] {10,21,-24,12,-46,-99,52,76,133,-457,650,25,432,40,271,101,420};
		QuickSort<Integer> qs = new QuickSort<>();
		qs.quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
