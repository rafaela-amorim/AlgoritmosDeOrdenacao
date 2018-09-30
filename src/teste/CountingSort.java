package teste;

import java.util.Arrays;

public class CountingSort {
	
	public static void countingSort(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] saida = new Integer[array.length];
		int max = array[leftIndex];
		int min = array[leftIndex];
		
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] < min) min = array[i];
			if (array[i] > max) max = array[i];
		}
		
		int[] count = new int[max - min + 1];
		
		for (int i = leftIndex; i <= rightIndex; i++)
			count[array[i] - min]++;
		
		for (int i = 1; i <= max - min; i++)
			count[i] += count[i - 1];
		
		for (int i = rightIndex; i >= leftIndex; i--) 
			saida[--count[array[i] - min]] = array[i];
		
		for (int i = leftIndex; i <= rightIndex; i++)
			array[i] = saida[i - leftIndex];
	} 
	
	public static void main(String[] args) {
		Integer[] array = new Integer[] {10,21,-24,12,-46,-99,52,76,133,-457,650,25,432,40,271,101,420};
		CountingSort.countingSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
