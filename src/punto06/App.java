package punto06;

import listas.ListaDoble;
import listas.NodoDoble;

public class App {

	public static void main(String[] args) {
		ListaDoble<String> listicaTest = new ListaDoble<String>();

		listicaTest.agregarFinal("String 1");
		listicaTest.agregarFinal("String 2");
		listicaTest.agregarFinal("String 3");
		listicaTest.agregarFinal("String 4");
		listicaTest.agregarFinal("String 5");

		imprimirHaciaAtras(listicaTest);
	}

	// Similar al la logica de recorrer el nodo, pero esta vez desde el ultimo
	public static <T> void imprimirHaciaAtras(ListaDoble<T> lista) {
		NodoDoble<T> aux = lista.getNodoUltimo();
		while (aux != null) {
			System.out.print(aux.getValorNodo() + "\t");
			aux = aux.getAnteriorNodo();
		}
		System.out.println();
	}

}
