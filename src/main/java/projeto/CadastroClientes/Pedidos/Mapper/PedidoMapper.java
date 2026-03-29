package projeto.CadastroClientes.Pedidos.Mapper;

import org.springframework.stereotype.Component;
import projeto.CadastroClientes.Clientes.Model.ClienteModel;
import projeto.CadastroClientes.Pedidos.DTO.PedidoCreateDTO;
import projeto.CadastroClientes.Pedidos.DTO.PedidoUpdateDTO;
import projeto.CadastroClientes.Pedidos.DTO.PedidoResponseDTO;
import projeto.CadastroClientes.Pedidos.Model.PedidosModel;

@Component
public class PedidoMapper {

    public PedidosModel mapCreate(PedidoCreateDTO pedidoDTO){
        PedidosModel pedidosModel = new PedidosModel();
        ClienteModel cliente = new ClienteModel();

        cliente.setId(pedidoDTO.getClienteId());
        pedidosModel.setCliente(cliente);


        return pedidosModel;
    }
    public void mapUpdate(PedidoUpdateDTO pedidoDTO, PedidosModel pedidosModel){
        if(pedidoDTO.getStatus() != null){
            pedidosModel.setStatus(pedidoDTO.getStatus());
        }
        if(pedidoDTO.getDataFinalizado() != null){
            pedidosModel.setDataFinalizado(pedidoDTO.getDataFinalizado());
        }

    }

    public PedidoResponseDTO mapResponse(PedidosModel pedidosModel){
        PedidoResponseDTO pedidosDTO = new PedidoResponseDTO();
        pedidosDTO.setId(pedidosModel.getId());
        pedidosDTO.setDataPedido(pedidosModel.getDataPedido());
        pedidosDTO.setStatus(pedidosModel.getStatus());
        if(pedidosModel.getCliente() != null) {
            pedidosDTO.setClienteId(pedidosModel.getCliente().getId());
        }
        return pedidosDTO;
    }

}
