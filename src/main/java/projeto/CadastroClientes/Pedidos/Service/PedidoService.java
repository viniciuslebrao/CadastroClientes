package projeto.CadastroClientes.Pedidos.Service;

import org.springframework.stereotype.Service;
import projeto.CadastroClientes.Clientes.Model.ClienteModel;
import projeto.CadastroClientes.Clientes.Repository.ClienteRepository;
import projeto.CadastroClientes.Handler.EntidadeNaoEncontradaException;
import projeto.CadastroClientes.Pedidos.DTO.PedidoCreateDTO;
import projeto.CadastroClientes.Pedidos.DTO.PedidoUpdateDTO;
import projeto.CadastroClientes.Pedidos.DTO.PedidoResponseDTO;
import projeto.CadastroClientes.Pedidos.Mapper.PedidoMapper;
import projeto.CadastroClientes.Pedidos.Model.PedidosModel;
import projeto.CadastroClientes.Pedidos.Repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    private final ClienteRepository clienteRepository;
    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public PedidoService(PedidoRepository repository, PedidoMapper pedido, ClienteRepository clienteRepository){
        this.repository = repository;
        this.mapper = pedido;
        this.clienteRepository = clienteRepository;
    }

    public List<PedidoResponseDTO> consultarPedidos(){
        List<PedidosModel> pedidos = repository.findAll();
        return pedidos.stream()
                .map(mapper::mapResponse)
                .toList();
    }

    public PedidoResponseDTO consultarPedidoId(Long id) throws EntidadeNaoEncontradaException {
        return repository.findById(id)
                .map(mapper::mapResponse)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("ID não encontrado! "+ id));
    }

    public PedidoResponseDTO realizarPedido(PedidoCreateDTO pedido){
        PedidosModel pedidosModel = mapper.mapCreate(pedido);
        ClienteModel clienteModel = clienteRepository.getReferenceById(pedido.getClienteId());
        pedidosModel.setCliente(clienteModel);
        repository.save(pedidosModel);
        return mapper.mapResponse(pedidosModel);
    }

    public PedidoResponseDTO atualizarPedidoId(Long id, PedidoUpdateDTO pedido) throws EntidadeNaoEncontradaException{
        PedidosModel pedidoExistente = repository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("ID não encontrado! "+ id));
        mapper.mapUpdate(pedido, pedidoExistente);
        repository.save(pedidoExistente);
        return mapper.mapResponse(pedidoExistente);
    }

    public void deletarPedido(Long id) throws EntidadeNaoEncontradaException{
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else {
            throw new EntidadeNaoEncontradaException("ID não encontrado! "+ id);
        }

    }
}
