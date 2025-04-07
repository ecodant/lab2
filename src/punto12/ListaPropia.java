package punto12;

import listas.Nodo;

/* Con este tipo de Generico extendiendo de Number,
 *  se contempla garantizar que se pueden tener 
 *  varios tipos de numeros como float, int, etc
 *   dentro de la lista*/
public class ListaPropia<T extends Number> {
	private Nodo<T> nodoPrimero;
	private int tamanio;

	public ListaPropia() {
		this.nodoPrimero = null;
		this.tamanio = 0;
	}

	public void agregarFinal(T valor) {
		Nodo<T> nuevoNodo = new Nodo<>(valor);
		if (nodoPrimero == null) {
			nodoPrimero = nuevoNodo;
		} else {
			Nodo<T> actual = nodoPrimero;
			while (actual.getSiguienteNodo() != null) {
				actual = actual.getSiguienteNodo();
			}
			actual.setSiguienteNodo(nuevoNodo);
		}
		tamanio++;
	}

	public int getTamanio() {
		return tamanio;
	}

	public Nodo<T> getNodoPrimero() {
		return nodoPrimero;
	}

	/*
	 * A este punto ya se ha usado la misma logica para recorrer la lista, la unica
	 * diferencia es que sumamos los valores
	 */
	public double sumarElementos() {
		double suma = 0.0;
		Nodo<T> actual = nodoPrimero;
		while (actual != null) {
			suma += actual.getValorNodo().doubleValue();
			actual = actual.getSiguienteNodo();
		}
		return suma;
	}

	public double calcularMedia() {
		if (tamanio == 0)
			return 0.0;
		return sumarElementos() / tamanio;
	}

	// Iteracion de la lista y se calcula la desviacion con la formula
	public double calcularDesviacionEstandar() {
		if (tamanio <= 1)
			return 0.0;

		double media = calcularMedia();
		double sumaCuadrados = 0.0;
		Nodo<T> actual = nodoPrimero;

		while (actual != null) {
			double diferencia = actual.getValorNodo().doubleValue() - media;
			sumaCuadrados += diferencia * diferencia;
			actual = actual.getSiguienteNodo();
		}

		return Math.sqrt(sumaCuadrados / (tamanio - 1));
	}
}