package projeto.CadastroClientes.Clientes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    ClienteModel findById(int id);

}
