package br.com.appbanco;

public class Conta {

	public String nome;
	public Integer numConta;
	public Double saldo;
	public boolean op;

	public Conta() {

	}

	public Conta(String nome, Integer numConta, Double saldo, boolean op) {
		super();
		this.nome = nome;
		this.numConta = numConta;
		this.saldo = saldo;
		this.op = true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumConta() {
		return numConta;
	}

	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String descricao() {
		return "-------Cliente----------\n Conta Corrente" + "\n Nome: " + nome + "\nNumero da conta: " + numConta
				+ "\nSaldo: " + saldo + "\n";
	}

	public String descricaoEspecial() {

		ContaEspecial especial = new ContaEspecial();
		return "-------Cliente----------\n Conta Especial" + "\n Nome: " + nome + "\nNumero da conta: " + numConta
				+ "\nSaldo: " + saldo + "\nLimite Especial: " + especial.getLimite();
	}

	public boolean isOp() {
		return op;
	}

	public void setOp(boolean op) {
		this.op = op;
	}

}