package punto02;

import listas.ListaSimple;
import listas.Nodo;

public class App {

	public static void main(String[] args) {
		ListaSimple<Persona> listica = new ListaSimple<Persona>();
		// Toma en cuenta la longitud de la cedula para determinar la lista de filtro
		Persona persona = new Persona("Oscar", 2392932);
		Persona persona2 = new Persona("Raul", 23434453);
		Persona persona3 = new Persona("Juan", 43506592);
		Persona persona4 = new Persona("Robinson", 34304032);

		listica.agregarFinal(persona);
		listica.agregarFinal(persona2);
		listica.agregarFinal(persona3);
		listica.agregarFinal(persona4);

		ListaSimple<Persona> listaFiltro = obtenerPersonasCedu(listica);
		Nodo<Persona> puntero = listaFiltro.getNodoPrimero();
		while (puntero.getSiguienteNodo() != null) {
			System.out.println(puntero.getValorNodo().getNombre());
			puntero = puntero.getSiguienteNodo();
		}

		System.out.println(puntero.getValorNodo().getNombre());
	}

	public static ListaSimple<Persona> obtenerPersonasCedu(ListaSimple<Persona> lista) {
		ListaSimple<Persona> resultado = new ListaSimple<>();

		Nodo<Persona> nodoPuntero = lista.getNodoPrimero();
		while (nodoPuntero.getSiguienteNodo() != null) {

			String cedula = String.valueOf(nodoPuntero.getValorNodo().getCedula());
			if (cedula.length() % 2 == 0) {
				resultado.agregarFinal(nodoPuntero.getValorNodo());
			}
			nodoPuntero = nodoPuntero.getSiguienteNodo();
		}
		// Falta el ultimo nodo, de ahi este codigo
		String cedula = String.valueOf(nodoPuntero.getValorNodo().getCedula());
		if (cedula.length() % 2 == 0) {
			resultado.agregarFinal(nodoPuntero.getValorNodo());
		}
		return resultado;
	}

}
