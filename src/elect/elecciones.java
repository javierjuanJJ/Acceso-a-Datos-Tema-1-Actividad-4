package elect;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.xml.bind.JAXBException;

public class elecciones {

	static final String kf = "-f";
	static final String ku = "-u";
	static final String kn = "-n";
	static final String ki = "-i";
	static final String kno_hay_parametro = "no";
	static final String url_defecto = "https://rsl00.epimg.net/elecciones/2019/generales/congreso/index.xml2";

	public static void main(String[] args) {
		String parametro = "";
		String parametro2 = "";
		String parametro3 = "";
		String parametro4 = "";
		String resultado = "";
		try {
			
			parametro = Hay(kf, args);
			parametro2 = Hay(ku, args);
			parametro3 = Hay(kn, args);
			parametro4 = Hay(ki, args);
			Escrutinio_sitio escrutinio = new Escrutinio_sitio();
			
			if (Comprobar(args)) {
				
				if (parametro != kno_hay_parametro) {
					escrutinio = escrutinio.Cargar_xml(parametro);
				} else if (parametro2 != kno_hay_parametro) {
					escrutinio = escrutinio.Pasar_pagina_web_a_archivo(parametro2);
				} else {
					escrutinio = escrutinio.Pasar_pagina_web_a_archivo(url_defecto);
				}
				
				resultado = escrutinio.ver_informacion();
				
				if (parametro3 != kno_hay_parametro) {
					resultado = resultado + escrutinio.Buscar_por_nombre(parametro3);
				} else if (parametro4 != kno_hay_parametro) {
					resultado = resultado + escrutinio.Buscar_por_id(parametro4);
				} else {
					resultado = escrutinio.toString();
				}		
			} else {
				resultado = Mostrar_ayuda();
			}
			System.out.println(resultado);
		
		} catch (FileNotFoundException ex) {
			System.err.println("El fichero no existe" + ex.getMessage());
		} catch (JAXBException ex) {
			System.err.println("Problemas durante la lectura/escritura del archivo xml " + ex.getMessage());
		} catch (MalformedURLException e) {
			System.err.println("URL con formato equivocada " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error de entrada/salida " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Error no identificado " + e.getMessage());
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
		String acierto = "";
		acierto = kno_hay_parametro;
		int contador = 0;
		
		for (contador = 0; contador < args.length; contador++) {
			if (((contador == args.length) == false) && (args[contador].equals(parametro))) {
				acierto = args[contador + 1];
				contador = args.length;
			}
		}
		return acierto;
	}

	private static String Mostrar_ayuda() {
		String resultado = "";
		resultado = "Error en la forma de escribir el comando. \nLa forma correcta de escribir el comando es con los parametros:\n"+ kn + " para los ficheros," + ki + " para buscar la id " + kf+ " para buscar por nombre del partido y " + ku + " para buscar por url de internet\n"+ "\n 1.- java -jar elecciones.jar\n" + "\n 2.- java -jar elecciones.jar -u " + url_defecto + " \n"+ "\n 3.- java -jar elecciones.jar -u " + url_defecto + " -i 2 \n"+ "\n 4.- java -jar elecciones.jar -u " + url_defecto + " -n PSOE \n"+ "\n 5.- java -jar elecciones.jar -f " + "resultados28A-generales.xml" + " \n"+ "\n 6.- java -jar elecciones.jar -f " + "resultados28A-generales.xml" + "-i 2 \n"+ "\n 7.- java -jar elecciones.jar -f " + "resultados28A-generales.xml" + "-n PSOE \n";
		return resultado;
	}

}
