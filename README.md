# Sistema de Estoque de Produtos

Solução simples do exercício de Paradigmas de Linguagens de Programação.

## Como executar

No terminal, entre nesta pasta e execute:

```bash
javac *.java
java EstoqueApp
```

## Conceitos usados

- Classe abstrata: `Product`.
- Herança: `ProdutoComum` e `ProdutoPerecivel` herdam de `Product`.
- Interface: `Vendavel` é implementada por `Product`.
- Polimorfismo dinâmico: cada produto implementa `calcularValorTotal()`.
- Polimorfismo estático: duas versões de `aplicarDesconto()`.
- Composição: `Estoque` possui uma lista de produtos.
- Exceções: `QuantidadeInvalidaException` e `ProdutoIndisponivelException`.

O programa cadastra quatro produtos, aplica as duas formas de desconto, faz uma
venda válida, tenta uma venda acima do estoque e tenta criar um produto com
quantidade negativa.
