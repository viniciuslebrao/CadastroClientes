package projeto.CadastroClientes.Clientes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {


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
    public String buscarTodosOsClientes(){
        return "Todos os clientes!";
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
