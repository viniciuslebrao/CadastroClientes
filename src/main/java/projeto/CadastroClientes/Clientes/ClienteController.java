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
    @PostMapping("/cadastroCliente")
    public String cadastrarCliente(){
        return "Cliente cadastrado!";
    }

    // Procurar cliente por ID(READ)
    @GetMapping("/listarClientePorId")
    public String buscarClientePorId() {
        return "ClienteId!";
    }

    // Mostrar a lista completa de clientes (READ)
    @GetMapping("/listar")
    public List<ClienteModel> listarClientes(){
        return service.listarClientes();
    }

    // Atualizar completamente os dados dos clientes (UPDATE)
    @PutMapping("/atualizacaoCadastroClientePorId")
    public String atualizarDadosCliente(){
        return "Cliente atualizado!";
    }
    // Deletar cliente (DELETE)
    @DeleteMapping("/delecaoClientePorId")
    public String deletarCliente(){
        return "Cliente deletado!";
    }

}
