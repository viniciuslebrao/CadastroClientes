package projeto.CadastroClientes.Pedidos.Controller;

import org.springframework.web.bind.annotation.*;
import projeto.CadastroClientes.Pedidos.Service.PedidoService;
import projeto.CadastroClientes.Pedidos.Model.PedidosModel;

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
    public List<PedidosModel> listarPedidos(){
        return service.consultarPedidos();
    }

    @GetMapping("/{id}")
    public PedidosModel listarPedidoPorId(@PathVariable Long id){
        return service.consultarPedidoId(id);
    }

    @PostMapping()
    public PedidosModel realizarPedido(@RequestBody PedidosModel pedido){
        return service.realizarPedido(pedido);
    }

    @PatchMapping("/{id}")
    public PedidosModel alterarPedido(@PathVariable Long id, @RequestBody PedidosModel pedido){
        return service.atualizarPedidoId(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void cancelarPedido(@PathVariable Long id){
        service.deletarPedido(id);
    }


}
