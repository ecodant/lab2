package listas;

public class ListaDobleCircular<T> {

	private NodoDoble<T> nodoPrimero;
	private NodoDoble<T> nodoUltimo;
	private int tamanio;

	public ListaDobleCircular() {
		nodoPrimero = null;
		nodoUltimo = null;
		tamanio = 0;
	}

	/**
	 * Agrega un nuevo nodo en la posici�n dada
	 * 
	 * @param valor
	 * @param posicion
	 */
	public void insertar(T valor, int posicion) {
		// Validar que la posición sea válida
		if (posicion < 0 || posicion > tamanio) {
			throw new RuntimeException("Posición inválida");
		}

		// Caso especial: insertar al inicio
		if (posicion == 0) {
			agregarInicio(valor);
			return;
		}

		// Caso especial: insertar al final
		if (posicion == tamanio) {
			agregarFinal(valor);
			return;
		}

		// Insertar en medio de la lista
		NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);
		NodoDoble<T> actual = nodoPrimero;

		// Navegar hasta la posición donde insertar
		for (int i = 0; i < posicion; i++) {
			actual = actual.getSiguienteNodo();
		}

		// Conectar el nuevo nodo
		NodoDoble<T> anterior = actual.getAnteriorNodo();

		anterior.setSiguienteNodo(nuevoNodo);
		nuevoNodo.setAnteriorNodo(anterior);

		nuevoNodo.setSiguienteNodo(actual);
		actual.setAnteriorNodo(nuevoNodo);

		tamanio++;
	}

	/**
	 * Busca y retorna la posici�n de un nodo que tenga el valor ingresado por
	 * par�metro
	 * 
	 * @param valor a buscar
	 * @return posici�n donde se encontr� el nodo
	 */
	public int buscar(T valor) {
		int cont = 0;
		int pos = -1;

		for (NodoDoble<T> aux = nodoPrimero; cont < tamanio; cont++, aux = aux.getSiguienteNodo()) {
			if (aux.getValorNodo().equals(valor)) {
				pos = cont;
			}
		}
		return pos;
	}

	public void agregarInicio(T valorNodo) {
		NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);

		if (estaVacia()) {
			// Si la lista está vacía, el nuevo nodo apunta a sí mismo
			nodoPrimero = nodoUltimo = nuevoNodo;
			nuevoNodo.setSiguienteNodo(nuevoNodo);
			nuevoNodo.setAnteriorNodo(nuevoNodo);
		} else {
			// Conectar el nuevo nodo al principio de la lista
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nuevoNodo.setAnteriorNodo(nodoUltimo);

			nodoPrimero.setAnteriorNodo(nuevoNodo);
			nodoUltimo.setSiguienteNodo(nuevoNodo);

			nodoPrimero = nuevoNodo;
		}
		tamanio++;
	}

	public void agregarFinal(T valorNodo) {
		NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);

		if (estaVacia()) {
			// Si la lista está vacía, el nuevo nodo apunta a sí mismo
			nodoPrimero = nodoUltimo = nuevoNodo;
			nuevoNodo.setSiguienteNodo(nuevoNodo);
			nuevoNodo.setAnteriorNodo(nuevoNodo);
		} else {
			// Esto conecta el nuevo nodo al final de la lista
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nuevoNodo.setAnteriorNodo(nodoUltimo);

			nodoUltimo.setSiguienteNodo(nuevoNodo);
			nodoPrimero.setAnteriorNodo(nuevoNodo);

			nodoUltimo = nuevoNodo;
		}
		tamanio++;
	}

	// Verificar si la lista esta vacia
	public boolean estaVacia() {
		return nodoPrimero == null && nodoUltimo == null;
	}

	/**
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirLista() {
		if (estaVacia()) {
			System.out.println("Lista vacía");
			return;
		}

		NodoDoble<T> aux = nodoPrimero;
		for (int i = 0; i < tamanio; i++) {
			System.out.print(aux.getValorNodo() + "\t");
			aux = aux.getSiguienteNodo();
		}
		System.out.println();
	}

}
