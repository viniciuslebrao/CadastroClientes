package projeto.CadastroClientes.ItemPedido.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.CadastroClientes.ItemPedido.CompositeKey.ItemPedidoId;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoResponseDTO {

    private ItemPedidoId id;

    private Long produto;

    private Long pedido;

    private BigDecimal precoPedido;

    private Integer quantidadePedido;

}
