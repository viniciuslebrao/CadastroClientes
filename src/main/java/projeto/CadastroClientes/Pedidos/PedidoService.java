package projeto.CadastroClientes.Pedidos;

import java.util.List;
import java.util.Optional;

public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository){
        this.repository = repository;
    }

    public List<PedidosModel> consultarPedidos(){
        return repository.findAll();
    }

    public PedidosModel consultarPedidoId(Long id){
        Optional<PedidosModel> pedidoId = repository.findById(id);
        return pedidoId.orElse(null);
    }

    public PedidosModel realizarPedido(PedidosModel pedido){
        return repository.save(pedido);
    }

    public PedidosModel atualizarPedidoId(Long id, PedidosModel pedido){
        if(!repository.existsById(id)){
            return null;
        }
        pedido.setId(id);
        return repository.save(pedido);
    }

    public void deletarPedido(Long id){
        repository.deleteById(id);
    }
}
