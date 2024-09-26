package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import model.Livro;
import model.ModeloTabela;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class JPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private ArrayList<Livro> livro;
	private ModeloTabela modeloTabela;
	private JButton sair;
	private JMenu redeSocial;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JPrincipal frame = new JPrincipal();
				frame.setLocationRelativeTo(frame);
				frame.setVisible(true);
				// frame.setExtendedState(MAXIMIZED_BOTH);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public JPrincipal() {

		livro = new ArrayList<>();
		livro.add(new Livro(1, "A Biblioteca da Meia-Noite", 388, "Matt Haig", 49.67));// ok
		livro.add(new Livro(2, "A Guerra dos Tronos", 600, "George R. R. Martin", 72.10));// ok
		livro.add(new Livro(3, "A história do universo para quem tem pressa", 216, "Colin Stuart", 30.54));// ok
		livro.add(new Livro(4, "As Crônicas de Nárnia - Volume único", 752, "C.S Lewis", 51.12)); // ok
		livro.add(new Livro(5, "Como o Rei de Elfhame Aprendeu a Odiar Histórias", 192, "Holly Black", 67.92));// ok
		livro.add(new Livro(6, "Diário de um Banana", 224, "Jeff Kinney", 49.99));// ok
		livro.add(new Livro(7, "Eragon", 468, "Christopher Paolini", 54.79));// ok
		livro.add(new Livro(8, "God of War vol.2	", 384, "Robert E. Vardeman", 19.90));// ok
		livro.add(new Livro(9, "Harry Potter e a Pedra Filosofal", 264, "J. K. Rowling", 49.12)); // ok
		livro.add(new Livro(10, "Mil beijos de garoto", 400, "Tillie Cole", 33.90)); // ok
		livro.add(new Livro(11, "O Aprendiz de Assassino", 412, "Robin Hobb", 24.90)); // ok
		livro.add(new Livro(12, "O diário de Anne Frank", 416, "Anne Frank", 39.38));// ok
		livro.add(new Livro(13, "O Feiticeiro de Terramar", 208, "Ursula K. Le Guin", 46.70)); // ok
		livro.add(new Livro(14, "O misterioso lar Cavendish", 264, "Claire Legrand", 40.90));// ok
		livro.add(new Livro(15, "O nome do vento (A Crônica do Matador do Rei – Livro 1)", 656, "Patrick Rothfuss",
				59.99)); // ok
		livro.add(new Livro(16, "O Rei Perverso", 308, "Holly Black", 56.73));// ok
		livro.add(new Livro(17, "Os dois morrem no final", 416, "Adam Silvera", 50.92));// ok
		livro.add(new Livro(18, "Os Sete Maridos de Evelyn Hugo", 432, "Taylor Jenkins Reid", 27.90)); // ok
		livro.add(new Livro(19, "Percy Jackson e os Olimpianos, Vol I", 400, "Rick Riordan", 47.92)); // ok
		livro.add(new Livro(20, "Sombras e Ossos", 288, "Leigh Bardugo", 22.90));// ok

		modeloTabela = new ModeloTabela(livro);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 207, 208));
		contentPane.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton buscar = new JButton("");
		buscar.setIcon(new ImageIcon(JPrincipal.class.getResource("/Imagens/IconBuscar (2).png")));
		buscar.setForeground(new Color(255, 255, 255));
		buscar.setBackground(new Color(255, 255, 255));
		buscar.setFont(new Font("Arial", Font.PLAIN, 11));
		buscar.setBounds(643, 26, 53, 21);
		contentPane.add(buscar);

		textField = new JTextField();
		textField.setBounds(296, 26, 325, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(20, 56, 1104, 358);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(modeloTabela);
		scrollPane.setViewportView(table);

		sair = new JButton("SAIR");
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
		sair.setFont(new Font("Arial", Font.BOLD, 11));
		sair.setBounds(1039, 25, 85, 21);
		contentPane.add(sair);

		JLabel livrariaDeAlexandria = new JLabel("LIVRARIA DE ALEXANDRIA");
		livrariaDeAlexandria.setBounds(22, 28, 167, 14);
		contentPane.add(livrariaDeAlexandria);
		livrariaDeAlexandria.setFont(new Font("Arial", Font.ITALIC, 12));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(147, 178, 245));
		setJMenuBar(menuBar);

		JMenu perfil = new JMenu("Perfil");
		menuBar.add(perfil);

		JMenu ajuda = new JMenu("Ajuda");
		menuBar.add(ajuda);
		JMenuItem tutorial = new JMenuItem("Tutorial");
		tutorial.setFont(new Font("Arial", Font.PLAIN, 12));
		tutorial.setForeground(new Color(192, 192, 192));
		ajuda.add(tutorial);

		tutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirTutorial();
			}

		});
		JMenu mural = new JMenu("Mural");
		menuBar.add(mural);

		JMenuItem abrirMural = new JMenuItem("Abrir Mural");
		mural.add(abrirMural);

		abrirMural.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaMural();
			}
		});

		JMenu redeSocialMenu = new JMenu("Rede Social");
		redeSocialMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(redeSocialMenu);

		JMenuItem instagram = new JMenuItem("Instagram",
				new ImageIcon(JPrincipal.class.getResource("/Imagens/b9d62ad2-bf33-460d-99ff-3e9b52b1a6a3 (1).png")));
		redeSocialMenu.add(instagram);

		JMenuItem whatsApp = new JMenuItem("WhatsApp",
				new ImageIcon(JPrincipal.class.getResource("/Imagens/96898964-fe33-44d6-aafa-18515cb8fc15 (1).png")));
		redeSocialMenu.add(whatsApp);

		JMenuItem x = new JMenuItem("X", new ImageIcon(JPrincipal.class.getResource("/Imagens/NovoX (1).png")));
		redeSocialMenu.add(x);

		// Adicionando um ActionListener para o botão "Buscar"
		buscar.addActionListener(e -> buscarLivros());
	}

	private void buscarLivros() {
		String termoBusca = textField.getText().toLowerCase();

		// Verifica se o campo de busca está vazio
		if (termoBusca.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Digite um termo para realizar a busca.");
			return; // Sai do método sem realizar a busca
		}
		// Filtra os livros com base no termo de busca (insensível a maiúsculas e
		// minúsculas)
		ArrayList<Livro> livrosFiltrados = new ArrayList<>();
		for (Livro livro : livro) {
			if (livro.getTituloDoLivro().toLowerCase().contains(termoBusca)
					|| livro.getAutor().toLowerCase().contains(termoBusca)) {
				livrosFiltrados.add(livro);
			}
		}

		// Atualiza o modelo da tabela com os livros filtrados
		modeloTabela = new ModeloTabela(livrosFiltrados);
		table.setModel(modeloTabela);

		// Adicione esta parte para informar sobre a compra ou perguntar se deseja
		// comprar outro
		if (livrosFiltrados.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Nenhum livro encontrado.");
		} else {
			int opcao = JOptionPane.showConfirmDialog(this, "Deseja comprar algum desses livros?", "Compra",
					JOptionPane.YES_NO_OPTION);

			if (opcao == JOptionPane.YES_OPTION) {
				// Implemente a lógica de compra aqui ou abra outra janela para a compra
				JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!");

				JFormaPagamento formaPagamentoFrame = new JFormaPagamento();
				formaPagamentoFrame.setVisible(true);

				// Pergunta se o usuário deseja fazer outra busca
				int continuarBusca = JOptionPane.showConfirmDialog(this, "Deseja fazer outra busca?",
						"Buscar Outro Livro", JOptionPane.YES_NO_OPTION);

				if (continuarBusca == JOptionPane.YES_OPTION) {
					// Limpar o campo de busca e resetar a tabela
					textField.setText("");
					modeloTabela = new ModeloTabela(livro);
					table.setModel(modeloTabela);
				} else {
					JOptionPane.showMessageDialog(this, "Obrigado por visitar!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Obrigado por visitar!");
			}
		}

	}

	private void abrirTelaMural() {
		JMural muralFrame = new JMural();
		muralFrame.setVisible(true);
	}

	private void exibirTutorial() {
		// Aqui você pode exibir as informações do tutorial em uma JOptionPane
		String tutorialMessage = "Bem-vindo ao Tutorial!\n\n" + "1. Digite o termo de busca na caixa de texto.\n"
				+ "2. Clique no ícone de busca ou pressione Enter para buscar livros.\n"
				+ "3. Selecione um livro na tabela.\n" + "4. Clique em 'Comprar' se desejar comprar o livro.\n"
				+ "5. Se desejar sair, clique em 'SAIR' no canto superior direito.\n\n"
				+ "Divirta-se explorando a livraria de Alexandria!";

		JOptionPane.showMessageDialog(this, tutorialMessage, "Tutorial de Uso", JOptionPane.INFORMATION_MESSAGE);
	}
}
