package projeto.CadastroClientes.ItemPedido.Service;

import org.springframework.stereotype.Service;
import projeto.CadastroClientes.Handler.EntidadeNaoEncontradaException;
import projeto.CadastroClientes.ItemPedido.CompositeKey.ItemPedidoId;
import projeto.CadastroClientes.ItemPedido.DTO.ItemPedidoCreateDTO;
import projeto.CadastroClientes.ItemPedido.DTO.ItemPedidoResponseDTO;
import projeto.CadastroClientes.ItemPedido.DTO.ItemPedidoUpdateDTO;
import projeto.CadastroClientes.ItemPedido.Mapper.ItemPedidoMapper;
import projeto.CadastroClientes.ItemPedido.Model.ItemPedidoModel;
import projeto.CadastroClientes.ItemPedido.Repository.ItemPedidoRepository;
import projeto.CadastroClientes.Pedidos.Model.PedidosModel;
import projeto.CadastroClientes.Pedidos.Repository.PedidoRepository;
import projeto.CadastroClientes.Produtos.Model.ProdutoModel;
import projeto.CadastroClientes.Produtos.Repository.ProdutoRepository;

import java.util.List;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository repository;
    private final ItemPedidoMapper mapper;
    private final ProdutoRepository produtoRepository;
    private final PedidoRepository pedidoRepository;

    private ItemPedidoId chaveComposta(Long pedidoId, Long produtoId){
        return new ItemPedidoId(pedidoId, produtoId);
    }

    public ItemPedidoService(ItemPedidoRepository repository, ItemPedidoMapper mapper, ProdutoRepository produtoRepository, PedidoRepository pedidoRepository){
        this.repository = repository;
        this.mapper = mapper;
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<ItemPedidoModel> listarItensPedidoId(Long idPedido){
        return repository.findByIdIdPedido(idPedido);
    }


    public ItemPedidoResponseDTO adicionarItem(ItemPedidoCreateDTO itemDTO){
        ItemPedidoModel itemModel = mapper.mapCreate(itemDTO);
        ProdutoModel produtoModel = produtoRepository.getReferenceById(itemDTO.getProduto());
        PedidosModel pedidosModel = pedidoRepository.getReferenceById(itemDTO.getPedido());

        itemModel.setId(chaveComposta(pedidosModel.getId(), produtoModel.getId() ));
        itemModel.setPedido(pedidosModel);
        itemModel.setProduto(produtoModel);
        repository.save(itemModel);
        return mapper.mapResponse(itemModel);
    }

    public ItemPedidoResponseDTO atualizarItem(Long pedidoId,Long produtoId, ItemPedidoUpdateDTO itemDTO) throws EntidadeNaoEncontradaException{
        ItemPedidoModel itemExistente = repository.findById(chaveComposta(pedidoId, produtoId)).orElseThrow(()-> new EntidadeNaoEncontradaException("ID não encontrado!"));
        mapper.mapUpdate(itemExistente, itemDTO);
        repository.save(itemExistente);
        return mapper.mapResponse(itemExistente);
    }

    public void deletarItem(Long pedidoId,Long produtoId ) throws  EntidadeNaoEncontradaException{
        ItemPedidoModel itemExistente = repository.findById(chaveComposta(pedidoId, produtoId)).orElseThrow(()-> new EntidadeNaoEncontradaException("ID não encontrado!"));
        repository.delete(itemExistente);

    }

}
