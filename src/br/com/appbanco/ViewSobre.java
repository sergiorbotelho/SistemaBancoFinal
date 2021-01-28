package br.com.appbanco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSobre extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSobre frame = new ViewSobre();
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
	public ViewSobre() {
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\nave 01.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 364);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("S\u00E9rgio Roberto Botelho Correia Filho");
		lblNewLabel_4.setBounds(89, 59, 199, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Matr\u00EDcula: 01306000");
		lblNewLabel_1.setBounds(89, 75, 108, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Felipe Barbosa Teles Barreto da Silva");
		lblNewLabel.setBounds(89, 175, 183, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Matr\u00EDcula: 01334672");
		lblNewLabel_2.setBounds(89, 192, 113, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Matr\u00EDcula:0000000000");
		lblNewLabel_3.setBounds(89, 125, 128, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Cassio dos Santos");
		lblNewLabel_5.setBounds(89, 111, 128, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Equipe");
		lblNewLabel_6.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(199, 0, 95, 20);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("img\\Ver\u00F4nica.png"));
		lblNewLabel_7.setBounds(10, 216, 60, 63);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblVernicaPereiraDe = new JLabel("Ver\u00F4nica Pereira De Santana");
		lblVernicaPereiraDe.setBounds(89, 232, 183, 14);
		getContentPane().add(lblVernicaPereiraDe);
		
		JLabel lblNewLabel_2_1 = new JLabel("Matr\u00EDcula: 01185366");
		lblNewLabel_2_1.setBounds(89, 246, 113, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("");
		lblNewLabel_7_2.setIcon(new ImageIcon("img\\Felipe Novo.png"));
		lblNewLabel_7_2.setBounds(10, 156, 60, 63);
		getContentPane().add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_2_1 = new JLabel("");
		lblNewLabel_7_2_1.setIcon(new ImageIcon("img\\Cassio Novo.png"));
		lblNewLabel_7_2_1.setBounds(10, 97, 60, 63);
		getContentPane().add(lblNewLabel_7_2_1);
		
		JLabel lblNewLabel_7_2_2 = new JLabel("");
		lblNewLabel_7_2_2.setIcon(new ImageIcon("img\\Sergio novo ok.png"));
		lblNewLabel_7_2_2.setBounds(10, 26, 60, 63);
		getContentPane().add(lblNewLabel_7_2_2);
		
		JLabel lblNewLabel_7_2_1_1 = new JLabel("");
		lblNewLabel_7_2_1_1.setIcon(new ImageIcon("img\\Sergio novo ok.png"));
		lblNewLabel_7_2_1_1.setBounds(10, 41, 60, 63);
		getContentPane().add(lblNewLabel_7_2_1_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("img\\Logo Marca D'.png"));
		lblNewLabel_8.setBounds(20, -11, 485, 303);
		getContentPane().add(lblNewLabel_8);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ajuda");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Voltar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View view = new View();
				view.show();
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
	}
}
