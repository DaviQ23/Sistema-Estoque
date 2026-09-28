public class EstoqueApp {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        try {
            ProdutoComum caderno = new ProdutoComum("Caderno", 10.00, 8);
            ProdutoComum arroz = new ProdutoComum("Arroz", 25.00, 5);
            ProdutoPerecivel leite =
                    new ProdutoPerecivel("Leite", 6.00, 10, 2);
            ProdutoPerecivel bolo =
                    new ProdutoPerecivel("Bolo", 50.00, 2, 7);

            estoque.adicionarProduto(caderno);
            estoque.adicionarProduto(arroz);
            estoque.adicionarProduto(leite);
            estoque.adicionarProduto(bolo);

            caderno.aplicarDesconto(10);
            arroz.aplicarDesconto(20, 2.00);

            System.out.println("PRODUTOS CADASTRADOS");
            estoque.listarProdutos();

            System.out.printf(
                    "%nValor total inicial: R$ %.2f%n",
                    estoque.calcularValorTotalEstoque());

            estoque.venderProduto(0, 2);
            System.out.println("\nVenda de 2 cadernos realizada com sucesso.");

            try {
                estoque.venderProduto(0, 100);
            } catch (ProdutoIndisponivelException e) {
                System.out.println("Erro na venda: " + e.getMessage());
            }

            System.out.printf(
                    "Valor total apos a venda: R$ %.2f%n",
                    estoque.calcularValorTotalEstoque());

        } catch (QuantidadeInvalidaException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        } catch (ProdutoIndisponivelException e) {
            System.out.println("Erro inesperado na venda: " + e.getMessage());
        }

        try {
            new ProdutoComum("Produto invalido", 20.00, -5);
        } catch (QuantidadeInvalidaException e) {
            System.out.println("Erro esperado no cadastro: " + e.getMessage());
        }
    }
}
