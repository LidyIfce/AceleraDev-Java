package br.com.codenation.desafioexe;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {

		List<Integer> fibonacciList = new ArrayList<>();

		fibonacciList.add(0,0);
		fibonacciList.add(1,1);

		int i = 2;
        while (i < 350){
            Integer aux = fibonacciList.get(fibonacciList.size() - 1)
					+ fibonacciList.get(fibonacciList.size() - 2);
            fibonacciList.add(aux);

            i = aux;

        }
		return fibonacciList;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}