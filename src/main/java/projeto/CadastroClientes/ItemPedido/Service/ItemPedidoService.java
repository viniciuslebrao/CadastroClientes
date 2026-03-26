package projeto.CadastroClientes.ItemPedido.Service;

import org.springframework.stereotype.Service;
import projeto.CadastroClientes.ItemPedido.CompositeKey.ItemPedidoId;
import projeto.CadastroClientes.ItemPedido.Model.ItemPedidoModel;
import projeto.CadastroClientes.ItemPedido.Repository.ItemPedidoRepository;

import java.util.List;

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
