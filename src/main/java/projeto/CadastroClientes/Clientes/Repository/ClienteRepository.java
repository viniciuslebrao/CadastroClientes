package projeto.CadastroClientes.Clientes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.CadastroClientes.Clientes.Model.ClienteModel;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    Optional<ClienteModel> findByEmail(String email);


}
