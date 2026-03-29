package projeto.CadastroClientes.Pedidos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.CadastroClientes.Pedidos.StatusPedido;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoUpdateDTO {

    private Long id;

    private StatusPedido status;

    private LocalDateTime dataFinalizado;
}
