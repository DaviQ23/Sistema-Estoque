public class ProdutoPerecivel extends Product {
    private int diasParaVencer;

    public ProdutoPerecivel(
            String nome,
            double preco,
            int quantidade,
            int diasParaVencer) throws QuantidadeInvalidaException {
        super(nome, preco, quantidade);
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcularValorTotal() {
        double valorTotal = getPreco() * getQuantidade();

        if (diasParaVencer <= 3) {
            valorTotal *= 0.80;
        }

        return valorTotal;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao()
                + " | Dias para vencer: " + diasParaVencer;
    }
}
