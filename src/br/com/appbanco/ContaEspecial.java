package br.com.appbanco;

public class ContaEspecial extends Conta {

	Double limite;

	public ContaEspecial() {

	}

	public ContaEspecial(String nome, Integer numConta, Double saldo, boolean op, Double limite) {
		super(nome, numConta, saldo, op);
		this.op = false;
		this.limite = limite;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

}
