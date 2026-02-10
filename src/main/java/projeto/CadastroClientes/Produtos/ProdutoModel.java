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
    private Long id;
    private String nomeProduto;
    private String nomeMarca;
    private Double preco;
    private Integer quantidade;


}
