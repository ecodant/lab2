package punto12;

import java.io.InputStream;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		/*
		 * El archivo numeros contiene los valores que se usaran como datos de entrada,
		 * puede modificar estos valores para efectos de prueba
		 */
		ListaPropia<Double> numeros = cargarNumerosTXT();

		if (numeros.getTamanio() == 0) {
			System.out.println("No hay con que trabajar");
			return;
		}

		double media = numeros.calcularMedia();
		double desviacion = numeros.calcularDesviacionEstandar();

		System.out.println("Resultados:");
		System.out.printf("Media: %.4f\n", media);
		System.out.printf("Desviación estándar: %.4f\n", desviacion);
	}

	public static ListaPropia<Double> cargarNumerosTXT() {
		ListaPropia<Double> lista = new ListaPropia<>();

		// Nunca lo habia usado, pero con este metodo se puede cargar el archivo si esta
		// en el package
		InputStream inputStream = App.class.getResourceAsStream("numeros.txt");

		if (inputStream == null) {
			System.out.println("Archivo de numeros es nullo");
			return lista;
		}

		try (Scanner scanner = new Scanner(inputStream)) {
			while (scanner.hasNextDouble()) {
				lista.agregarFinal(scanner.nextDouble());
			}
		} catch (Exception e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		return lista;
	}
}