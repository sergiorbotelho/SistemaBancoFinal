package br.com.appbanco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ViewCadastro extends JFrame {

	private JPanel contentPane;
	protected JTextField textNome;
	protected JTextField textConta;
	protected JTextField textSaldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastro frame = new ViewCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewCadastro() {
		JRadioButton rdbtnContaEspecial = new JRadioButton("Conta Especial");

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Conta Corrente");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnContaEspecial.setSelected(false);
			}
		});

		rdbtnContaEspecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton.setSelected(false);
			}
		});
		setTitle("Banco Enterprise");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\cifr\u00E3o.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View view = new View();
				view.show();
				dispose();
			}
		});
		mnNewMenu.add(mntmVoltar);

		JMenu mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Manual");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Este é um Sistema bancário de gerenciamento de clientes do banco Enterprise"
								+ "\nonde é realizado transaçôes como: Cadastrar novos cliente, acessar conta,"
								+ "\ndebitar, creditar e transferir. Além de mostrar um relatorio sobre os clientes"
								+ "\ncadastrados."
								+ "\nPara novos clientes de conta especial, segue a seguinte especificação:"
								+ "\nDepositos iniciais de ate 500 reais, limite especial liberado de 250 reias."
								+ "\nDepositos iniciais entre 501 ate 1500 reais, limite especial de 500 reais."
								+ "\nDepositos iniciais entre 1501 ate 3000 reias, limite especial de 1000 reais."
								+ "\nDepositos iniciais  igual ou maior que 3001 reais, limite especial de 2000 reais");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Sobre");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(26, 39, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("N\u00FAmero da conta:");
		lblNewLabel_1_1.setBounds(26, 64, 111, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("Dep\u00F3sito Inicial:");
		lblNewLabel_2.setBounds(26, 89, 139, 14);
		contentPane.add(lblNewLabel_2);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(142, 36, 282, 20);
		contentPane.add(textNome);

		textConta = new JTextField();
		textConta.setColumns(10);
		textConta.setBounds(142, 61, 282, 20);
		contentPane.add(textConta);

		textSaldo = new JTextField();
		textSaldo.setColumns(10);
		textSaldo.setBounds(142, 86, 282, 20);
		contentPane.add(textSaldo);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					Conta dados = new Conta();
					try {
						String nome = textNome.getText();
						String conta = textConta.getText();
						String saldo = textSaldo.getText();

						Integer contaInt = Integer.parseInt(conta);
						Double saldoDouble = Double.parseDouble(saldo);
						dados.setNome(nome);
						dados.setNumConta(contaInt);
						dados.setSaldo(saldoDouble);
						Config config = new Config();
						boolean h;
						h = config.verificador(contaInt);
						if (h) {
							config.cadastro(dados);
							JOptionPane.showMessageDialog(null, "Conta Corrente cadastrada");
							textNome.setText("");
							textConta.setText("");
							textSaldo.setText("");
						} else {
							textNome.setText("");
							textConta.setText("");
							textSaldo.setText("");
						}

					} catch (NumberFormatException a) {
							JOptionPane.showMessageDialog(null, "Digite apenas numeros nos"
									+ 							"\ncampos conta e valor do deposito!", "ALERTA",
									JOptionPane.ERROR_MESSAGE);
						textNome.setText("");
						textConta.setText("");
						textSaldo.setText("");
					}

				} else {
					try {
						String nome = textNome.getText();
						String conta = textConta.getText();
						String saldo = textSaldo.getText();

						Integer contaInt = Integer.parseInt(conta);
						Double saldoDouble = Double.parseDouble(saldo);
						Config config = new Config();
						boolean h = true;
						h = config.verificador(contaInt);
						if (h) {
							config.cadastroPoupe(nome, contaInt, saldoDouble);
							JOptionPane.showMessageDialog(null, "Conta Corrente cadastrada");
							textNome.setText("");
							textConta.setText("");
							textSaldo.setText("");
						} else {
							textNome.setText("");
							textConta.setText("");
							textSaldo.setText("");
						}
					} catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(null, "Digite apenas numeros"
								+ 							"\ncampos conta e valor do deposito!", "ALERTA",
								JOptionPane.ERROR_MESSAGE);
						textNome.setText("");
						textConta.setText("");
						textSaldo.setText("");
					}
				}
			}
		});
		btnNewButton.setBounds(26, 205, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLogin view = new ViewLogin();
				view.show();
				dispose();
			}
		});
		btnLogin.setBounds(134, 205, 89, 23);
		contentPane.add(btnLogin);

		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(26, 110, 139, 23);
		contentPane.add(rdbtnNewRadioButton);

		rdbtnContaEspecial.setBounds(26, 136, 139, 23);
		contentPane.add(rdbtnContaEspecial);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\Logo Marca D'.png"));
		lblNewLabel.setBounds(0, 0, 434, 239);
		contentPane.add(lblNewLabel);
	}
}
