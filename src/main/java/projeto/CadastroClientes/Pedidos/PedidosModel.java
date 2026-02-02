package projeto.CadastroClientes.Pedidos;

import jakarta.persistence.*;
import projeto.CadastroClientes.Clientes.ClienteModel;
import projeto.CadastroClientes.ItemPedido.ItemPedido;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
public class PedidosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    private LocalDateTime dataPedido;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

    public PedidosModel() {}

    public PedidosModel(ClienteModel clienteID, LocalDateTime dataPedido) {
        this.cliente = clienteID;
        this.dataPedido = dataPedido;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }
}
