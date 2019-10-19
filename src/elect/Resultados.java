package elect;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Resultados {
	@XmlElement(name = "numero_partidos")
	private int Numero_partidos;
	@XmlElement(name = "partido")
	private ArrayList<Partido> partidos;

	public Resultados(int pnumero_partidos, ArrayList<Partido> ppartidos) {
		Numero_partidos = pnumero_partidos;
		partidos = ppartidos;
	}

	public Resultados() {
		Numero_partidos = 0;
		partidos = null;
	}

	public Resultados(Resultados resultados) {
		Numero_partidos = resultados.getnumero_partidos();
		partidos = resultados.getpartidos();
	}

	public ArrayList<Partido> getpartidos() {

		return partidos;
	}

	public int getnumero_partidos() {

		return Numero_partidos;
	}

	public void setnumero_partidos(int pnumero_partidos) {

		Numero_partidos = pnumero_partidos;
	}

	public void setnumero_partidos(ArrayList<Partido> ppartidos) {

		partidos = ppartidos;
	}

	public String toString() {

		String Texto_del_Objeto = "";
		int contador = 0;

		Texto_del_Objeto = "Los numeros de partidos de este escrutinio son " + getnumero_partidos() + "\n";

		for (contador = 0; contador < getpartidos().size(); contador++) {
			Texto_del_Objeto = Texto_del_Objeto + getpartidos().get(contador) + "\n";
		}

		return Texto_del_Objeto;
	}

}
