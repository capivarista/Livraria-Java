package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.Criptografia;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class JLogin extends JFrame {

	private JFrame frmApp;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblRelogio;
	private JLabel lblData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin window = new JLogin();
					window.setLocationRelativeTo(window); // Centraliza a janela na tela
					window.frmApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JLogin() {
		frmApp = new JFrame();
		frmApp.getContentPane().setEnabled(false);
		frmApp.getContentPane().setBackground(new Color(147, 178, 245));
		frmApp.setBackground(new Color(240, 240, 240));
		frmApp.setTitle("App");
		frmApp.setBounds(100, 100, 1161, 645); // Aumentar largura e altura
		frmApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmApp.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(73, 37, 996, 519);
		panel.setBackground(new Color(204, 207, 208));
		frmApp.getContentPane().add(panel);
		panel.setLayout(null);

		// Label e campo de texto para o usuário
		JLabel email = new JLabel("E-mail");
		email.setFont(new Font("Arial", Font.BOLD, 15));
		email.setBounds(29, 122, 46, 14);
		panel.add(email);
		JTextField textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(87, 121, 177, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		// Label, campo de senha e botão de entrar
		JLabel senha = new JLabel("Senha");
		senha.setFont(new Font("Arial", Font.BOLD, 15));
		senha.setBounds(29, 190, 70, 14);
		panel.add(senha);

		JButton entrar = new JButton("ENTRAR");
		
		entrar.setFont(new Font("Arial", Font.PLAIN, 11));
		entrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Cria uma instância da classe de criptografia, passando a senha e o algoritmo
				// MD5
				Criptografia criptografia = new Criptografia(passwordField.getText(), Criptografia.MD5);
				System.out.println(criptografia.criotografar());

				
				// Verifica se os campos de usuário e senha estão preenchidos
				if (textFieldUsuario.getText() != null && !textFieldUsuario.getText().isEmpty()
						&& passwordField.getText() != null && !passwordField.getText().isEmpty()) {
					if (criptografia.criotografar().equals("E10ADC3949BA59ABBE56E057F20F883E"))
						;
					{
						JOptionPane.showMessageDialog(entrar, "Informaçoes validas");
						dispose();
						JPrincipal jPrincipal = new JPrincipal();
						jPrincipal.setLocationRelativeTo(jPrincipal);
						jPrincipal.setVisible(true);
					}
				} else {
					// Mostra um aviso se os campos não estiverem preenchidos
					JOptionPane.showMessageDialog(entrar, "Verifique as informações", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		entrar.setBackground(new Color(0, 0, 0));
		entrar.setForeground(Color.WHITE);
		entrar.setBounds(877, 470, 89, 23);
		panel.add(entrar);

		// Label de boas-vindas e campo de senha

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(87, 189, 177, 20);
		panel.add(passwordField);

		JLabel livrariaDeAlexandria = new JLabel("Livraria De Alexandria");
		livrariaDeAlexandria.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		livrariaDeAlexandria.setHorizontalAlignment(SwingConstants.LEFT);
		livrariaDeAlexandria.setBounds(29, 6, 257, 38);
		panel.add(livrariaDeAlexandria);

		// Label para relogio digital
		lblRelogio = new JLabel("");
		lblRelogio.setBackground(new Color(240, 240, 240));
		lblRelogio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRelogio.setFont(new Font("Arial", Font.BOLD, 11));
		lblRelogio.setBounds(556, 6, 410, 14);
		panel.add(lblRelogio);

		JButton sair = new JButton("SAIR");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confimacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmar Saída",
						JOptionPane.YES_NO_OPTION);
				if (confimacao == JOptionPane.YES_OPTION) {
					System.exit(0); // Fecha a aplicação
				}
			}
		});

		// Label para dadta
		lblData = new JLabel("");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setFont(new Font("Arial", Font.BOLD, 11));
		lblData.setBounds(556, 30, 410, 14);
		panel.add(lblData);
		sair.setBackground(new Color(224, 29, 49));
		sair.setForeground(Color.white);
		sair.setFont(new Font("Arial", Font.PLAIN, 11));
		sair.setBounds(29, 470, 89, 23);
		panel.add(sair);

		JButton criarConta = new JButton("CRIAR CONTA");
		criarConta.setForeground(new Color(255, 255, 255));
		criarConta.setBackground(new Color(0, 0, 0));
		criarConta.setFont(new Font("Arial", Font.PLAIN, 11));
		criarConta.setBounds(29, 439, 117, 21);
		panel.add(criarConta);

		JLabel imagenLI = new JLabel("");
		imagenLI.setIcon(new ImageIcon(JLogin.class.getResource("/Imagens/Novo Projeto.png")));
		imagenLI.setBounds(570, 33, 396, 400);
		panel.add(imagenLI);

		criarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cria uma instância da classe JCriarConta
				JCriarConta jCriarConta = new JCriarConta();
				jCriarConta.setLocationRelativeTo(jCriarConta);
				jCriarConta.setVisible(true);
			}
		});

		// Timer para atualizar a hora e a data a cada segundo
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarRelogio();
			}
		});
		timer.start();
	}

	// Método para atualizar o relógio e a data
	private void atualizarRelogio() {
		SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		Date agora = new Date();

		lblRelogio.setText(formatoHora.format(agora));
		lblData.setText(formatoData.format(agora));
	}
}
