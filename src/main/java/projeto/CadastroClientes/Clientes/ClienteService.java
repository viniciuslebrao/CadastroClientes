package projeto.CadastroClientes.Clientes;

import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repository) {
        this.repo = repository;
    }

    //Listar clientes
    public List<ClienteModel> listarClientes(){
        return repo.findAll();
    }

    //Adicionar cliente
    public ClienteModel cadastrarCliente(){
        ClienteModel user = new ClienteModel();
        return repo.save(user);
    }


}


