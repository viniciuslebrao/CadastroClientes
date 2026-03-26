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
    @GetMapping("/listar")
    public List<PedidosModel> listarPedidos(){
        return service.consultarPedidos();
    }

    @GetMapping("/listarPorId/{id}")
    public PedidosModel listarPedidoPorId(@PathVariable Long id){
        return service.consultarPedidoId(id);
    }

    @PostMapping("/realizar")
    public PedidosModel realizarPedido(@RequestBody PedidosModel pedido){
        return service.realizarPedido(pedido);
    }

    @PatchMapping("/alterar/{id}")
    public PedidosModel alterarPedido(@PathVariable Long id, @RequestBody PedidosModel pedido){
        return service.atualizarPedidoId(id, pedido);
    }

    @DeleteMapping("/deletar/{id}")
    public void cancelarPedido(@PathVariable Long id){
        service.deletarPedido(id);
    }


}
