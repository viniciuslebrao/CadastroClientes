package projeto.CadastroClientes.ItemPedido;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.CadastroClientes.Pedidos.PedidosModel;
import projeto.CadastroClientes.Produtos.ProdutoModel;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_itemPedido")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemPedidoModel {

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
    private BigDecimal precoPedido;

    @Column(name = "quantidade_pedido")
    private Integer quantidadePedido;


}
