package projeto.CadastroClientes.Clientes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.CadastroClientes.Handler.EntidadeNaoEncontradaException;

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
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO cliente){
        ClienteDTO clienteDTO = service.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteDTO);
    }

    //localhost:8080/clientes/listarClientePorId/2
    // Procurar cliente por ID(READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id) throws EntidadeNaoEncontradaException {
        ClienteDTO clienteDTO = service.listarClientePorId(id);
        return ResponseEntity.ok(clienteDTO);
    }

    // Mostrar a lista completa de clientes (READ)
    @GetMapping("/listar")
    public List<ClienteDTO> listarClientes(){
        return service.listarClientes();
    }

    // Atualizar completamente os dados dos clientes (UPDATE)
    @PutMapping("/atualizacaoCadastro/{id}")
    public ResponseEntity<ClienteDTO> atualizarDadosCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente) throws EntidadeNaoEncontradaException{
        ClienteDTO clienteDTOAtualizado = service.atualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteDTOAtualizado);
    }

    // Deletar cliente (DELETE)
    @DeleteMapping("/deletarPorId/{id}")
    public ResponseEntity<ClienteDTO> deletarCliente(@PathVariable Long id) throws EntidadeNaoEncontradaException{

        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
