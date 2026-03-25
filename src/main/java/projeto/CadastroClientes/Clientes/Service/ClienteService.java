package projeto.CadastroClientes.Clientes.Service;

import org.springframework.stereotype.Service;
import projeto.CadastroClientes.Clientes.Mapper.ClienteMapper;
import projeto.CadastroClientes.Clientes.DTO.ClienteDTO;
import projeto.CadastroClientes.Clientes.Model.ClienteModel;
import projeto.CadastroClientes.Clientes.Repository.ClienteRepository;
import projeto.CadastroClientes.Handler.EntidadeNaoEncontradaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

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
    public ClienteDTO listarClientePorId(Long id) throws EntidadeNaoEncontradaException {
        return repository.findById(id).map(mapper::map).orElseThrow(() -> new EntidadeNaoEncontradaException("ID não encontrado! "+ id));
    }

    //Adicionar cliente
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO){
        ClienteModel cliente = mapper.map(clienteDTO);
        repository.save(cliente);
        return mapper.map(cliente);
    }

    //Atualizar dados do clienteDTO
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) throws EntidadeNaoEncontradaException{
        Optional<ClienteModel> clienteId = repository.findById(id);
        if(clienteId.isPresent()){
            ClienteModel clienteAtualizado =  mapper.map(clienteDTO);
            clienteAtualizado.setId(id);
            repository.save(clienteAtualizado);
            return mapper.map(clienteAtualizado);
        }
        throw new EntidadeNaoEncontradaException("ID não encontrado! "+ id);
    }

    //Deletar cliente
    public void deletarCliente(Long id) throws EntidadeNaoEncontradaException{
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
        else{
            throw new EntidadeNaoEncontradaException("ID não encontrado");
        }
    }



}


