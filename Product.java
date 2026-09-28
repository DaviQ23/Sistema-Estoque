public abstract class Product implements Vendavel {
    private String nome;
    private double preco;
    private int quantidade;

    public Product(String nome, double preco, int quantidade)
            throws QuantidadeInvalidaException {
        if (preco < 0 || quantidade < 0) {
            throw new QuantidadeInvalidaException(
                    "O preco e a quantidade nao podem ser negativos.");
        }

        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public abstract double calcularValorTotal();

    public String getDescricao() {
        return String.format(
                "%s | Preco: R$ %.2f | Quantidade: %d",
                nome, preco, quantidade);
    }

    @Override
    public void vender(int quantidadeDesejada)
            throws ProdutoIndisponivelException {
        if (quantidadeDesejada <= 0) {
            throw new ProdutoIndisponivelException(
                    "A quantidade da venda deve ser maior que zero.");
        }

        if (quantidadeDesejada > quantidade) {
            throw new ProdutoIndisponivelException(
                    "Estoque insuficiente para o produto " + nome + ".");
        }

        quantidade -= quantidadeDesejada;
    }

    public void aplicarDesconto(double percentual) {
        preco -= preco * percentual / 100.0;
    }

    public void aplicarDesconto(double percentual, double descontoMaximo) {
        double descontoCalculado = preco * percentual / 100.0;
        double descontoAplicado = Math.min(descontoCalculado, descontoMaximo);
        preco -= descontoAplicado;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
