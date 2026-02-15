package projeto.CadastroClientes.Produtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    @Column(name = "nome_do_produto")
    private String nomeProduto;

    @Column(name = "marca_do_produto")
    private String nomeMarca;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "quantidade_em_estoque")
    private Integer quantidade;


}
