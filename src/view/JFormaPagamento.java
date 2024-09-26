package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class JFormaPagamento extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ButtonGroup buttonGroup;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFormaPagamento frame = new JFormaPagamento();
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
    public JFormaPagamento() {
        setBounds(100, 100, 1160, 645);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 187, 125));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel livrariaDeAlexandria = new JLabel("LIVRARIA DE ALEXANDRIA");
        livrariaDeAlexandria.setFont(new Font("Arial", Font.ITALIC, 17));
        livrariaDeAlexandria.setBounds(10, 10, 320, 13);
        contentPane.add(livrariaDeAlexandria);

        buttonGroup = new ButtonGroup();

        JRadioButton boleto = new JRadioButton("BOLETO");
        boleto.setFont(new Font("Arial", Font.PLAIN, 15));
        boleto.setBackground(new Color(255, 187, 125));
        boleto.setBounds(10, 47, 103, 21);
        contentPane.add(boleto);
        buttonGroup.add(boleto);

        JRadioButton pix = new JRadioButton("PIX");
        pix.setFont(new Font("Arial", Font.PLAIN, 15));
        pix.setBackground(new Color(255, 187, 125));
        pix.setBounds(10, 133, 103, 21);
        contentPane.add(pix);
        buttonGroup.add(pix);

        JTextField txtNumeroCartao = new JTextField();
        txtNumeroCartao.setBounds(10, 239, 400, 21);
        contentPane.add(txtNumeroCartao);

        JButton btnNewButton = new JButton("Adicionar um cartão de crédito");
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
        btnNewButton.setBounds(10, 270, 400, 21);
        contentPane.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the button click event here
                // Validate the credit card number
                String cardNumber = txtNumeroCartao.getText().trim();
                if (isValidCreditCardNumber(cardNumber)) {
                    // For simplicity, let's show a message dialog
                    JOptionPane.showMessageDialog(contentPane, "Número do Cartão de Crédito válido: " + cardNumber);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Número do Cartão de Crédito inválido. Por favor, verifique.");
                }
            }
        });

        JLabel fotoPagamento = new JLabel("");
        fotoPagamento.setForeground(new Color(255, 255, 255));
        fotoPagamento.setBackground(new Color(240, 240, 240));
        fotoPagamento.setIcon(new ImageIcon(JFormaPagamento.class.getResource("/Imagens/pagamentoNOVO (1).png")));
        fotoPagamento.setBounds(883, 10, 233, 205);
        contentPane.add(fotoPagamento);

        JLabel textoPix = new JLabel("O código Pix gerado para o pagamento é válido por 30 minutos após a finalização por pedido.");
        textoPix.setFont(new Font("Arial", Font.PLAIN, 15));
        textoPix.setBounds(10, 147, 632, 60);
        contentPane.add(textoPix);

        JLabel textoBoleto = new JLabel("O boleto bancário será gerado após a confirmação da compra.");
        textoBoleto.setFont(new Font("Arial", Font.PLAIN, 15));
        textoBoleto.setBounds(10, 80, 429, 21);
        contentPane.add(textoBoleto);

        JButton cancela = new JButton("CANCELA");
        cancela.setBackground(new Color(224, 29, 49));
        cancela.setFont(new Font("Arial", Font.PLAIN, 15));
        cancela.setBounds(10, 566, 134, 21);
        contentPane.add(cancela);
        
        cancela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Realize as ações de cancelamento aqui
                // Por exemplo, feche a janela atual
                dispose();
            }
        });

        JButton confirma = new JButton("CONFIRMAR");
        confirma.setBackground(new Color(0, 128, 0));
        confirma.setFont(new Font("Arial", Font.PLAIN, 15));
        confirma.setBounds(154, 567, 146, 21);
        contentPane.add(confirma);
        
     // Adiciona um ouvinte de ação ao botão de confirmação
        confirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Realize as ações de confirmação aqui
                // Por exemplo, exiba uma mensagem de confirmação
                JOptionPane.showMessageDialog(contentPane, "Compra confirmada!");
            }
        });
    }

    

    // Função para validar o número do cartão de crédito
    private boolean isValidCreditCardNumber(String cardNumber) {
        // Aqui você pode implementar a lógica de validação do número do cartão de crédito
        // Por exemplo, verificar se o comprimento do número está correto, se é um número válido, etc.
        // Esta implementação é simples e só verifica se o comprimento é maior que 0
        return cardNumber.length() > 0;
    }
}
