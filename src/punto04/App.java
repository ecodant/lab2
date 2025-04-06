package punto04;

import java.util.Iterator;

import listas.ListaSimple;
import listas.Nodo;

public class App {

	public static void main(String[] args) {
		ListaSimple<Integer> listaBasica = new ListaSimple<Integer>();

		listaBasica.agregarFinal(3);
		listaBasica.agregarFinal(6);
		listaBasica.agregarFinal(7);
		listaBasica.agregarFinal(10);

		ListaSimple<Integer> listaFiltrada = obtenerListaImpar(listaBasica);

		// Imprimir la lista Filtrada
		Nodo<Integer> puntero = listaFiltrada.getNodoPrimero();
		while (puntero.getSiguienteNodo() != null) {
			System.out.println(puntero.getValorNodo());
			puntero = puntero.getSiguienteNodo();
		}

		System.out.println(puntero.getValorNodo());
	}

	public static ListaSimple<Integer> obtenerListaImpar(ListaSimple<Integer> listaNormal) {
		Iterator<Integer> it = listaNormal.iterator();
		ListaSimple<Integer> listaResultado = new ListaSimple<Integer>();
		while (it.hasNext()) {
			int valueListaNormal = it.next();
			if (valueListaNormal % 2 != 0) {
				listaResultado.agregarFinal(valueListaNormal);
			}

		}
		return listaResultado;

	}

}
