package elect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "escrutinio_sitio")
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
	
	public String Buscar_por_nombre(String nombre) {
		String coincidencias = "";
		int contador = 0;

		for (contador = 0; contador < getlista_resultados().getpartidos().size(); contador++) {
			if (getlista_resultados().getpartidos().get(contador).getnombre().contains(nombre)) {
				coincidencias = coincidencias + getlista_resultados().getpartidos().get(contador);
			}
		}

		if (coincidencias.length() > 0) {
			coincidencias = "\n Se han encontrado resultados con el nombre " + nombre + " que son \n" + coincidencias;
		} else {
			coincidencias = "\n No se han encontrado resultados con el nombre " + nombre + "\n";
		}
		return coincidencias;
	}
	
	public String ver_informacion() {
		String respuesta = "";
		respuesta = respuesta + "El numero a elegir es " + getnum_a_elegir() + "\n";
		respuesta = respuesta + "El nombre del lugar es " + getnombre_lugar() + "\n";
		respuesta = respuesta + "El nombre del diputado es " + getnombre_diputado() + "\n";
		respuesta = respuesta + "Hay un " + getporciento_escrutado() + " por ciento escrutado\n";
		respuesta = respuesta + "El nombre del sitio es " + getnombre_sitio() + "\n";
		respuesta = respuesta + "La convocatoria es el anyo " + getconvocatoria() + "\n";
		respuesta = respuesta + "El ts es " + getts() + "\n";
		respuesta = respuesta + "El tipo de sitio es " + gettipo_sitio() + "\n";
		respuesta = respuesta + "La lista de votos es " + "\n";
		respuesta = respuesta + getlista_votos() + "\n";
		return respuesta;
	}

	public String Buscar_por_id(String id_a_buscar) {

		String coincidencias = "";
		int contador = 0;

		for (contador = 0; contador < getlista_resultados().getpartidos().size(); contador++) {
			if (getlista_resultados().getpartidos().get(contador).getid_partido() == Integer
					.parseInt(id_a_buscar)) {
				coincidencias = coincidencias + getlista_resultados().getpartidos().get(contador);
			}
		}

		if (coincidencias.length() > 0) {
			coincidencias = "\n Se han encontrado resultados con la id " + id_a_buscar + " que son \n" + coincidencias;
		} else {
			coincidencias = "\n No se han encontrado resultados con la id " + id_a_buscar;
		}
		return coincidencias;
	}
	
	public Escrutinio_sitio Cargar_xml(String parametro)
			throws JAXBException, IOException, MalformedURLException, Exception, FileNotFoundException {

		Escrutinio_sitio escrutinio = new Escrutinio_sitio();
		JAXBContext context = JAXBContext.newInstance(escrutinio.getClass());
		Unmarshaller um = context.createUnmarshaller();
		escrutinio = new Escrutinio_sitio((Escrutinio_sitio) um.unmarshal(new FileReader(new File(parametro))));

		return escrutinio;
	}
	
	public Escrutinio_sitio Pasar_pagina_web_a_archivo(String parametro)
			throws JAXBException, IOException, MalformedURLException, Exception, FileNotFoundException {
		
		URL url = new URL(parametro);
		Escrutinio_sitio escrutinio = new Escrutinio_sitio();
		JAXBContext context = JAXBContext.newInstance(escrutinio.getClass());
		Unmarshaller um = context.createUnmarshaller();
		escrutinio = new Escrutinio_sitio((Escrutinio_sitio) um.unmarshal(new InputStreamReader(url.openStream())));

		return escrutinio;
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
