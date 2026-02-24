package projeto.CadastroClientes.Pedidos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    //GET -- Requisição para listar Pedidos
    @GetMapping("/listar")
    public String listarPedidos(){
        return "Pedidos listados!";
    }

    @PostMapping("/realizar")
    public String realizarPedido(){
        return "Pedido Realizado!";
    }

    @PutMapping("/alterar")
    public String alterarPedido(){
        return "Pedido atualizado!";
    }

    @DeleteMapping("/deletar")
    public String cancelarPedido(){
        return "Pedido cancelado!";
    }


}
