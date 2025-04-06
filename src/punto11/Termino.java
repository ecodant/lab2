package punto11;

public class Termino {
	int coeficiente;
	int exponenteX;

	public Termino(int coeficiente, int exponenteX) {
		this.coeficiente = coeficiente;
		this.exponenteX = exponenteX;
	}

	// Calcula el valor del termino con base en su exponente y coeficiente
	public double valorOperacion(double valorX) {
		return coeficiente * Math.pow(valorX, exponenteX);
	}

	public int getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(int coeficiente) {
		this.coeficiente = coeficiente;
	}

	public int getExponenteX() {
		return exponenteX;
	}

	public void setExponenteX(int exponenteX) {
		this.exponenteX = exponenteX;
	}

}
