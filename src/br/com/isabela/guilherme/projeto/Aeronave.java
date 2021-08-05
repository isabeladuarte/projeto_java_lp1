package br.com.isabela.guilherme.projeto;

public class Aeronave {
	protected String modelo;
	
	public Aeronave(String modelo) {
		this.modelo = modelo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Aeronave [modelo=" + modelo + "]";
	}
}
 