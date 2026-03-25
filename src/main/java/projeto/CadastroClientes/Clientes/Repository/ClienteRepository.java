package projeto.CadastroClientes.Clientes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.CadastroClientes.Clientes.Model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {


}
