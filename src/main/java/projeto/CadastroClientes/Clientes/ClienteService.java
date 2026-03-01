package projeto.CadastroClientes.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    //Listar clientes
    public List<ClienteModel> listarClientes(){
        return repository.findAll();
    }

    //Listar por ID
    public ClienteModel listarClientePorId(Long id){
        Optional<ClienteModel> clienteId = repository.findById(id);
        return clienteId.orElse(null);
    }

    //Adicionar cliente
    public ClienteModel cadastrarCliente(ClienteModel cliente){
        return repository.save(cliente);
    }

    //Atualizar dados do cliente
    public ClienteModel atualizarCliente(ClienteModel cliente){
        return repository.save(cliente);
    }

    //Deletar cliente
    public void deletarCliente(Long id){
        repository.deleteById(id);

    }



}


