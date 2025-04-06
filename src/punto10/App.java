package punto10;

import listas.ListaSimple;
import listas.Nodo;

public class App {

	public static void main(String[] args) {
		ListaSimple<String> listica1 = new ListaSimple<>();
		ListaSimple<String> listica2 = new ListaSimple<String>();

		listica1.agregarFinal("Strin 1");
		listica1.agregarFinal("Strin 2");
		listica1.agregarFinal("Strin 3");
		listica2.agregarFinal("Strin 5");
		listica2.agregarFinal("Strin 5");
		listica2.agregarFinal("Strin 5");
		listica2.agregarFinal("Strin 5");
		listica2.agregarFinal("Strin 6");

		ListaSimple<String> listaUnidad = unirListas(listica1, listica2);

		// Lista unida
		Nodo<String> punteroNodo = listaUnidad.getNodoPrimero();

		while (punteroNodo != null) {
			System.out.println(punteroNodo.getValorNodo());
			punteroNodo = punteroNodo.getSiguienteNodo();
		}
	}

	public static <T> ListaSimple<T> unirListas(ListaSimple<T> lista1, ListaSimple<T> lista2) {
		ListaSimple<T> listaSalida = new ListaSimple<T>();

		Nodo<T> punteroLista1 = lista1.getNodoPrimero();
		Nodo<T> punteroLista2 = lista2.getNodoPrimero();

		int contador = 0;
		while (contador < lista1.getTamanio()) {
			listaSalida.agregarFinal(punteroLista1.getValorNodo());
			punteroLista1 = punteroLista1.getSiguienteNodo();
			contador++;
		}

		int contadorLista2 = 0;
		while (contadorLista2 < lista2.getTamanio()) {
			listaSalida.agregarFinal(punteroLista2.getValorNodo());
			punteroLista2 = punteroLista2.getSiguienteNodo();
			contadorLista2++;
		}

		return listaSalida;
	}

}
