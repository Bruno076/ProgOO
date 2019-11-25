package com.poo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 387, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(52, 82, 52, 35);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(52, 134, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(114, 89, 155, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 131, 155, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(checkLogin(textField.getText(),textField_1.getText())) {
					//JOptionPane.showMessageDialog(frame, "Logado com sucesso");
					EscolaFrame janela = new EscolaFrame();
					janela.setVisible(true);
					frame.dispose();
				}
				
				else {
					JOptionPane.showMessageDialog(frame, "Dados Errados");
				}
				
				
			}
		});
		btnEntrar.setBounds(146, 180, 89, 23);
		frame.getContentPane().add(btnEntrar);
	}
	
	public boolean checkLogin(String textField, String textField_1) {
		
		return textField.equals("admin") && textField_1.equals("admin");
		
		
		
	}
	
}