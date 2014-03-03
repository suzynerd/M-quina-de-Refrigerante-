package br.edu.ifrn.dietinf.tads.oop;

/**
 * Classe que representa o Refrigerante.
 * 
 * @author Alessandro
 *
 */
public class Refrigerante {

	private String marca;
	private double valor;

	public Refrigerante(){
		
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
