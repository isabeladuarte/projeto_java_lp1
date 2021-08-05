package br.com.isabela.guilherme.projeto;

public class Voo {
	private Aviao aeronave;
	private int nro;
	private String data;
	private String hora;
	
	public Voo(Aviao aeronave, int nro, String data, String hora) {
		this.aeronave = aeronave;
		this.nro = nro;
		this.data = data;
		this.hora = hora;
	}

	public Aviao getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aviao aeronave) {
		this.aeronave = aeronave;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Voo [aeronave=" + aeronave + ", nro=" + nro + ", data=" + data + ", hora=" + hora + "]";
	}
}
