package punto13;

public class App {

	public static void main(String[] args) {
		Lista lista = new Lista();
		// Orden del ejemplo
//		lista.agregarAlFinal(9);
//		lista.agregarAlFinal(4);
//		lista.agregarAlFinal(6);
//		lista.agregarAlFinal(8);
//		lista.agregarAlFinal(4);
//		lista.agregarAlFinal(5);
//		lista.agregarAlFinal(4);
//		lista.agregarAlFinal(4);

		lista.agregarAlFinal(3);
		lista.agregarAlFinal(1);
		lista.agregarAlFinal(2);
		lista.agregarAlFinal(3);
		lista.agregarAlFinal(5);
		lista.agregarAlFinal(3);
		// Por lo que entendí se cuenta los movimientos del puntero a cada nodo
		// basicamente.
		int resultado = calcularDistancia(lista.getInicio(), 3, 0, 0);
		System.out.println("Distancia máxima es: " + resultado);
	}

	// Para este se lucho, pero como lo entiendo es de la siguiente manera...
	private static int calcularDistancia(NodoLista nodo, int clave, int distancia, int maximo) {
		// Base basico para validar que no hay más que recorrer
		if (nodo == null) {
			return maximo;
		}
		/*
		 * Si el valor del nodo actual es igual al de la clave que se busca entonces
		 * valida...
		 */
		if (nodo.dato == clave) {

			/*
			 * Con la distancia diferente de 0 se contempla que existe una ocurrencia
			 * anterior y se actualiza la distancia maxima
			 */
			if (distancia != 0) {
				if (distancia > maximo) {
					maximo = distancia;
				}
			}
			/*
			 * Si concindio pero es es 0 entonces por los menos esta a 1 de distancia y se
			 * llamada nuevamente para validar el siguiente y actualizar el maximo
			 */
			return calcularDistancia(nodo.siguiente, clave, 1, maximo);
		} else {
			// Si distancia no es 0, incrementar, de lo contrario mantener 0
			/*
			 * Si no hacen match el valor del nodo y la clave entonces se modifica la
			 * distancia igualmente, si no es 0 entonces aumenta en 1 unidad porque se
			 * movera el puntero al siguiente nodo, y si es 0 entonces la deja asi, y al
			 * final retornara o 0 o el valor modificado de la distancia
			 */
			int nuevaDistancia = (distancia != 0) ? distancia + 1 : 0;
			return calcularDistancia(nodo.siguiente, clave, nuevaDistancia, maximo);
		}
	}
}
