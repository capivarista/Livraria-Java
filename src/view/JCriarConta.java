package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JComboBox;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JLayeredPane;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.ScrollPane;
import javax.swing.ImageIcon;

public class JCriarConta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Label cpf;
	private JPasswordField passwordField;
	private JFormattedTextField dataDeNasciment;
	private Button sair;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCriarConta frame = new JCriarConta();
					frame.setLocationRelativeTo(frame);
					frame.setVisible(true);
					// frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JCriarConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 645);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(147, 178, 245));
		contentPane.setBackground(new Color(147, 178, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(204, 207, 208));
		panel.setBounds(20, 10, 1103, 575);
		contentPane.add(panel);
		panel.setLayout(null);

		Label nomeUsuario = new Label("Nome");
		nomeUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		nomeUsuario.setBounds(10, 62, 45, 21);
		panel.add(nomeUsuario);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 11));
		textField.setBounds(59, 62, 239, 21);
		panel.add(textField);
		textField.setColumns(10);

		cpf = new Label("Cpf");
		cpf.setFont(new Font("Arial", Font.PLAIN, 11));
		cpf.setBounds(10, 165, 45, 21);
		panel.add(cpf);

		passwordField = new JPasswordField();
		passwordField.setBounds(59, 165, 103, 22);
		panel.add(passwordField);

		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			dataDeNasciment = new JFormattedTextField(mascaraData);
			dataDeNasciment.setFont(new Font("Arial", Font.PLAIN, 15));
		} catch (Exception e) {
			e.printStackTrace();
		}

		dataDeNasciment.setBounds(160, 116, 71, 22);
		panel.add(dataDeNasciment);

		Button voltar = new Button("<-");
		voltar.setForeground(new Color(0, 0, 0));
		voltar.setBackground(new Color(0, 0, 255));
		voltar.setBounds(0, 0, 24, 21);
		panel.add(voltar);

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Criar uma instância da tela JLogin
				JLogin telaLogin = new JLogin();

				// Tornar a tela JLogin visível
				telaLogin.setLocationRelativeTo(JCriarConta.this);
				telaLogin.setVisible(true);

				// Fechar a tela atual (JCriarConta)
				dispose();
			}
		});

		sair = new Button("SAIR");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confimacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmar Saída",
						JOptionPane.YES_NO_OPTION);
				if (confimacao == JOptionPane.YES_OPTION) {
					System.exit(0); // Fecha a aplicação
				}
			}
		});
		sair.setBackground(new Color(224, 29, 49));
		sair.setForeground(new Color(255, 255, 255));
		sair.setFont(new Font("Arial", Font.PLAIN, 11));
		sair.setBounds(0, 554, 45, 21);
		panel.add(sair);

		JComboBox listSexo = new JComboBox();
		listSexo.setBackground(new Color(215, 215, 215));
		listSexo.setForeground(new Color(0, 0, 0));
		listSexo.setMaximumRowCount(2);
		listSexo.setFont(new Font("Arial", Font.PLAIN, 11));
		listSexo.setBounds(59, 216, 75, 21);
		listSexo.addItem("Feminina");
		listSexo.addItem("Masculino");
		panel.add(listSexo);

		JLabel bem_vindo = new JLabel("Bem vindo");
		bem_vindo.setFont(new Font("Arial", Font.BOLD, 18));
		bem_vindo.setBounds(387, 0, 154, 33);
		panel.add(bem_vindo);

		JLabel email = new JLabel("E-mail");
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		email.setBounds(10, 382, 45, 21);
		panel.add(email);

		JLabel senha = new JLabel("Senha");
		senha.setFont(new Font("Arial", Font.PLAIN, 15));
		senha.setBounds(10, 413, 59, 33);
		panel.add(senha);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(75, 420, 223, 21);
		panel.add(passwordField_2);

		textField_1 = new JTextField();
		textField_1.setBounds(75, 383, 223, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JCriarConta.class.getResource("/Imagens/icon.png")));
		lblNewLabel.setBounds(594, 34, 474, 474);
		panel.add(lblNewLabel);

		JButton continuar = new JButton("CONTINUAR");
		continuar.setForeground(new Color(255, 255, 255));
		continuar.setBackground(new Color(0, 0, 0));
		continuar.setFont(new Font("Arial", Font.PLAIN, 11));
		continuar.setHorizontalAlignment(SwingConstants.LEFT);
		continuar.setBounds(965, 554, 103, 21);
		panel.add(continuar);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 115, 140, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sexo");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 215, 59, 21);
		panel.add(lblNewLabel_2);
		continuar.addActionListener(new ActionListener() {

		private boolean isAgeValid(String dateOfBirth, int ageLimit) {
		    try {
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        LocalDate birthDate = LocalDate.parse(dateOfBirth, formatter);
		        LocalDate currentDate = LocalDate.now();
				Period period = Period.between(birthDate, currentDate);

		        int age = period.getYears();
		        return age >= ageLimit;
			 } catch (Exception e) {
			    return false; // Se houver um erro no parsing da data, consideramos como inválida
			   }
			}
			
		public void actionPerformed(ActionEvent e) {
		String nome = textField.getText();
		String cpf = new String(passwordField.getPassword());
		String dataNascimento = dataDeNasciment.getText();
		String sexo = listSexo.getSelectedItem().toString();
		String email = textField_1.getText();
		String senha = new String(passwordField_2.getPassword());

		 // Verificar se o CPF contém apenas números
        if (!cpf.matches("\\d+")) {
            JOptionPane.showMessageDialog(JCriarConta.this, "CPF deve conter apenas números.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Verificar se o CPF contém apenas números e tem 11 dígitos
        if (!cpf.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(JCriarConta.this, "CPF inválido. Deve conter apenas números e ter 11 dígitos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Verificar a validade da data de nascimento
        int idadeLimite = 18;
        if (!isAgeValid(dataNascimento, idadeLimite)) {
            JOptionPane.showMessageDialog(JCriarConta.this, "Você deve ter pelo menos 18 anos para se cadastrar.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Verificar o formato do e-mail
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(JCriarConta.this, "E-mail inválido.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
		
		if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty() || sexo.isEmpty() || email.isEmpty()
				|| senha.isEmpty()) {
			JOptionPane.showMessageDialog(JCriarConta.this, "Preencha todos os campos.", "Erro",
			JOptionPane.ERROR_MESSAGE);
				return;
		}

		// Abrir a tela JPrincipal
		JPrincipal telaPrincipal = new JPrincipal();
		telaPrincipal.setLocationRelativeTo(JCriarConta.this);
		telaPrincipal.setVisible(true);

		// Fechar a tela atual (JCriarConta)
		dispose();
			}
		});
		

	}
}
