package projeto.CadastroClientes.Pedidos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.CadastroClientes.Pedidos.Model.PedidosModel;

public interface PedidoRepository extends JpaRepository<PedidosModel, Long> {
}
