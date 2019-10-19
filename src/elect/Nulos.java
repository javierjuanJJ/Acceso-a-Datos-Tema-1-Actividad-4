package elect;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Usuario
 */
public class Nulos {
	@XmlElement(name = "cantidad")
	private int cantidad;
	@XmlElement(name = "porcentaje")
	private double porcentaje;

	public Nulos(int pcantidad, double pporcentaje) {
		cantidad = pcantidad;
		porcentaje = pporcentaje;
	}

	public Nulos() {
		cantidad = 0;
		porcentaje = 0.0;
	}

	public Nulos(Nulos votos) {
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
		Texto_del_Objeto = Texto_del_Objeto + "\nLos votos nulos son:\n";
		Texto_del_Objeto = Texto_del_Objeto + "La cantidad de votos es " + getCantidad() + "\n";
		Texto_del_Objeto = Texto_del_Objeto + "El porcentaje de votos es " + getPorcentaje() + "\n";


		return Texto_del_Objeto;

	}
}
