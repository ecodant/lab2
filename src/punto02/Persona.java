package punto02;

public class Persona {
	private String name;
	private int cedula;

	public Persona(String name, int cedula) {
		this.name = name;
		this.cedula = cedula;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String name) {
		this.name = name;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

}
