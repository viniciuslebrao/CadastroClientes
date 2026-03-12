package projeto.CadastroClientes.ItemPedido;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {
    private ItemPedidoRepository repository;

    public ItemPedidoService(ItemPedidoRepository repository){
        this.repository = repository;
    }

    public List<ItemPedidoModel> listarItensPedido(Long idPedido){
        return repository.findByIdIdPedido(idPedido);
    }

    public ItemPedidoModel adicionarItem(ItemPedidoModel item){
        item.setId(new ItemPedidoId(item.getPedido().getId(), item.getProduto().getId()));
        return repository.save(item);
    }
}
