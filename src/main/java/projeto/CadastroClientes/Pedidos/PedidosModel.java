package projeto.CadastroClientes.Pedidos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.CadastroClientes.Clientes.ClienteModel;
import projeto.CadastroClientes.ItemPedido.ItemPedidoModel;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteModel cliente;

    @Column(name = "data_do_pedido")
    private LocalDateTime dataPedido;

    @OneToMany(mappedBy = "pedido")
    @JsonIgnore
    private List<ItemPedidoModel> itens;
}


