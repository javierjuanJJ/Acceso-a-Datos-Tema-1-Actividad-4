package elect;

import javax.xml.bind.annotation.XmlElement;

public class Blancos {
	@XmlElement(name = "cantidad")
	private int cantidad;
	@XmlElement(name = "porcentaje")
	private double porcentaje;

	public Blancos(int pcantidad, double pporcentaje) {
		super();
		cantidad = pcantidad;
		porcentaje = pporcentaje;
	}

	public Blancos() {
		super();
		cantidad = 0;
		porcentaje = 0.0;
	}

	public Blancos(Blancos votos) {
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
		Texto_del_Objeto = Texto_del_Objeto + "\nLos votos blancos son:\n";
		Texto_del_Objeto = Texto_del_Objeto + "La cantidad de votos es " + getCantidad() + "\n";
		Texto_del_Objeto = Texto_del_Objeto + "El porcentaje de votos es " + getPorcentaje() + "\n";


		return Texto_del_Objeto;

	}
}
