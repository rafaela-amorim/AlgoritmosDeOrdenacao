package nlogn;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {
	
	@SuppressWarnings("unchecked")
	public void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int meio = (rightIndex + leftIndex) / 2;
			
			mergeSort(array, leftIndex, meio);
			mergeSort(array, meio + 1, rightIndex);
			
			int tam1 = 0;		// tamanho do array left
			int tam2 = 0;		// tamanho do array right
			int k = 0;			// indice de saida
			
			T[] saida = (T[]) new Comparable[array.length];
			T[] left = (T[]) new Comparable[meio - leftIndex + 1];
			T[] right = (T[]) new Comparable[rightIndex - meio];
			
			for (int n = leftIndex; n <= rightIndex; n++) {
				if (n <= meio) 
					left[tam1++] = array[n];
				else 
					right[tam2++] = array[n];
			}
			
			int i = 0;		// indice de left
			int j = 0;		// indice de right
			
			while (i < tam1 && j < tam2) {
				if (left[i].compareTo(right[j]) < 0)
					saida[k++] = left[i++];
				else
					saida[k++] = right[j++];
			}
			
			if (i < tam1) {
				for (int l = i; l < tam1; l++)
					saida[k++] = left[l];
			}
			if (j < tam2) {
				for (int l = j; l < tam2; l++)
					saida[k++] = right[l];
			}
			
			for (int n = leftIndex; n <= rightIndex; n++) 
				array[n] = saida[n - leftIndex];
		}
	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[] {10,21,-24,12,-46,-99,52,76,133,-457,650,25,432,40,271,101,420};
		Integer[] copia = new Integer[array.length];
		for (int i = 0; i < array.length; i++)
			copia[i] = array[i];
		
		MergeSort<Integer> ms = new MergeSort<>();
		ms.mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
		Arrays.sort(copia);
		System.out.println(Arrays.toString(copia));
		
		boolean iguais = true;
		for (int i = 0; i < array.length; i++)
			if (copia[i] != array[i])	iguais = false;
		
		if (iguais)
			System.out.println("SAO IGUAIS");
		else
			System.out.println("nao sao iguais");
		
	}
}
