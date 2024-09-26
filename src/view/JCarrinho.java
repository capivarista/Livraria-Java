package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Livro;
import model.ModeloTabela;

public class JCarrinho extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private ModeloTabela modeloTabela;
    private ArrayList<Livro> carrinho;

    public JCarrinho(ArrayList<Livro> carrinho) {
        this.carrinho = carrinho;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1177, 655);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(151, 14, 190));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 71, 1020, 447);
        contentPane.add(scrollPane);

        modeloTabela = new ModeloTabela(carrinho);
        table = new JTable(modeloTabela);
        scrollPane.setViewportView(table);

        // Botão 'buscar'
        JButton buscar = new JButton("");
        buscar.setIcon(new ImageIcon(JPrincipal.class.getResource("/Imagens/IconBuscar (2).png")));
        buscar.setForeground(new Color(255, 255, 255));
        buscar.setBackground(new Color(255, 255, 255));
        buscar.setFont(new Font("Arial", Font.PLAIN, 11));
        buscar.setBounds(432, 28, 53, 21);
        contentPane.add(buscar);

        JTextField textoBuscal = new JTextField();
        textoBuscal.setBounds(79, 28, 325, 19);
        contentPane.add(textoBuscal);
        textoBuscal.setColumns(10);

        // ActionListener para o botão 'buscar'
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String termoBusca = textoBuscal.getText().trim();

                if (!termoBusca.isEmpty()) {
                    if (confirmarExistenciaNoCarrinho(termoBusca)) {
                        JOptionPane.showMessageDialog(null, "Livro encontrado no carrinho!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Livro não encontrado no carrinho.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um termo de busca válido.");
                }
            }
        });

        // Botão 'SAIR'
        JButton sair = new JButton("SAIR");
        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmar Saída",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    System.exit(0); // Fecha a aplicação
                }
            }
        });
        sair.setBackground(new Color(244, 0, 0));
        sair.setForeground(new Color(255, 255, 255));
        sair.setFont(new Font("Arial", Font.BOLD, 11));
        sair.setBounds(1014, 35, 85, 21);
        contentPane.add(sair);

        // Botão 'Finalizar Compra'
        JButton finalizarCompra = new JButton("Finalizar Compra");
        finalizarCompra.setBounds(516, 583, 140, 25);
        contentPane.add(finalizarCompra);

        finalizarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalizarCompra();
            }
        });
    }

    private boolean confirmarExistenciaNoCarrinho(String termoBusca) {
        for (Livro livro : carrinho) {
            if (livro.getTituloDoLivro().toLowerCase().contains(termoBusca.toLowerCase())) {
                return true; // Livro encontrado no carrinho
            }
        }
        return false; // Livro não encontrado no carrinho
    }

    private void finalizarCompra() {
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar a compra?", "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            // Adicione aqui a lógica para finalizar a compra
            JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso!");
            JFormaPagamento formaPagamentoFrame = new JFormaPagamento();
            formaPagamentoFrame.setVisible(true);
            dispose(); // Fecha a janela do carrinho após a compra
        } else {
            JOptionPane.showMessageDialog(this, "Compra cancelada pelo usuário.");
        }
    }
}