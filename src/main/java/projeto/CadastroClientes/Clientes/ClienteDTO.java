package projeto.CadastroClientes.Clientes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.CadastroClientes.Pedidos.PedidosModel;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {


    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private List<PedidosModel> pedidos;

}
