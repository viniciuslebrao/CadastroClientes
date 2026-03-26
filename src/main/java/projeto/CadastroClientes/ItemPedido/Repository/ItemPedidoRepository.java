package projeto.CadastroClientes.ItemPedido.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.CadastroClientes.ItemPedido.Model.ItemPedidoModel;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, Long> {

    List<ItemPedidoModel> findByIdIdPedido(Long idPedido);
}
