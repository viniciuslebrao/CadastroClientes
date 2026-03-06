package projeto.CadastroClientes.Produtos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    ProdutoRepository repository;
    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public List<ProdutoModel> exibirProdutos(){
        return repository.findAll();
    }

    public ProdutoModel exibirProdutoId(Long id){
        Optional<ProdutoModel> produtoId = repository.findById(id);
        return produtoId.orElse(null);
    }

    public ProdutoModel inserirProduto(ProdutoModel produto){
        return repository.save(produto);
    }

    public ProdutoModel atualizarProdutoId(Long id, ProdutoModel produto){
        if(!repository.existsById(id)){
            return null;
        }
        produto.setId(id);
        return repository.save(produto);
    }

    public void deletarProdutoId(Long id){
        repository.deleteById(id);
    }

}
