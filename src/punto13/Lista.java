package punto13;

public class Lista {
	NodoLista inicio;

	public Lista() {
		inicio = null;
	}

	public void agregarAlFinal(int dato) {
		if (inicio == null) {
			inicio = new NodoLista(dato, null);
		} else {
			NodoLista actual = inicio;
			while (actual.siguiente != null) {
				actual = actual.siguiente;
			}
			actual.siguiente = new NodoLista(dato, null);
		}
	}

	public NodoLista getInicio() {
		return inicio;
	}
}
