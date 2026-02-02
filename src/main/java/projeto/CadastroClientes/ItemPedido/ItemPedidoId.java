package projeto.CadastroClientes.ItemPedido;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ItemPedidoId {

    private Long idPedido;
    private Long idProduto;

    public ItemPedidoId() {}

    public ItemPedidoId(Long idPedido, Long idProduto) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

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


