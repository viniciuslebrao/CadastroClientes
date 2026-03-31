package projeto.CadastroClientes.Produtos.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCreateDTO {

    private Long id;

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String nomeMarca;

    @Min(1)
    private BigDecimal preco;

    @Min(0)
    private Integer quantidade;

    private String imagemProduto;

}
