package listas;

import java.util.Iterator;

/**
 * 
 * Definición de la clase lista Simple Circular de tipo Generics
 * 
 * @param <T>
 * 
 **/

public class ListaSimpleCircular<T> implements Iterable<T> {

	private Nodo<T> nodoPrimero;
	private Nodo<T> nodoUltimo;
	private int tamanio;

	public ListaSimpleCircular() {
		nodoPrimero = null;
		nodoUltimo = null;
		tamanio = 0;
	}

	// Metodos basicos

	// Agregar al inicio de la lista
	public void agregarInicio(T valorNodo) {
		Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

		if (estaVacia()) {
			nodoPrimero = nodoUltimo = nuevoNodo;
			nuevoNodo.setSiguienteNodo(nuevoNodo); // circular reference
		} else {
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nodoPrimero = nuevoNodo;
			nodoUltimo.setSiguienteNodo(nodoPrimero); // maintain circularity
		}
		tamanio++;
	}

	// Agregar al final de la lista
	public void agregarfinal(T valorNodo) {
		Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

		if (estaVacia()) {
			nodoPrimero = nodoUltimo = nuevoNodo;
			nuevoNodo.setSiguienteNodo(nuevoNodo); // circular reference
		} else {
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nodoUltimo.setSiguienteNodo(nuevoNodo);
			nodoUltimo = nuevoNodo;
		}
		tamanio++;
	}

	// Obtener Nodo el valor de un Nodo
	public T obtenerValorNodo(int indice) {
		if (indiceValido(indice)) {
			Nodo<T> nodoTemporal = nodoPrimero;
			for (int i = 0; i < indice; i++) {
				nodoTemporal = nodoTemporal.getSiguienteNodo();
			}
			return nodoTemporal.getValorNodo();
		}
		return null;
	}

	// Verificar si indice es valido
	private boolean indiceValido(int indice) {
		return indice >= 0 && indice < tamanio;
	}

	// Verificar si la lista esta vacia
	public boolean estaVacia() {
		return nodoPrimero == null;
	}

	/**
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirLista() {
		if (estaVacia()) {
			System.out.println("Lista vacía");
			return;
		}

		Nodo<T> aux = nodoPrimero;
		int count = 0;

		// Print all elements once to avoid infinite loop
		while (count < tamanio) {
			System.out.print(aux.getValorNodo() + "\t");
			aux = aux.getSiguienteNodo();
			count++;
		}
		System.out.println();
	}

	// Eliminar dado el valor de un nodo
	public T eliminar(T dato) {
		if (estaVacia()) {
			throw new RuntimeException("Lista vacía");
		}

		Nodo<T> actual = nodoPrimero;
		Nodo<T> anterior = nodoUltimo;
		boolean encontrado = false;
		int count = 0;

		// Buscar el nodo a eliminar
		while (count < tamanio && !encontrado) {
			if (actual.getValorNodo().equals(dato)) {
				encontrado = true;
			} else {
				anterior = actual;
				actual = actual.getSiguienteNodo();
				count++;
			}
		}

		if (encontrado) {
			// Caso único nodo
			if (tamanio == 1) {
				nodoPrimero = nodoUltimo = null;
			}
			// Eliminar primer nodo
			else if (actual == nodoPrimero) {
				nodoPrimero = nodoPrimero.getSiguienteNodo();
				nodoUltimo.setSiguienteNodo(nodoPrimero);
			}
			// Eliminar último nodo
			else if (actual == nodoUltimo) {
				nodoUltimo = anterior;
				nodoUltimo.setSiguienteNodo(nodoPrimero);
			}
			// Eliminar nodo intermedio
			else {
				anterior.setSiguienteNodo(actual.getSiguienteNodo());
			}

			tamanio--;
			return dato;
		}
		throw new RuntimeException("El elemento no existe");
	}

	// Elimina el primer nodo de la lista
	public T eliminarPrimero() {
		if (estaVacia()) {
			throw new RuntimeException("Lista vacía");
		}

		T valor = nodoPrimero.getValorNodo();

		if (tamanio == 1) {
			nodoPrimero = nodoUltimo = null;
		} else {
			nodoPrimero = nodoPrimero.getSiguienteNodo();
			nodoUltimo.setSiguienteNodo(nodoPrimero);
		}

		tamanio--;
		return valor;
	}

	public T eliminarUltimo() {
		if (estaVacia()) {
			throw new RuntimeException("Lista vacía");
		}

		T valor = nodoUltimo.getValorNodo();

		if (tamanio == 1) {
			nodoPrimero = nodoUltimo = null;
		} else {
			Nodo<T> anterior = obtenerNodo(tamanio - 2);
			nodoUltimo = anterior;
			nodoUltimo.setSiguienteNodo(nodoPrimero);
		}

		tamanio--;
		return valor;
	}

	private Nodo<T> obtenerNodo(int indice) {
		if (indice >= 0 && indice < tamanio) {
			Nodo<T> nodo = nodoPrimero;
			for (int i = 0; i < indice; i++) {
				nodo = nodo.getSiguienteNodo();
			}
			return nodo;
		}
		return null;
	}

	public void modificarNodo(int indice, T nuevo) {
		if (indiceValido(indice)) {
			Nodo<T> nodo = obtenerNodo(indice);
			nodo.setValorNodo(nuevo);
		} else {
			throw new RuntimeException("Índice no válido");
		}
	}

	public int obtenerPosicionNodo(T dato) {
		if (estaVacia()) {
			return -1;
		}

		Nodo<T> aux = nodoPrimero;
		int posicion = 0;
		int count = 0;

		while (count < tamanio) {
			if (aux.getValorNodo().equals(dato)) {
				return posicion;
			}
			aux = aux.getSiguienteNodo();
			posicion++;
			count++;
		}

		return -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new IteradorListaSimple(nodoPrimero, tamanio);
	}

	protected class IteradorListaSimple implements Iterator<T> {
		private Nodo<T> nodo;
		private int posicion;
		private int totalElementos;
		private int contador;

		public IteradorListaSimple(Nodo<T> nodo, int totalElementos) {
			this.nodo = nodo;
			this.posicion = 0;
			this.totalElementos = totalElementos;
			this.contador = 0;
		}

		@Override
		public boolean hasNext() {
			return contador < totalElementos;
		}

		@Override
		public T next() {
			T valor = nodo.getValorNodo();
			nodo = nodo.getSiguienteNodo();
			posicion++;
			contador++;
			return valor;
		}

		public int getPosicion() {
			return posicion;
		}
	}

	public Nodo<T> getNodoPrimero() {
		return nodoPrimero;
	}

	public void setNodoPrimero(Nodo<T> nodoPrimero) {
		this.nodoPrimero = nodoPrimero;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
}
