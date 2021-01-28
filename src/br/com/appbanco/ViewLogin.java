package br.com.appbanco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	static public int i;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
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
	public ViewLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/cifrão.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textLogin = new JTextField();
		textLogin.setBounds(102, 87, 217, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Config config = new Config();
				String conta = textLogin.getText();
				try {
					Integer contaInt = Integer.parseInt(conta);
					i = config.login(contaInt);
					dispose();
				}catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "Digite apenas numeros", "ALERTA",
							JOptionPane.ERROR_MESSAGE);
					textLogin.setText("");
				}
				
			}
		});
		btnNewButton.setBounds(102, 118, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View view = new View();
				view.show();
				dispose();
			}
		});
		btnNewButton_1.setBounds(230, 118, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Digite o n\u00FAmero da sua Conta:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(117, 62, 202, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img\\Logo Marca D'.png"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_1);
	}
	
		
}
