package elect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class elecciones {

	static final String kf = "-f";
	static final String ku = "-u";
	static final String kn = "-n";
	static final String ki = "-i";
	static final String fichero_temporal = "xml.xml";
	static final String url_defecto = "https://rsl00.epimg.net/elecciones/2019/generales/congreso/index.xml2";

	public static void main(String[] args) {

		try {
			String parametro = "";
			String parametro2 = "";
			String parametro3 = "";
			String parametro4 = "";
			String resultado = "";
			parametro = Hay(kf, args);
			parametro2 = Hay(ku, args);
			parametro3 = Hay(kn, args);
			parametro4 = Hay(ki, args);
			Escrutinio_sitio escrutinio = null;
			if (Comprobar(args)) {
				if (parametro != "no") {
					escrutinio = Cargar_xml(parametro);

				} else if (parametro2 != "no") {
					Pasar_pagina_web_a_archivo(parametro2);
					escrutinio = Cargar_xml(fichero_temporal);

				} else {
					Pasar_pagina_web_a_archivo(url_defecto);
					escrutinio = Cargar_xml(fichero_temporal);
				}
				resultado = ver_informacion(escrutinio);
				if (parametro3 != "no") {
					resultado = resultado + Buscar_por_nombre(escrutinio, parametro3);
				} else if (parametro4 != "no") {
					resultado = resultado + Buscar_por_id(escrutinio, parametro4);

				} else {
					resultado = escrutinio.toString();
				}
			} else {
				resultado = "Error en la forma de escribir el comando. \nLa forma correcta de escribir el comando es con los parametros:\n"
						+ kn + " para los ficheros," + ki + " para buscar la id " + kf
						+ " para buscar por nombre del partido y " + ku + " para buscar por url de internet\n"
						+ "\n 1.- java -jar elecciones.jar\n" + "\n 2.- java -jar elecciones.jar -u " + url_defecto
						+ " \n" + "\n 3.- java -jar elecciones.jar -u " + url_defecto + " -i 2 \n"
						+ "\n 4.- java -jar elecciones.jar -u " + url_defecto + " -n PSOE \n"
						+ "\n 5.- java -jar elecciones.jar -f " + "resultados28A-generales.xml" + " \n"
						+ "\n 6.- java -jar elecciones.jar -f " + "resultados28A-generales.xml" + "-i 2 \n"
						+ "\n 7.- java -jar elecciones.jar -f " + "resultados28A-generales.xml" + "-n PSOE \n";
			}

			System.out.println(resultado);

		}

		catch (FileNotFoundException ex) {
			System.err.println("El fichero no existe" + ex.getMessage());
		} 
		catch (JAXBException ex) {
			System.err.println("Problemas durante la lectura/escritura del archivo xml " + ex.getMessage());
		} 
		catch (MalformedURLException e) {
			System.err.println("URL con formato equivocada " + e.getMessage());
		} 
		catch (IOException e) {
			System.err.println("Error de entrada/salida " + e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Error no identificado " + e.getMessage());
		}

	}

	private static String ver_informacion(Escrutinio_sitio escrutinio) {
		String respuesta = "";
		respuesta = respuesta + "El numero a elegir es " + escrutinio.getnum_a_elegir() + "\n";
		respuesta = respuesta + "El nombre del lugar es " + escrutinio.getnombre_lugar() + "\n";
		respuesta = respuesta + "El nombre del diputado es " + escrutinio.getnombre_diputado() + "\n";
		respuesta = respuesta + "Hay un " + escrutinio.getporciento_escrutado() + " por ciento escrutado\n";
		respuesta = respuesta + "El nombre del sitio es " + escrutinio.getnombre_sitio() + "\n";
		respuesta = respuesta + "La convocatoria es el anyo " + escrutinio.getconvocatoria() + "\n";
		respuesta = respuesta + "El ts es " + escrutinio.getts() + "\n";
		respuesta = respuesta + "El tipo de sitio es " + escrutinio.gettipo_sitio() + "\n";
		respuesta = respuesta + "La lista de votos es " + "\n";
		respuesta = respuesta + escrutinio.getlista_votos() + "\n";
		return respuesta;
	}

	private static String Buscar_por_nombre(Escrutinio_sitio escrutinio, String nombre) {
		String coincidencias = "";
		int contador = 0;

		for (contador = 0; contador < escrutinio.getlista_resultados().getpartidos().size(); contador++) {
			if (escrutinio.getlista_resultados().getpartidos().get(contador).getnombre().contains(nombre)) {
				coincidencias = coincidencias + escrutinio.getlista_resultados().getpartidos().get(contador);
			}
		}

		if (coincidencias.length() > 0) {
			coincidencias = "\n Se han encontrado resultados con el nombre " + nombre + " que son \n" + coincidencias;
		} else {
			coincidencias = "\n No se han encontrado resultados con el nombre " + nombre + "\n";
		}

		return coincidencias;
	}

	private static String Buscar_por_id(Escrutinio_sitio escrutinio, String id_a_buscar) {

		String coincidencias = "";
		int contador = 0;

		for (contador = 0; contador < escrutinio.getlista_resultados().getpartidos().size(); contador++) {
			if (escrutinio.getlista_resultados().getpartidos().get(contador).getid_partido() == Integer
					.parseInt(id_a_buscar)) {
				coincidencias = coincidencias + escrutinio.getlista_resultados().getpartidos().get(contador);
			}
		}

		if (coincidencias.length() > 0) {
			coincidencias = "\n Se han encontrado resultados con la id " + id_a_buscar + " que son \n" + coincidencias;
		} else {
			coincidencias = "\n No se han encontrado resultados con la id " + id_a_buscar;
		}

		return coincidencias;

	}

	private static Escrutinio_sitio Cargar_xml(String parametro)
			throws JAXBException, IOException, MalformedURLException, Exception, FileNotFoundException {

		Escrutinio_sitio escrutinio = new Escrutinio_sitio();
		JAXBContext context = JAXBContext.newInstance(escrutinio.getClass());
		Unmarshaller um = context.createUnmarshaller();

		escrutinio = new Escrutinio_sitio((Escrutinio_sitio) um.unmarshal(new FileReader(new File(parametro))));

		return escrutinio;
	}

	private static void Pasar_pagina_web_a_archivo(String web) throws IOException, MalformedURLException, Exception {
		String lin = "";

		URL url = new URL(web);

		try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				FileWriter writer = new FileWriter(fichero_temporal);
				BufferedWriter bw = new BufferedWriter(writer)) {
			while ((lin = br.readLine()) != null) {
				bw.write(lin);
			}
		}

	}

	private static boolean Comprobar(String[] args) {
		boolean acierto = false;
		int tamanyo = 0;
		tamanyo = args.length;

		if (tamanyo >= 0) {

			if (tamanyo == 0) {
				acierto = true;
			}

			else if (tamanyo == 2) {
				if (((args[0].equals(kf)) || (args[0].equals(kn)) || (args[0].equals(ku)) || (args[0].equals(ki)))
						&& (args[1] != null)) {
					acierto = true;
				}
			} else if (tamanyo == 4) {
				if (((args[0].equals(kf)) || (args[0].equals(kn)) || (args[0].equals(ku)) || (args[0].equals(ki)))
						&& (args[1] != null)) {

					if (((args[2].equals(kf)) || (args[2].equals(kn)) || (args[2].equals(ku)) || (args[2].equals(ki)))
							&& (args[3] != null)) {
						acierto = true;
					}

				}
			}
		}

		return acierto;
	}

	private static String Hay(String parametro, String[] args) {
		String acierto = "no";
		int contador = 0;

		for (contador = 0; contador < args.length; contador++) {
			if (((contador == args.length) == false) && (args[contador].equals(parametro))) {
				acierto = args[contador + 1];
				contador = args.length;
			}
		}

		return acierto;
	}
}
