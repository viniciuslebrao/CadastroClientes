package projeto.CadastroClientes.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    private final ClienteRepository repository;
    private ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
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
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO){
        ClienteModel cliente = mapper.map(clienteDTO);
        repository.save(cliente);
        return mapper.map(cliente);
    }

    //Atualizar dados do cliente
    public ClienteModel atualizarCliente(Long id, ClienteModel cliente){
        if(!repository.existsById(id)){
            return null;
        }
        cliente.setId(id);
        return repository.save(cliente);
    }

    //Deletar cliente
    public void deletarCliente(Long id){
        repository.deleteById(id);

    }



}


