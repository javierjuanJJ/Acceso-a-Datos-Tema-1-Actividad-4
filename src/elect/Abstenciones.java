package elect;

import javax.xml.bind.annotation.XmlElement;

public class Abstenciones {
	@XmlElement(name = "cantidad")
	private int cantidad;
	@XmlElement(name = "porcentaje")
	private double porcentaje;

	public Abstenciones(int pcantidad, double pporcentaje) {
		super();
		cantidad = pcantidad;
		porcentaje = pporcentaje;
	}

	public Abstenciones() {
		super();
		cantidad = 0;
		porcentaje = 0.0;
	}

	public Abstenciones(Abstenciones votos) {
		super();
		cantidad = votos.getCantidad();
		porcentaje = votos.getPorcentaje();
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setPorcentaje(int pcantidad) {
		cantidad = pcantidad;
	}

	public void setCantidad(double pporcentaje) {
		porcentaje = pporcentaje;
	}

	public String toString() {

		String Texto_del_Objeto = "";
		Texto_del_Objeto = Texto_del_Objeto + "\nLos votos de las abstenciones son:\n";
		Texto_del_Objeto = Texto_del_Objeto + "La cantidad de votos es " + getCantidad() + "\n";
		Texto_del_Objeto = Texto_del_Objeto + "El porcentaje de votos es " + getPorcentaje() + "\n";


		return Texto_del_Objeto;

	}
}
