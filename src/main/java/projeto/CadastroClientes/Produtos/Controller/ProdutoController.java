package projeto.CadastroClientes.Produtos.Controller;

import org.springframework.web.bind.annotation.*;
import projeto.CadastroClientes.Produtos.Model.ProdutoModel;
import projeto.CadastroClientes.Produtos.Service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @GetMapping("/listar")
    public List<ProdutoModel> exibirProdutos(){
        return service.exibirProdutos();
    }

    @GetMapping("/listarPorId/{id}")
    public ProdutoModel exibirProdutoId(@PathVariable Long id){
        return service.exibirProdutoId(id);
    }

    @PostMapping("/inserirProduto")
    public ProdutoModel inserirProduto(@RequestBody ProdutoModel produto){
        return service.inserirProduto(produto);
    }

    @PatchMapping("/atualizarPorId/{id}")
    public ProdutoModel atualizarId(@PathVariable Long id, @RequestBody ProdutoModel produto){
        return service.atualizarProdutoId(id, produto);
    }

    @DeleteMapping("/deletarPorId/{id}")
    public void deletarId(@PathVariable Long id){
        service.deletarProdutoId(id);
    }

}
