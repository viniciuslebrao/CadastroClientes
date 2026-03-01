package projeto.CadastroClientes.Clientes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service){
        this.service = service;
    }

    @GetMapping("/boasvindas")

    public String boasVindas(){
        return "Essa é minha primeira rota!";
    }

    // Adicionar cliente (CREATE)
    @PostMapping("/cadastro")
    public ClienteModel cadastrarCliente(@RequestBody ClienteModel cliente){
        return service.cadastrarCliente(cliente);
    }

    //localhost:8080/clientes/listarClientePorId/2
    // Procurar cliente por ID(READ)
    @GetMapping("/listar/{id}")
    public ClienteModel buscarClientePorId(@PathVariable Long id) {
        return service.listarClientePorId(id);
    }

    // Mostrar a lista completa de clientes (READ)
    @GetMapping("/listar")
    public List<ClienteModel> listarClientes(){
        return service.listarClientes();
    }

    // Atualizar completamente os dados dos clientes (UPDATE)
    @PutMapping("/atualizacaoCadastro")
    public ClienteModel atualizarDadosCliente(@RequestBody ClienteModel cliente){
        return service.atualizarCliente(cliente);
    }

    // Deletar cliente (DELETE)
    @DeleteMapping("/deletarPorId/{id}")
    public void deletarCliente(@PathVariable Long id){
       service.deletarCliente(id);
    }

}
