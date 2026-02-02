package projeto.CadastroClientes.Produtos;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private String nomeMarca;
    private Double preco;
    private Integer quantidade;

    public ProdutoModel() {}

    public ProdutoModel(String nomeProduto, String nomeMarca, Double preco, Integer quantidade) {
        this.nomeProduto = nomeProduto;
        this.nomeMarca = nomeMarca;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
