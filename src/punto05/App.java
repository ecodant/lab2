package punto05;

import listas.ListaSimple;
import listas.Nodo;

public class App {

	public static void main(String[] args) {

		ListaSimple<Integer> listica = new ListaSimple<Integer>();
		listica.agregarFinal(3);
		listica.agregarFinal(6);
		listica.agregarFinal(6);
		listica.agregarFinal(7);
		listica.agregarFinal(10);
		listica.agregarFinal(10);

		System.out.println("Aparece " + contarVeces(listica, 10));

	}

	public static <T> int contarVeces(ListaSimple<T> lista, T valor) {
		int contador = 0;

		Nodo<T> puntero = lista.getNodoPrimero();
		while (puntero.getSiguienteNodo() != null) {
			if (puntero.getValorNodo().equals(valor))
				contador++;
			puntero = puntero.getSiguienteNodo();
		}
		// De nuevo, verifica el nodo faltante.
		if (puntero.getValorNodo().equals(valor))
			contador++;
		puntero = puntero.getSiguienteNodo();

		return contador;
	}
}
