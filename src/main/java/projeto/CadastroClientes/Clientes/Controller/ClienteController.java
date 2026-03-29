package projeto.CadastroClientes.Clientes.Controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.CadastroClientes.Clientes.DTO.ClienteCreateDTO;
import projeto.CadastroClientes.Clientes.DTO.ClienteResponseDTO;
import projeto.CadastroClientes.Clientes.DTO.ClienteUpdateDTO;
import projeto.CadastroClientes.Clientes.Service.ClienteService;
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
    @PostMapping()
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@Valid @RequestBody ClienteCreateDTO cliente){
        ClienteResponseDTO clienteDTO = service.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteDTO);
    }

    //localhost:8080/clientes/listarClientePorId/2
    // Procurar cliente por ID(READ)
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarClientePorId(@PathVariable Long id) throws EntidadeNaoEncontradaException {
        ClienteResponseDTO clienteDTO = service.listarClientePorId(id);
        return ResponseEntity.ok(clienteDTO);
    }

    // Mostrar a lista completa de clientes (READ)
    @GetMapping()
    public List<ClienteResponseDTO> listarClientes(){
        return service.listarClientes();
    }

    // Atualizar completamente os dados dos clientes (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizarDadosCliente(@PathVariable Long id, @Valid @RequestBody ClienteUpdateDTO cliente) throws EntidadeNaoEncontradaException{
        ClienteResponseDTO clienteDTOAtualizado = service.atualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteDTOAtualizado);
    }

    // Deletar cliente (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> deletarCliente(@PathVariable Long id) throws EntidadeNaoEncontradaException{

        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
