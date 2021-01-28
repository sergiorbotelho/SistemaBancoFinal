package br.com.appbanco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class ViewUsuario extends JFrame {

	protected JPanel contentPane;
	Config config = new Config();
	ViewLogin viewLogin = new ViewLogin();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewUsuario frame = new ViewUsuario();
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
	public ViewUsuario() {
		setTitle("Banco Enterprise");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Debitar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = JOptionPane.showInputDialog("Digite o valor do para debitar:");
				double valorRec = Double.parseDouble(valor);
				config.debitar(valorRec ,viewLogin.i);
				
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Saldo");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.saldo(viewLogin.i);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cr\u00E9ditar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = JOptionPane.showInputDialog("Digite o valor do para creditar na conta:");
				double valorRec = Double.parseDouble(valor);
				config.creditar(valorRec ,viewLogin.i);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Transferir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.transferir(viewLogin.i);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View view = new View();
				view.show();
				dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Relat\u00F3rio");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea textArea = new JTextArea();
				textArea.setBounds(0, 0, 434, 239);
				contentPane.add(textArea);
				for(Conta list : config.bd) {
					if(list.op) {
						textArea.append(list.descricao());
					} else {
						textArea.append(list.descricaoEspecial());
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mnNewMenu.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\Logo Marca D'.png"));
		lblNewLabel.setBounds(0, 0, 434, 239);
		contentPane.add(lblNewLabel);

	}
}
