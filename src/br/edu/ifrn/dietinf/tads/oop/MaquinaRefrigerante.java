package br.edu.ifrn.dietinf.tads.oop;

import java.util.ArrayList;
import java.util.Scanner;


public class MaquinaRefrigerante {

	static Refrigerante refrigeranteEntrega;
	private static double saldo = 10;
	private static double troco = 0;

	static ArrayList<Refrigerante> refrigerantes = new ArrayList<Refrigerante>(100);

	public double getSaldo() {
		return saldo;
	}

	/**
	 * Altera o saldo.
	 * 
	 * @param saldo o saldo da m�quina.
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public MaquinaRefrigerante() {

	}

	public static void main(String args[]) {

		Refrigerante coca = new Refrigerante();
		coca.setMarca("Coca");
		coca.setValor(2.50);

		Refrigerante guarana = new Refrigerante();
		guarana.setMarca("Guaran�");
		guarana.setValor(1.79);

		Refrigerante sukita = new Refrigerante();
		sukita.setMarca("Sukita");
		sukita.setValor(2.78);

		Refrigerante sprite = new Refrigerante();
		sprite.setMarca("Sprite");
		sprite.setValor(3.00);

		Refrigerante schweppes = new Refrigerante();
		schweppes.setMarca("Schwepps");
		schweppes.setValor(5.00);

		for (int i = 0; i < 2; i++) {
			refrigerantes.add(coca);
			refrigerantes.add(guarana);
			refrigerantes.add(sukita);
			refrigerantes.add(sprite);
			refrigerantes.add(schweppes);
		}

		Scanner ler = new Scanner(System.in);

		int opcao = -1;
		int num = -1;
		do {
			
			System.out.println("\nQuantidade de Refrigerante(s): " + refrigerantes.size());
			System.out.println("Saldo da M�quina: "+saldo +" R$\n");
			
			System.out.println(" / M�QUINA DE REFRIGERANTES  /\n");
			
			for (int i = 0; i < refrigerantes.size(); i++) {
				System.out.println("MARCA: "+refrigerantes.get(i).getMarca() +" - VALOR: "+refrigerantes.get(i).getValor());
			}			

			System.out.println("\nMenu /-----/ \n  0 - Sair\n  1 -Entrar");
			opcao = ler.nextInt();
			
			if(opcao == 1){
			
				System.out.println("Entre com o Cr�dito: (ex: 3)");
				double credito = ler.nextDouble();
				System.out.println("Entre com o refrigerante: (ex: sprite)");
				String refri = ler.next();
				System.out.println("\nVerificando...\n");
				boolean tem = vericarDisponibilidadeRefrigerante(refri);	
				
				if (tem == true) {
					
					System.out.println("Tem refrigerante \\0/ \n Marca: "+ refri +" Valor do Refri: "+refri+" : "+refrigeranteEntrega.getValor()+" R$ quer comprar?\n 0 - Sair\n 1 - Continuar");
					num = ler.nextInt();

					if (num == 1) {
						entregarRefrigerante(refri, credito);

					} else {
						num = 0;
					}

				} else {
					System.out.println("/0\\ - Infelizmente n�o temos o Refrigerante: "+refri);
					System.out.println("Seu Troco: "+credito+" R$\n");
					System.out.println("----------------------------------");
				}				
				
			} else {
				num = 0;
			}
		} while(num != 0 );
				
		System.out.println("Saldo da M�quina: "+saldo +" R$");
		System.out.println("Qnt de Refrigerante(s): " + refrigerantes.size());
	}

	/**
	 * Realiza a soma dos cr�ditos informados.
	 *
	 * @param credito o valor de um cr�dito. 
	 * @return a soma dos cr�ditos informados.
	 */
	public double receberCredito(double credito) {

		double totalCreditos = 0;

		totalCreditos = totalCreditos + credito;

		return credito;
	}

	/**
	 * Obtem o valor do saldo.
	 *
	 * @return o saldo da m�quina.
	 */
	public double valorTotalMaquina() {
		return saldo;
	}

	/**
	 * Insere um valor para ser colocado no saldo.
	 * 
	 * @param valor o valor do cr�dito.
	 * @return o saldo.
	 */
	public double saldoMaquina(double valor) {
		return saldo = saldo + valor;
	}

	/**
	 * Verifica se existe um refrigerante no Array.
	 * 
	 * @param refrigerante o refrigerante a ser procurado.
	 * @return <code>true</code> se exitir refrigerante, <code>false</code> se n�o exitir refrigerante. 
	 */
	public static boolean vericarDisponibilidadeRefrigerante(String refrigerante) {

		boolean tem = false;
		int i = refrigerantes.size() - 1;
		while(i >= 0 ){
			tem = refrigerantes.get(i).getMarca().equalsIgnoreCase(refrigerante);
			refrigeranteEntrega = refrigerantes.get(i);
			if(tem == true){
				i = 0;
				return true;
			} else {
				i--;
			}
		}
		return false;
	}

	/**
	 * Entrega o refrigerante para o usu�rio.
	 * 
	 * @param refrigerante o refrigerente referente.
	 * @param valor o valor creditado pelo usuario para esse refrigerante.
	 */
	public static void entregarRefrigerante(String refrigerante, double valor) {

		for (int j = 0; j < refrigerantes.size(); j++) {
			if(refrigerantes.get(j).getMarca().equalsIgnoreCase(refrigerante) == true){
				
				refrigeranteEntrega = refrigerantes.get(j);
				
				if(valor == refrigeranteEntrega.getValor()){
					saldo = saldo + valor;
					
					System.out.println("Seu Troco: 0.0 R$");
					
					tirarRefrigerante(j);
					
					j = refrigerantes.size();
					
				} else if(valor > refrigeranteEntrega.getValor()){
					
					saldo = saldo + refrigeranteEntrega.getValor();
					troco = valor - refrigeranteEntrega.getValor();
					
					tirarRefrigerante(j);
					
					j = refrigerantes.size();
					
					System.out.println("Seu Troco: "+troco+" R$");
					
				} else if( valor < refrigeranteEntrega.getValor() ){
					System.out.println("Qnt insuficiente de money!!!");
					j = refrigerantes.size();
					
					System.out.println("Dinheiro devolvido: "+valor+" R$");
				}

				System.out.println("Obrigado e Volte Sempre!!!\n");
				System.out.println("----------------------------------");
			}
		}
	}
	
	/**
	 * Remove um refrigerante do Array.
	 * 
	 * @param j o identificador do refrigerante no array.
	 */
	public static void tirarRefrigerante(int j){
		refrigerantes.remove(j);
	}
}
