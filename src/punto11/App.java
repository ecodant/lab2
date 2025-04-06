package punto11;

import java.util.Scanner;

import listas.ListaSimple;
import listas.Nodo;

public class App {

	public static void main(String[] args) {
		ListaSimple<Termino> polinomio = getPolinomio();

		// Para verificar que nos cuadre el resultado con x= 0.5
		// tabularPolinomio(polinomio, 0.5f);

		// Valores tabulados
		for (double x = 0.0; x <= 5.0; x += 0.5) {
			double resultado = tabularPolinomio(polinomio, x);

			System.out.printf("P(%.1f) = %.4f\n", x, resultado);
		}
	}

	public static ListaSimple<Termino> getPolinomio() {
		ListaSimple<Termino> polinomio = new ListaSimple<Termino>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el número de términos del polinomio:");
		int numTerminos = scanner.nextInt();

		for (int i = 0; i < numTerminos; i++) {
			System.out.println("Término " + (i + 1) + ":");
			System.out.print("Coeficiente: ");
			int coeficiente = scanner.nextInt();
			System.out.print("Exponente: ");
			int exponente = scanner.nextInt();

			polinomio.agregarFinal(new Termino(coeficiente, exponente));
		}

		return polinomio;
	}

	public static double tabularPolinomio(ListaSimple<Termino> polinomio, double valorX) {

		double resultado = 0.0;
		Nodo<Termino> puntero = polinomio.getNodoPrimero();
		while (puntero != null) {
			Termino termino = puntero.getValorNodo();
			resultado += termino.valorOperacion(valorX);
//			System.out.println("Valorr op " + resultado);
			puntero = puntero.getSiguienteNodo();
		}
		return resultado;

	}
}