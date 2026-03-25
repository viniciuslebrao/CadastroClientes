package projeto.CadastroClientes.Pedidos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.CadastroClientes.ItemPedido.ItemPedidoModel;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidosDTO {


    private Long id;

    private Long clienteId;

    private StatusPedido status;

    private LocalDateTime dataPedido;

    private LocalDateTime dataFinalizado;

    private List<ItemPedidoModel> itens;
}
