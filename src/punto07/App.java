package punto07;

import java.util.Iterator;

import listas.ListaDoble;

public class App {

	public static void main(String[] args) {

		ListaDoble<String> lista = new ListaDoble<String>();

		lista.agregarFinal("String 1");
		lista.agregarFinal("String 3");
		lista.agregarFinal("String 2");
		lista.agregarFinal("String 4");
		lista.agregarFinal("String 5");
		// Se hizo su implementacion en la clase
		Iterator<String> it = lista.iterator();
		// Prueba del mismo.
		while (it.hasNext()) {

			String value = it.next();

			System.out.println(value);

		}
	}

}
