package projeto.CadastroClientes.Produtos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.CadastroClientes.Produtos.Model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
