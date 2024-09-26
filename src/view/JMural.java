package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;

import model.Livro;
import model.ModeloTabela;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JMural extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<Livro> livro;
	private ModeloTabela modeloTabela;

    private JFormattedTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMural frame = new JMural();
					frame.setLocationRelativeTo(frame);
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
	public JMural() {

		livro = new ArrayList<>();
		livro.add(new Livro(21, "Cem Anos de Solidão", 448, "Gabriel García Márquez", 10.00));
		livro.add(new Livro(22, "Crime e Castigo", 576, "Fiódor Dostoiévski", 10.00));
		livro.add(new Livro(23, "A Menina que Roubava Livros", 480, "Markus Zusak", 10.00));
		livro.add(new Livro(24, "O Poder do Hábito", 408, "Charles Duhigg", 10.00));
		livro.add(new Livro(25, "O Senhor dos Anéis", 1178, "J.R.R. Tolkien", 10.00));

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 207, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton buscar = new JButton("");
		buscar.setIcon(new ImageIcon(JMural.class.getResource("/Imagens/IconBuscar (2).png")));
		buscar.setForeground(new Color(255, 255, 255));
		buscar.setBackground(new Color(255, 255, 255));
		buscar.setFont(new Font("Arial", Font.PLAIN, 11));
		buscar.setBounds(675, 54, 85, 21);
		contentPane.add(buscar);

		JFormattedTextField textField = new JFormattedTextField();
		textField.setBounds(105, 54, 546, 19);
		contentPane.add(textField);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 107, 731, 104);
		contentPane.add(scrollPane);

		ModeloTabela modeloTabela = new ModeloTabela(livro);
		
		
		table = new JTable();
		table.setModel(modeloTabela);
		scrollPane.setViewportView(table);
		
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
		sair.setBackground(new Color(244, 0, 0));
		sair.setForeground(new Color(255, 255, 255));
		sair.setFont(new Font("Arial", Font.BOLD, 11));
		sair.setBounds(675, 10, 85, 21);
		contentPane.add(sair);
		
		JLabel livrariaDeAlexandria = new JLabel("LIVRARIA DE ALEXANDRIA");
		livrariaDeAlexandria.setBounds(29, 10, 227, 13);
		contentPane.add(livrariaDeAlexandria);
		
		Button voltar = new Button("<-");
		voltar.setForeground(new Color(0, 0, 0));
		voltar.setBackground(new Color(0, 0, 255));
		voltar.setBounds(0, 0, 24, 21);
		contentPane.add(voltar);
		
		 voltar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Adicione aqui a lógica para voltar para a JPrincipal
	                dispose(); // Fecha a janela atual (JMural)
	                JPrincipal jPrincipal = new JPrincipal();
	                jPrincipal.setLocationRelativeTo(null); // Centraliza a janela na tela
	                jPrincipal.setVisible(true); // Torna a JPrincipal visível
	            }
	        });
		

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
	
}
