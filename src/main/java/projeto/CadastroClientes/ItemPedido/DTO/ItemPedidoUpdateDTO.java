package projeto.CadastroClientes.ItemPedido.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoUpdateDTO {

    private Long produto;

    private Long pedido;

    private BigDecimal precoPedido;

    private Integer quantidadePedido;
}
