package punto08;

import listas.ListaDoble;
import listas.NodoDoble;
import punto02.Persona;

public class App {

	public static void main(String[] args) {
		ListaDoble<Persona> lista = new ListaDoble<>();

		// Mismo que el punto 2 de la simple

		Persona persona = new Persona("Oscar", 2392932);
		Persona persona2 = new Persona("Raul", 23434453);
		Persona persona3 = new Persona("Juan", 43506592);
		Persona persona4 = new Persona("Robinson", 34304032);

		lista.agregarFinal(persona);
		lista.agregarFinal(persona2);
		lista.agregarFinal(persona3);
		lista.agregarFinal(persona4);

		ListaDoble<Persona> listaFiltro = filtrarPersonasCedula(lista);
		NodoDoble<Persona> puntero = listaFiltro.getNodoPrimero();
		while (puntero.getSiguienteNodo() != null) {
			System.out.println(puntero.getValorNodo().getNombre());
			puntero = puntero.getSiguienteNodo();
		}

		System.out.println(puntero.getValorNodo().getNombre());
	}

	// Metodo similar al de simples, pero con dos punteros en aprovechando ambas
	// referencias
	public static ListaDoble<Persona> filtrarPersonasCedula(ListaDoble<Persona> lista) {
		NodoDoble<Persona> punteroIzq = lista.getNodoPrimero();
		NodoDoble<Persona> punteroDer = lista.getNodoUltimo();
		ListaDoble<Persona> resultado = new ListaDoble<>();

		while (punteroIzq != punteroDer && punteroIzq.getAnteriorNodo() != punteroDer) {
			String cedulaIzq = String.valueOf(punteroIzq.getValorNodo().getCedula());
			String cedulaDer = String.valueOf(punteroDer.getValorNodo().getCedula());

			if (cedulaIzq.length() % 2 == 0) {
				resultado.agregarFinal(punteroIzq.getValorNodo());
			}
			if (cedulaDer.length() % 2 == 0) {
				resultado.agregarFinal(punteroDer.getValorNodo());
			}

			punteroIzq = punteroIzq.getSiguienteNodo();
			punteroDer = punteroDer.getAnteriorNodo();
		}

		/*
		 * Hay un caso particular con esta forma, y es si se encuentran ambos punteros
		 * en el centro, por lo tanto
		 */
		if (punteroIzq == punteroDer) {
			String cedulaCentro = String.valueOf(punteroIzq.getValorNodo().getCedula());
			if (cedulaCentro.length() % 2 == 0) {
				resultado.agregarFinal(punteroIzq.getValorNodo());
			}
		}

		return resultado;
	}

}
