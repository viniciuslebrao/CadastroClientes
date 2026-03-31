package projeto.CadastroClientes.Produtos.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.CadastroClientes.Handler.EntidadeNaoEncontradaException;
import projeto.CadastroClientes.Produtos.DTO.ProdutoCreateDTO;
import projeto.CadastroClientes.Produtos.DTO.ProdutoResponseDTO;
import projeto.CadastroClientes.Produtos.DTO.ProdutoUpdateDTO;
import projeto.CadastroClientes.Produtos.Model.ProdutoModel;
import projeto.CadastroClientes.Produtos.Service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @GetMapping()
    public List<ProdutoResponseDTO> exibirProdutos(){
        return service.exibirProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> exibirProdutoId(@PathVariable Long id) throws EntidadeNaoEncontradaException {
        ProdutoResponseDTO produto = service.exibirProdutoId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping()
    public ResponseEntity<ProdutoResponseDTO> inserirProduto(@RequestBody ProdutoCreateDTO produto){
        ProdutoResponseDTO produtoCriado = service.inserirProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProdutoPorId(@PathVariable Long id, @RequestBody ProdutoUpdateDTO produto) throws EntidadeNaoEncontradaException{
        ProdutoResponseDTO produtoAtualizado = service.atualizarProdutoId(id, produto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutoPorId(@PathVariable Long id) throws EntidadeNaoEncontradaException{
        service.deletarProdutoId(id);
        return ResponseEntity.noContent().build();
    }

}
