package projeto.CadastroClientes.ItemPedido.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.CadastroClientes.ItemPedido.CompositeKey.ItemPedidoId;
import projeto.CadastroClientes.ItemPedido.Model.ItemPedidoModel;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, ItemPedidoId> {

    List<ItemPedidoModel> findByIdIdPedido(Long idPedido);
}
