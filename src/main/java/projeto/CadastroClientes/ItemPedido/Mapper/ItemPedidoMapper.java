package projeto.CadastroClientes.ItemPedido.Mapper;

import org.springframework.stereotype.Component;
import projeto.CadastroClientes.ItemPedido.DTO.ItemPedidoCreateDTO;
import projeto.CadastroClientes.ItemPedido.DTO.ItemPedidoResponseDTO;
import projeto.CadastroClientes.ItemPedido.DTO.ItemPedidoUpdateDTO;
import projeto.CadastroClientes.ItemPedido.Model.ItemPedidoModel;


@Component
public class ItemPedidoMapper {

    public ItemPedidoModel mapCreate(ItemPedidoCreateDTO itemDTO){
        ItemPedidoModel itemModel = new ItemPedidoModel();
        itemModel.setPrecoPedido(itemDTO.getPrecoPedido());
        itemModel.setQuantidadePedido(itemDTO.getQuantidadePedido());

        return itemModel;
    }

    public void mapUpdate(ItemPedidoModel itemModel,ItemPedidoUpdateDTO itemDTO){
        itemModel.setQuantidadePedido(itemDTO.getQuantidadePedido());
    }

    public ItemPedidoResponseDTO mapResponse(ItemPedidoModel itemModel){
        ItemPedidoResponseDTO itemResponse = new ItemPedidoResponseDTO();

        itemResponse.setId(itemModel.getId());
        itemResponse.setPedido(itemModel.getPedido().getId());
        itemResponse.setProduto(itemModel.getProduto().getId());
        itemResponse.setQuantidadePedido(itemModel.getQuantidadePedido());
        itemResponse.setPrecoPedido(itemModel.getPrecoPedido());

        return itemResponse;
    }
}
