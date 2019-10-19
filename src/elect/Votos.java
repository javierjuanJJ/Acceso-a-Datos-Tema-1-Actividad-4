package elect;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Usuario
 */
public class Votos {

    Contabilizados contabilizado;
    @XmlElement(name = "nulos")
    Nulos nulo;
    @XmlElement(name = "abstenciones")
    Abstenciones abstencion;
    
    Blancos blanco;
    
    public Votos(Contabilizados pcontabilizado,Nulos pnulo,Abstenciones pabstencion,Blancos pblanco) {
    	contabilizado=pcontabilizado;
    	nulo=pnulo;
    	abstencion=pabstencion;
    	blanco=pblanco;
    }
    
    public Votos() {
    	contabilizado=null;
    	nulo=null;
    	abstencion=null;
    	blanco=null;
    }
    
    public Votos(Votos votos) {
    	contabilizado=votos.getcontabilizado();
    	nulo=votos.getnulo();
    	abstencion=votos.getabstencion();
    	blanco=votos.getblanco();
    }
    @XmlElement(name = "contabilizados")
	public Contabilizados getcontabilizado() {
		return contabilizado;
	}
    
	public Nulos getnulo() {
		return nulo;
	}

	public Abstenciones getabstencion() {
		return abstencion;
	}
	@XmlElement(name = "blancos")
	public Blancos getblanco() {
		return blanco;
	}
	
	public void setcontabilizado(Contabilizados pcontabilizado) {
		contabilizado=pcontabilizado;
	}

	public void setnulo(Contabilizados pcontabilizado) {
		contabilizado=pcontabilizado;
	}

	public void setabstencion(Nulos pnulo) {
    	nulo=pnulo;
	}

	public void setblanco(Blancos pblanco) {
    	blanco=pblanco;
	}
	
	public String toString() {
		String Texto="";
		Texto=Texto+getcontabilizado() + "\n";
		Texto=Texto+getabstencion() + "\n";
		Texto=Texto+getblanco() + "\n";
		Texto=Texto+getnulo() + "\n";
		
		
		return Texto;
	}
    
}
