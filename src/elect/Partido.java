package elect;

import javax.xml.bind.annotation.XmlElement;

public class Partido {
	@XmlElement(name = "id_partido")
	private int id_partido;
	@XmlElement(name = "nombre")
	private String nombre;
	@XmlElement(name = "electos")
	private int electos;
	@XmlElement(name = "votos_numero")
	private int votos_numero;
	@XmlElement(name = "votos_porciento")
	private double votos_porciento;
	
	public Partido(int pid_partido,String pnombre,int pelectos,int pvotos_numero
			,double pvotos_porciento) {

		id_partido=pid_partido;
		nombre=pnombre;
		electos=pelectos;
		votos_numero=pvotos_numero;
		votos_porciento=pvotos_porciento;
	}
	
	public Partido() {

		id_partido=0;
		nombre="";
		electos=0;
		votos_numero=0;
		votos_porciento=0.0;
	}
	
	public Partido(Partido Partidos) {

		id_partido=Partidos.getid_partido();
		nombre=Partidos.getnombre();
		electos=Partidos.getelectos();
		votos_numero=Partidos.getvotos_numero();
		votos_porciento=Partidos.getvotos_porciento();
	}

	
	
	
	public String getnombre() {
		return nombre;
	}

	public int getid_partido() {
		return id_partido;
	}

	public int getelectos() {
		return electos;
	}

	public int getvotos_numero() {
		return votos_numero;
	}

	public double getvotos_porciento() {
		return votos_porciento;
	}

	public String toString() {
		
		String Texto_del_Objeto="";
		
		Texto_del_Objeto=Texto_del_Objeto + "El nombre es " + getnombre() + "\n";
		Texto_del_Objeto=Texto_del_Objeto +"La id del partido es " + getid_partido() + "\n";
		Texto_del_Objeto=Texto_del_Objeto +"Los electos son " + getelectos() + "\n";
		Texto_del_Objeto=Texto_del_Objeto +"Hay " + getvotos_numero() + " votos en el partido\n";
		Texto_del_Objeto=Texto_del_Objeto +"Es decir un " + getvotos_porciento() + " por ciento \n";
		
		return Texto_del_Objeto;
	}
}
