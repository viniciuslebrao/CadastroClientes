package projeto.CadastroClientes.Pedidos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.CadastroClientes.Pedidos.StatusPedido;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDTO {


    private Long id;

    private Long clienteId;

    private StatusPedido status;

    private LocalDateTime dataPedido;

    private LocalDateTime dataFinalizado;

}
