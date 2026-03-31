package projeto.CadastroClientes.ItemPedido.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.CadastroClientes.Handler.EntidadeNaoEncontradaException;
import projeto.CadastroClientes.ItemPedido.DTO.ItemPedidoCreateDTO;
import projeto.CadastroClientes.ItemPedido.DTO.ItemPedidoResponseDTO;
import projeto.CadastroClientes.ItemPedido.DTO.ItemPedidoUpdateDTO;
import projeto.CadastroClientes.ItemPedido.Model.ItemPedidoModel;
import projeto.CadastroClientes.ItemPedido.Service.ItemPedidoService;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemPedidoController {

    private final ItemPedidoService service;

    public ItemPedidoController(ItemPedidoService service){
        this.service = service;
    }


    @GetMapping("/pedido/{id}")
    public List<ItemPedidoModel> listarPorPedidoId(@PathVariable Long id){
        return service.listarItensPedidoId(id);
    }

    @PostMapping()
    public ResponseEntity<ItemPedidoResponseDTO> adicionarItem(@RequestBody ItemPedidoCreateDTO item){
        ItemPedidoResponseDTO itemCriado = service.adicionarItem(item);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemCriado);
    }


    @PutMapping("/{pedidoId}/{produtoId}")
    public ResponseEntity<ItemPedidoResponseDTO> atualizarItem(@PathVariable Long pedidoId,@PathVariable Long produtoId, @RequestBody ItemPedidoUpdateDTO itemDTO) throws EntidadeNaoEncontradaException {
        ItemPedidoResponseDTO itemAtualizado = service.atualizarItem(pedidoId,produtoId, itemDTO);
        return ResponseEntity.ok(itemAtualizado);
    }

    @DeleteMapping("/{pedidoId}/{produtoId}")
    public ResponseEntity<ItemPedidoResponseDTO> deletarItem(@PathVariable Long pedidoId, @PathVariable Long produtoId) throws EntidadeNaoEncontradaException{
        service.deletarItem(pedidoId, produtoId);
        return ResponseEntity.noContent().build();
    }

}
