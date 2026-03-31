package projeto.CadastroClientes.Produtos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoUpdateDTO {

    private String nomeProduto;

    private String nomeMarca;

    private BigDecimal preco;

    private Integer quantidade;

    private String imagemProduto;
}
