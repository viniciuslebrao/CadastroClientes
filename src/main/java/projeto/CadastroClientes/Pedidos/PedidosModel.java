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

    @PrePersist
    public void prePersist(){
        this.status = StatusPedido.CARRINHO;
        this.dataPedido = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteModel cliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPedido status;

    @Column(name = "data_do_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "data_de_finalizacao")
    private LocalDateTime dataFinalizado;

    @OneToMany(mappedBy = "pedido")
    @JsonIgnore
    private List<ItemPedidoModel> itens;
}


