package br.com.codenation;

import java.util.*;

public class StatisticUtil {

	public static int average(int[] elements) {
		return ((int) Arrays.stream(elements).average().getAsDouble());
	}

	public static int mode(int[] elements) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < elements.length; i++) {
			if (map.containsKey(elements[i])) {
				map.put(elements[i], map.get(elements[i]) + 1);
			}else {
				map.put(elements[i], 1);
			}
		}
		TreeMap<Integer, Integer> reverse = new TreeMap<>();
		map.forEach((key, value) -> reverse.put(value, key));

		return reverse.get(reverse.lastKey());

	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int tamanho = elements.length;
		int meio = tamanho / 2;
		int mediana;
		if(tamanho % 2 == 0){
			mediana = ((elements[meio] + elements[meio - 1]) / 2);
		}else{
			mediana = elements[meio];
		}
		return mediana;
	}
}