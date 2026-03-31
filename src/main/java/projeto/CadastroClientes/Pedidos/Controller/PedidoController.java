package projeto.CadastroClientes.Pedidos.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.CadastroClientes.Handler.EntidadeNaoEncontradaException;
import projeto.CadastroClientes.Pedidos.DTO.PedidoCreateDTO;
import projeto.CadastroClientes.Pedidos.DTO.PedidoUpdateDTO;
import projeto.CadastroClientes.Pedidos.DTO.PedidoResponseDTO;
import projeto.CadastroClientes.Pedidos.Service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service){
        this.service = service;
    }

    //GET -- Requisição para listar Pedidos
    @GetMapping()
    public List<PedidoResponseDTO> listarPedidos(){
        return service.consultarPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> listarPedidoPorId(@PathVariable Long id) throws EntidadeNaoEncontradaException {
        PedidoResponseDTO pedidoResponse = service.consultarPedidoId(id);
        return ResponseEntity.ok(pedidoResponse);
    }

    @PostMapping()
    public ResponseEntity<PedidoResponseDTO> realizarPedido(@RequestBody PedidoCreateDTO pedido){
        PedidoResponseDTO pedidoResponse = service.realizarPedido(pedido);
        return ResponseEntity.status(201).body(pedidoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> alterarPedido(@PathVariable Long id, @RequestBody PedidoUpdateDTO pedido) throws EntidadeNaoEncontradaException{
        PedidoResponseDTO pedidoResponse = service.atualizarPedidoId(id, pedido);
        return ResponseEntity.ok(pedidoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarPedido(@PathVariable Long id) throws EntidadeNaoEncontradaException{
        service.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }


}
