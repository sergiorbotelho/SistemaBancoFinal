package br.com.appbanco;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Config {
	ViewCadastro view = new ViewCadastro();
	static LinkedList<Conta> bd = new LinkedList<Conta>();
	static ContaEspecial a = new ContaEspecial();

	public void cadastro(Conta b) {
		b.setOp(true);
		bd.add(b);

	}

	public boolean verificador(int num) {
		boolean h= true;
		for (Conta list : bd) {
			if (list.op) {
				if (list.getNumConta().equals(num)) {
					JOptionPane.showMessageDialog(null, "Numero de conta ja existe", "ALERTA",
							JOptionPane.ERROR_MESSAGE);
					h = false;
				}
			} else {
				if (list.getNumConta().equals(num)) {
					JOptionPane.showMessageDialog(null, "Numero de conta ja existe", "ALERTA",
							JOptionPane.ERROR_MESSAGE);
					h = false;
				}
			}
		}
		return h;
	}

	public void cadastroPoupe(String nome, int num, double saldo) {

		a.setNome(nome);
		a.setNumConta(num);
		a.setSaldo(saldo);
		if (a.getSaldo() <= 500) {
			a.setLimite(250.00);
		} else if (a.getSaldo() > 500 && a.getSaldo() <= 1500) {
			a.setLimite(500.00);
		} else if (a.getSaldo() > 1500 && a.getSaldo() <= 3000) {
			a.setLimite(1000.00);
		} else if (a.getSaldo() > 3000) {
			a.setLimite(2000.00);
		}

		bd.add(a);

	}

	public int login(int contaInt) {
		ViewUsuario viewusuario = new ViewUsuario();
		ViewLogin viewlogin = new ViewLogin();
		int x = 0;
		int y = 0;
		for (Conta list : bd) {
			if (list.getNumConta().equals(contaInt)) {
				if (list.op) {
					JOptionPane.showMessageDialog(null, descricao(list));
					viewusuario.show();
					y = list.getNumConta();
					viewlogin.dispose();
					break;
				} else {
					JOptionPane.showMessageDialog(null, descricaoEspecial());
					viewusuario.show();
					y = list.getNumConta();
					viewlogin.dispose();
					break;
				}
			}
			x++;
			if (x == bd.size()) {
				JOptionPane.showMessageDialog(null, "Conta Inexistente");
				viewlogin.show();
				break;
			}
		}
		return y;

	}

	public void debitar(double valor, int num) {
		int x = 0;
		for (Conta list : bd) {
			if (list.getNumConta().equals(num)) {
				if (list.op) {
					if(list.saldo < valor) {
						JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente!\n"
															+ list.getSaldo());
					} else {
						list.setSaldo(list.getSaldo() - valor);
						JOptionPane.showMessageDialog(null, descricao(list));
						break;
					}
				} else {
					if(list.saldo < valor) {
						JOptionPane.showMessageDialog(null, "Valor será debidado do seu limite especial!\n"
															+ list.getSaldo());
						lim(valor);
						JOptionPane.showMessageDialog(null, descricao(list));
						break;
						
					} else {
						list.setSaldo(list.getSaldo() - valor);
						JOptionPane.showMessageDialog(null, descricao(list));
						break;
					}
				}
			}
			x++;
			if (x == bd.size()) {
				JOptionPane.showMessageDialog(null, "Voltando ao menu");
				break;
			}
		}
	}

	public void creditar(double valor, int num) {
		int x = 0;
		for (Conta list : bd) {
			if (list.getNumConta().equals(num)) {
				if (list.op) {
					list.setSaldo(list.getSaldo() + valor);
					JOptionPane.showMessageDialog(null, descricao(list));
					break;
				} else {
					list.setSaldo(list.getSaldo() + valor);
					JOptionPane.showMessageDialog(null, descricaoEspecial());
					break;
				}
			}
			x++;
			if (x == bd.size()) {
				JOptionPane.showMessageDialog(null, "Voltando ao menu");
				break;
			}
		}

	}

	public void saldo(int num) {
		int x = 0;
		for (Conta list : bd) {

			if (list.getNumConta().equals(num)) {
				if (list.op) {
					JOptionPane.showMessageDialog(null, descricao(list));
					break;
				} else {
					JOptionPane.showMessageDialog(null, descricaoEspecial());
					break;
				}
			}
			x++;
			if (x == bd.size()) {
				JOptionPane.showMessageDialog(null, "Conta Inexistente");
				break;
			}
		}

	}

	public void transferir(int conta) {
		int x = 0;
		try {
			for (Conta list : bd) {
				if (list.getNumConta().equals(conta)) {
					if (list.op) {
						String contaS = JOptionPane.showInputDialog("Digite o numero da conta:");
						int contaT = Integer.parseInt(contaS);
						for (Conta contaPt : bd) {
							if (contaPt.getNumConta().equals(contaT)) {
								if (contaPt.op) {
									msn(contaPt);
									contaS = JOptionPane.showInputDialog("Digite o valor");
									msn2();
									double valor = Double.parseDouble(contaS);
									if(list.getSaldo() < valor) {
										JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente!\n"
												+ list.getSaldo());
										break;
									} else {
										list.setSaldo(list.getSaldo() - valor);
										contaPt.setSaldo(contaPt.getSaldo() + valor);
										JOptionPane.showMessageDialog(null,
											"	Valor transferido com sucesso!\n" + "Seu novo saldo:" + list.getSaldo());
										break;
									}
								} else {
									msn(contaPt);
									contaS = JOptionPane.showInputDialog("Digite o valor");
									msn2();
									double valor = Double.parseDouble(contaS);
									if(list.getSaldo() < valor) {
										JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente!\n"
												+ list.getSaldo());
										break;
									} else {
										list.setSaldo(list.getSaldo() - valor);
										contaPt.setSaldo(contaPt.getSaldo() + valor);
										JOptionPane.showMessageDialog(null,
											"	Valor transferido com sucesso!\n" + "Seu novo saldo:" + list.getSaldo());
										break;
									}
								}
							}
						}
						x++;
						if (x == bd.size()) {
							JOptionPane.showMessageDialog(null, "Voltando ao menu");
							break;
						}
					} else {
						String contaS = JOptionPane.showInputDialog("Digite o numero da conta:");
						int contaT = Integer.parseInt(contaS);
						for (Conta contaPt : bd) {
							if (contaPt.getNumConta().equals(contaT)) {
								if (contaPt.op) {
									msn(contaPt);
									contaS = JOptionPane.showInputDialog("Digite o valor");
									msn2();
									double valor = Double.parseDouble(contaS);
									if(list.getSaldo() < valor) {
										JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente!\n"
												+ list.getSaldo());
										break;
									} else {
										list.setSaldo(list.getSaldo() - valor);
										contaPt.setSaldo(contaPt.getSaldo() + valor);
										JOptionPane.showMessageDialog(null,
											"	Valor transferido com sucesso!\n" + "Seu novo saldo:" + list.getSaldo());
									}
									break;
								}
							} else {
								msn(contaPt);
								contaS = JOptionPane.showInputDialog("Digite o valor");
								msn2();
								double valor = Double.parseDouble(contaS);
								if(list.getSaldo() < valor) {
									JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente!\n"
											+ list.getSaldo());
									break;
								} else {
									list.setSaldo(list.getSaldo() - valor);
									contaPt.setSaldo(contaPt.getSaldo() + valor);
									JOptionPane.showMessageDialog(null,
										"	Valor transferido com sucesso!\n" + "Seu novo saldo:" + list.getSaldo());
									break;
								}
							}
						}
					}
				}
				x++;
				if (x == bd.size()) {
					JOptionPane.showMessageDialog(null, "Voltando ao menu");
					break;
				}
			}
		} catch (NumberFormatException a) {
			JOptionPane.showMessageDialog(null, "Você digitou letra ao inves de numeros"
											+   "\nrepita a operação!", "ALERTA",
					JOptionPane.ERROR_MESSAGE);
			ViewUsuario viewusuario = new ViewUsuario();
			viewusuario.show();
		}
		
		}

	public void msn(Conta a) {
		ViewUsuario viewusuario = new ViewUsuario();
		Object[] options = { "OK", "CANCELAR" };
		int t = JOptionPane.showOptionDialog(null, "Conta para tranferencia\n" + a.getNome(), "Aviso",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if (t == 1) {
			viewusuario.show();
		}
	}

	public void msn2() {
		Object[] options = { "OK", "CANCELAR" };
		JOptionPane.showOptionDialog(null, "Confirma tranferência?\n", "Aviso", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, options, options[0]);
	}

	public String descricao(Conta b) {
		return "\n-------Cliente----------\n Conta Corrente" + "\n Nome: " + b.getNome() + "\nNumero da conta: "
				+ b.getNumConta() + "\nSaldo: " + b.getSaldo();
	}

	public String descricaoEspecial() {

		return "\n-------Cliente----------\n Conta Especial" + "\n Nome: " + a.getNome() + "\nNumero da conta: "
				+ a.getNumConta() + "\nSaldo: " + a.getSaldo() + "\nLimite Especial: " + a.getLimite();
	}
	
	public void lim(double valor) {
		a.setLimite(a.getSaldo() + a.getLimite());
		a.setSaldo(0.00);
		a.setLimite(a.getLimite() - valor);
	}

}
