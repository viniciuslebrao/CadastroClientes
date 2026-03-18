package projeto.CadastroClientes.Clientes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ClienteDTO> listarClientes(){
        List<ClienteModel> clientes = repository.findAll();
        List<ClienteDTO> clienteDTO = new ArrayList<>();
        for(ClienteModel cliente: clientes){
            clienteDTO.add(mapper.map(cliente));
        }
        return clienteDTO;
    }

    //Listar por ID
    public ClienteDTO listarClientePorId(Long id){
        return repository.findById(id).map(mapper::map).orElseThrow(() -> new RuntimeException("Cliente não cadastrado!"));
    }

    //Adicionar cliente
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO){
        ClienteModel cliente = mapper.map(clienteDTO);
        repository.save(cliente);
        return mapper.map(cliente);
    }

    //Atualizar dados do clienteDTO
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO){
        Optional<ClienteModel> clienteId = repository.findById(id);
        if(clienteId.isPresent()){
            ClienteModel clienteAtualizado =  mapper.map(clienteDTO);
            clienteAtualizado.setId(id);
            repository.save(clienteAtualizado);
            return mapper.map(clienteAtualizado);
        }
        return null;
    }

    //Deletar cliente
    public void deletarCliente(Long id){
        repository.deleteById(id);

    }



}


