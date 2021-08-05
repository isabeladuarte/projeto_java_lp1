package br.com.isabela.guilherme.projeto;

public class Aviao extends Aeronave {
	public Passageiro[][] lugares;

	public Aviao(String modelo, int numeroTotalfileiras, int totalAssentoPorFileira) {
		super(modelo);
		this.lugares = new Passageiro[numeroTotalfileiras][totalAssentoPorFileira]; // Criando matriz com um determinado tamanho
	}

	public Passageiro[][] getLugares() {
		return lugares;
	}
	
	public void setLugares(Passageiro[][] lugares) {
		this.lugares = lugares;
	}
	
	public Passageiro getPassageiro(int fileira, int assento) {
		if(this.lugares[fileira][assento] == null) {
			System.out.println("Lugar vazio");
			return null;
		}
		return this.lugares[fileira][assento];
	}
	
	public void setPassageiro(int fileira, int assento, Passageiro passageiro) { // Adiciona passageiro em uma fileira e lugar especifico
		this.lugares[fileira][assento] = passageiro;
	}

	public boolean verificaLugarOcupado(int fileira, int assento) {
		if(this.lugares[fileira][assento] == null) {
			System.out.println("Lugar vazio");
			return false;
		} 
		
		System.out.println("Lugar ocupado");
		return true;
	}
	
}
