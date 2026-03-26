package projeto.CadastroClientes.Pedidos.Mapper;

import org.springframework.stereotype.Component;
import projeto.CadastroClientes.Clientes.Model.ClienteModel;
import projeto.CadastroClientes.Pedidos.DTO.PedidosDTO;
import projeto.CadastroClientes.Pedidos.Model.PedidosModel;

@Component
public class PedidoMapper {

    public PedidosModel map(PedidosDTO pedidoDTO){
        PedidosModel pedidosModel = new PedidosModel();
        pedidosModel.setId(pedidoDTO.getId());
        pedidosModel.setDataPedido(pedidoDTO.getDataPedido());
        pedidosModel.setStatus(pedidoDTO.getStatus());
        if(pedidoDTO.getClienteId() != null){
            ClienteModel cliente = new ClienteModel();
            cliente.setId(pedidoDTO.getClienteId());
            pedidosModel.setCliente(cliente);
        }
        pedidosModel.setItens(pedidoDTO.getItens());

        return pedidosModel;
    }

    public PedidosDTO map(PedidosModel pedidosModel){
        PedidosDTO pedidosDTO = new PedidosDTO();
        pedidosDTO.setId(pedidosModel.getId());
        pedidosDTO.setDataPedido(pedidosModel.getDataPedido());
        pedidosDTO.setStatus(pedidosModel.getStatus());
        pedidosDTO.setClienteId(pedidosModel.getCliente().getId());
        pedidosDTO.setItens(pedidosModel.getItens());

        return pedidosDTO;
    }
}
