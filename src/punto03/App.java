package punto03;

import java.util.Iterator;

import listas.ListaSimple;
import listas.Nodo;

public class App {

	public static void main(String[] args) {
		ListaSimple<Integer> listica = new ListaSimple<>();

		listica.agregarFinal(2);
		listica.agregarFinal(5);
		listica.agregarFinal(9);
		listica.agregarFinal(4);

		eliminarNumeros(listica);

		Iterator<Integer> it = listica.iterator();
		while (it.hasNext()) {
			Integer numero = it.next();
			System.out.println(numero);
		}

	}

	public static void eliminarNumeros(ListaSimple<Integer> lista) {
		Nodo<Integer> puntero = lista.getNodoPrimero();
		while (puntero.getSiguienteNodo() != null) {
			if (puntero.getValorNodo() % 2 == 0) {
				Integer nodoABorrar = puntero.getValorNodo();

				/*
				 * Sin esto da una NullPointerException, dado que borra la referencia al que
				 * sigue, por lo cual lo pusé que se pase al siguiente y guarda el valor del
				 * nodo anterior que será borrado
				 */
				puntero = puntero.getSiguienteNodo();
				lista.eliminar(nodoABorrar);
			}
			puntero = puntero.getSiguienteNodo();
		}
		// Queda faltando un nodo, asi que se verifica acá.
		if (puntero.getValorNodo() % 2 == 0)
			lista.eliminar(puntero.getValorNodo());

	}
}
