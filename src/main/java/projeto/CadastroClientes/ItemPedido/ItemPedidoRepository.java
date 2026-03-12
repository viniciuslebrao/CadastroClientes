package projeto.CadastroClientes.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, Long> {

    List<ItemPedidoModel> findByIdIdPedido(Long idPedido);
}
