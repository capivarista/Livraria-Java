package model;

public class PedidoLivraria {
    private int numeroPedido;
    private Livro livro;
    private int quantidade;

    public PedidoLivraria(int numeroPedido, Livro livro, int quantidade) {
        this.numeroPedido = numeroPedido;
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularValorTotal() {
        return livro.getPreco() * quantidade;
    }

    public void imprimirDetalhesPedido() {
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("Livro: " + livro.getTituloDoLivro());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor Total: " + calcularValorTotal());
    }
}
