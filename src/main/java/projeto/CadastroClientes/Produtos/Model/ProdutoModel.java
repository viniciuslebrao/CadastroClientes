package projeto.CadastroClientes.Produtos.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "tb_produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_do_produto", nullable = false)
    private String nomeProduto;

    @Column(name = "marca_do_produto")
    private String nomeMarca;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "quantidade_em_estoque", nullable = false)
    private Integer quantidade;

    @Column(name = "imagem_produto")
    private String imagemProduto;


}
