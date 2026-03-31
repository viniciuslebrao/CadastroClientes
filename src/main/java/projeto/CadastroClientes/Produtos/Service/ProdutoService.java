package projeto.CadastroClientes.Produtos.Service;

import org.springframework.stereotype.Service;
import projeto.CadastroClientes.Handler.EntidadeNaoEncontradaException;
import projeto.CadastroClientes.Produtos.DTO.ProdutoCreateDTO;
import projeto.CadastroClientes.Produtos.DTO.ProdutoResponseDTO;
import projeto.CadastroClientes.Produtos.DTO.ProdutoUpdateDTO;
import projeto.CadastroClientes.Produtos.Mapper.ProdutoMapper;
import projeto.CadastroClientes.Produtos.Model.ProdutoModel;
import projeto.CadastroClientes.Produtos.Repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;
    public ProdutoService(ProdutoRepository repository, ProdutoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ProdutoResponseDTO> exibirProdutos(){
        return repository.findAll().stream().map(mapper::mapResponse).toList();
    }

    public ProdutoResponseDTO exibirProdutoId(Long id) throws EntidadeNaoEncontradaException{
        ProdutoModel produto = repository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("ID não encontrado!"));
        return mapper.mapResponse(produto);
    }

    public ProdutoResponseDTO inserirProduto(ProdutoCreateDTO produto){
        ProdutoModel produtoModel = mapper.mapCreate(produto);
        repository.save(produtoModel);
        return mapper.mapResponse(produtoModel);
    }

    public ProdutoResponseDTO atualizarProdutoId(Long id, ProdutoUpdateDTO produtoDTO) throws EntidadeNaoEncontradaException{
        ProdutoModel produtoExistente = repository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("ID não encontrado"));
        mapper.mapUpdate(produtoExistente, produtoDTO);
        repository.save(produtoExistente);
        return mapper.mapResponse(produtoExistente);
    }

    public void deletarProdutoId(Long id) throws EntidadeNaoEncontradaException{
        ProdutoModel produtoExistente = repository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("ID não encontrado!"));
        repository.delete(produtoExistente);
    }

}
