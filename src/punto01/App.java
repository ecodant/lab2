package punto01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import listas.ListaSimple;

public class App {

	public static void main(String[] args) {
		ListaSimple<Integer> listaSimple = new ListaSimple<Integer>();

		listaSimple.agregarInicio(2);
		listaSimple.agregarInicio(5);
		listaSimple.agregarInicio(6);
		listaSimple.agregarInicio(1);

		List<Integer> valoresDePosImpares = getNumerosPosImpares(listaSimple);

		// Saldria 2 y 6, asumiendo que la posicion 1 es el indice 0 y la 3 el indice 2
		for (Integer e : valoresDePosImpares) {
			System.out.println(e);
		}
	}

	public static <T> List<T> getNumerosPosImpares(ListaSimple<T> lista) {

		List<T> valoresEncontrados = new ArrayList<T>();
		Iterator<T> it = lista.iterator();
		int contadorPosicion = 0;

		while (it.hasNext()) {
			T value = it.next();
			if (contadorPosicion % 2 != 0)
				valoresEncontrados.add(value);
			contadorPosicion++;
		}
		return valoresEncontrados;
	}

}
