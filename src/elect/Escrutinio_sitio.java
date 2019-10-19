package elect;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "escrutinio_sitio")

//@XmlRootElement(name = "bibliotecas", namespace = "biblios")
//@XmlType(propOrder = {"num_a_elegir","nombre_lugar","nombre_diputado","porciento_escrutado","nombre_sitio","convocatoria","ts","tipo_sitio","lista_votos","lista_resultados"})

public class Escrutinio_sitio implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlElement(name = "num_a_elegir")
	private int num_a_elegir;
	@XmlElement(name = "nombre_lugar")
	private String nombre_lugar;
	@XmlElement(name = "nombre_disputado")
	private String nombre_diputado;
	@XmlElement(name = "porciento_escrutado")
	private double porciento_escrutado;

	@XmlElement(name = "nombre_sitio")
	private String Nombre_sitio;
	private int convocatoria;
	private long ts;
	private int tipo_sitio;
	private Votos lista_votos;
	private Resultados lista_resultados;

	public Escrutinio_sitio(int pnum_a_elegir, String pnombre_lugar, String pnombre_diputado,
			double pporciento_escrutado, String pnombre_sitio, int pconvocatoria, long pts, int ptipo_sitio,
			Votos plista_votos, Resultados plista_resultados) {

		num_a_elegir = pnum_a_elegir;
		nombre_lugar = pnombre_lugar;
		nombre_diputado = pnombre_diputado;
		porciento_escrutado = pporciento_escrutado;
		Nombre_sitio = pnombre_sitio;
		convocatoria = pconvocatoria;
		ts = pts;
		tipo_sitio = ptipo_sitio;
		lista_votos = plista_votos;
		lista_resultados = plista_resultados;
	}

	public Escrutinio_sitio() {
		num_a_elegir = 0;
		nombre_lugar = "";
		nombre_diputado = "";
		porciento_escrutado = 0.0;
		Nombre_sitio = "";
		convocatoria = 0;
		ts = 0;
		tipo_sitio = 0;
		lista_votos = null;
		lista_resultados = null;
	}

	public Escrutinio_sitio(Escrutinio_sitio escrutinio) {
		num_a_elegir = escrutinio.getnum_a_elegir();
		nombre_lugar = escrutinio.getnombre_lugar();
		nombre_diputado = escrutinio.getnombre_diputado();
		porciento_escrutado = escrutinio.getporciento_escrutado();
		Nombre_sitio = escrutinio.getnombre_sitio();
		convocatoria = escrutinio.getconvocatoria();
		ts = escrutinio.getts();
		tipo_sitio = escrutinio.gettipo_sitio();
		lista_votos = escrutinio.getlista_votos();
		lista_resultados = escrutinio.getlista_resultados();
	}

	public int getnum_a_elegir() {

		return num_a_elegir;
	}

	public String getnombre_lugar() {

		return nombre_lugar;
	}

	public String getnombre_diputado() {

		return nombre_diputado;
	}

	public double getporciento_escrutado() {

		return porciento_escrutado;
	}

	public String getnombre_sitio() {

		return Nombre_sitio;
	}

	@XmlElement(name = "ts")
	public long getts() {

		return ts;
	}

	@XmlElement(name = "tipo_sitio")
	public int gettipo_sitio() {

		return tipo_sitio;
	}

	public int getconvocatoria() {

		return convocatoria;
	}

	@XmlElement(name = "votos")
	public Votos getlista_votos() {

		return lista_votos;
	}

	@XmlElement(name = "resultados")
	public Resultados getlista_resultados() {

		return lista_resultados;
	}

	public void setnombre_sitio(String pnombre_lugar) {

		nombre_lugar = pnombre_lugar;

	}

	public void setts(long pts) {

		ts = pts;

	}

	public void settipo_sitio(int ptipo_sitio) {

		tipo_sitio = ptipo_sitio;

	}

	public void setconvocatoria(int pconvocatoria) {

		convocatoria = pconvocatoria;
	}

	public void setlista_votos(Votos plista_votos) {
		lista_votos = plista_votos;
	}

	public void setlista_resultados(Resultados plista_resultados) {

		lista_resultados = plista_resultados;
	}

	public String toString() {
		String Texto_del_Objeto = "";

		Texto_del_Objeto = Texto_del_Objeto + "El numero a elegir es " + getnum_a_elegir() + "\n";
		Texto_del_Objeto = Texto_del_Objeto + "El nombre del lugar es " + getnombre_lugar() + "\n";
		Texto_del_Objeto = Texto_del_Objeto + "El nombre del diputado es " + getnombre_diputado() + "\n";
		Texto_del_Objeto = Texto_del_Objeto + "Hay un " + getporciento_escrutado() + " por ciento escrutado\n";
		Texto_del_Objeto = Texto_del_Objeto + "El nombre del sitio es " + getnombre_sitio() + "\n";
		Texto_del_Objeto = Texto_del_Objeto + "La convocatoria es el anyo " + getconvocatoria() + "\n";
		Texto_del_Objeto = Texto_del_Objeto + "El ts es " + getts() + "\n";
		Texto_del_Objeto = Texto_del_Objeto + "El tipo de sitio es " + gettipo_sitio() + "\n";

		Texto_del_Objeto = Texto_del_Objeto + "La lista de votos es " + "\n";
		Texto_del_Objeto = "\t" + Texto_del_Objeto + getlista_votos() + "\n";
		Texto_del_Objeto = Texto_del_Objeto + "La lista de resultados es " + "\n";
		Texto_del_Objeto = "\t" + Texto_del_Objeto + getlista_resultados() + "\n";

		return Texto_del_Objeto;
	}

}
