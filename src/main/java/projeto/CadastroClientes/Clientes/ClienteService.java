package projeto.CadastroClientes.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repository) {
        this.clienteRepository = repository;
    }

    //Listar clientes
    public List<ClienteModel> listarClientes(){
        return clienteRepository.findAll();
    }

    //Listar por ID
    public ClienteModel listarClientePorId(Long id){
        Optional<ClienteModel> clienteId = clienteRepository.findById(id);
        return clienteId.orElse(null);
    }

    //Adicionar cliente
    public ClienteModel cadastrarCliente(){
        ClienteModel user = new ClienteModel();
        return clienteRepository.save(user);
    }



}


