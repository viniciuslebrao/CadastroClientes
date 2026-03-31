package projeto.CadastroClientes.ItemPedido.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.CadastroClientes.ItemPedido.CompositeKey.ItemPedidoId;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoCreateDTO {

    private ItemPedidoId id;

    @NotNull
    @Min(1)
    private Long produto;

    @NotNull
    @Min(1)
    private Long pedido;

    @NotNull
    private BigDecimal precoPedido;

    @NotNull
    private Integer quantidadePedido;
}
