package projeto.CadastroClientes.ItemPedido;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemPedidoController {

    private final ItemPedidoService service;

    public ItemPedidoController(ItemPedidoService service){
        this.service = service;
    }


    @GetMapping("/listarPorId/{id}")
    public List<ItemPedidoModel> listarPorId(@PathVariable Long id){
        return service.listarItensPedido(id);
    }

    @PostMapping("/adicionarItem")
    public ItemPedidoModel adicionarItem(@RequestBody ItemPedidoModel item){
        return service.adicionarItem(item);
    }
}
