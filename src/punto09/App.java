package punto09;

import listas.ListaSimpleCircular;
import listas.Nodo;

public class App {

	public static void main(String[] args) {
		// Crear una nueva lista circular de enteros
		ListaSimpleCircular<Integer> lista = new ListaSimpleCircular<>();

		// Agregar algunos elementos iniciales
		lista.agregarInicio(10);
		lista.agregarfinal(20);
		lista.agregarfinal(30);

//        System.out.println("Lista inicial:");
		// Lista del virgen
		lista.imprimirLista();
		System.out.println("Tamaño: " + lista.getTamanio());

		// Prueba para el metodo insertar
		lista.insertar(5, 0);
		System.out.println("Después de insertar 5 en posición 0:");
		lista.imprimirLista();

		// Buscar elementos existentess
		Nodo<Integer> resultadoBusqueda = lista.buscar(Integer.valueOf(10));
		// Si encontro algo
		if (resultadoBusqueda != null) {
			System.out.println("El valor de la busquedad es: " + resultadoBusqueda.getValorNodo()
					+ "el siguiente nodo del resultado es : " + resultadoBusqueda.getSiguienteNodo().getValorNodo());
		}

	}

}