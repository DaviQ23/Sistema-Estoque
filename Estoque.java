import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Product> produtos;

    public Estoque() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Product produto) {
        produtos.add(produto);
    }

    public void venderProduto(int indice, int quantidade)
            throws ProdutoIndisponivelException {
        produtos.get(indice).vender(quantidade);
    }

    public double calcularValorTotalEstoque() {
        double total = 0;

        for (Product produto : produtos) {
            total += produto.calcularValorTotal();
        }

        return total;
    }

    public void listarProdutos() {
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(i + " - " + produtos.get(i).getDescricao());
        }
    }
}
