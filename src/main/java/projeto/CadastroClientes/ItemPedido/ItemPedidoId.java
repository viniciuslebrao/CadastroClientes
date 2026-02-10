package projeto.CadastroClientes.ItemPedido;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemPedidoId {

    private Long idPedido;
    private Long idProduto;



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ItemPedidoId)) {
            return false;
        }
        ItemPedidoId that = (ItemPedidoId) o;
        return Objects.equals(idPedido, that.idPedido) && Objects.equals(idProduto, that.idProduto);
    }

    @Override public int hashCode(){
        return Objects.hash(idPedido, idProduto);
    }
 }


