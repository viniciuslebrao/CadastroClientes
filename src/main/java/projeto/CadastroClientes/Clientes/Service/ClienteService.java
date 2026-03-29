package projeto.CadastroClientes.Clientes.Service;

import org.springframework.stereotype.Service;
import projeto.CadastroClientes.Clientes.DTO.ClienteResponseDTO;
import projeto.CadastroClientes.Clientes.DTO.ClienteUpdateDTO;
import projeto.CadastroClientes.Clientes.Mapper.ClienteMapper;
import projeto.CadastroClientes.Clientes.DTO.ClienteCreateDTO;
import projeto.CadastroClientes.Clientes.Model.ClienteModel;
import projeto.CadastroClientes.Clientes.Repository.ClienteRepository;
import projeto.CadastroClientes.Handler.EntidadeNaoEncontradaException;
import java.util.List;



@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //Listar clientes
    public List<ClienteResponseDTO> listarClientes(){
        List<ClienteModel> clientes = repository.findAll();
        return clientes.stream()
                .map(mapper::mapResponse)
                .toList();
    }

    //Listar por ID
    public ClienteResponseDTO listarClientePorId(Long id) throws EntidadeNaoEncontradaException {
        return repository.findById(id)
                .map(mapper::mapResponse)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("ID não encontrado! "+ id));
    }

    //Adicionar cliente
    public ClienteResponseDTO cadastrarCliente(ClienteCreateDTO clienteDTO){
        repository.findByEmail(clienteDTO.getEmail()).ifPresent(c -> {throw new IllegalArgumentException("Email já cadastrado!");});
        ClienteModel cliente = mapper.mapCreate(clienteDTO);
        repository.save(cliente);
        return mapper.mapResponse(cliente);
    }

    //Atualizar dados do clienteDTO
    public ClienteResponseDTO atualizarCliente(Long id, ClienteUpdateDTO clienteDTO) throws EntidadeNaoEncontradaException{
        ClienteModel clienteExistente = repository.findById(id)
                .orElseThrow(()-> new EntidadeNaoEncontradaException("ID não encontrado! "+ id));
        mapper.mapUpdate(clienteDTO, clienteExistente);
        repository.save(clienteExistente);
        return mapper.mapResponse(clienteExistente);
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


