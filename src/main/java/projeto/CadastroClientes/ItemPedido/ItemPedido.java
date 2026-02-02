package projeto.CadastroClientes.ItemPedido;

import jakarta.persistence.*;
import projeto.CadastroClientes.Pedidos.PedidosModel;
import projeto.CadastroClientes.Produtos.ProdutoModel;

@Entity
@Table(name = "tb_itemPedido")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoId id;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "pedido_id")
    private PedidosModel pedido;

    private Double precoPedido;
    private Integer quantidadePedido;

    public ItemPedido() {}
}
