package projeto.CadastroClientes.ItemPedido;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.CadastroClientes.Pedidos.PedidosModel;
import projeto.CadastroClientes.Produtos.ProdutoModel;

@Entity
@Table(name = "tb_itemPedido")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemPedido {

    @EmbeddedId
    @Column(name = "id")
    private ItemPedidoId id;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "id_produto")
    private ProdutoModel produto;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido")
    private PedidosModel pedido;

    @Column(name = "preco_pedido")
    private Double precoPedido;

    @Column(name = "quantidade_pedido")
    private Integer quantidadePedido;


}
