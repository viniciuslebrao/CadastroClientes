package projeto.CadastroClientes.Produtos.Mapper;

import org.springframework.stereotype.Component;
import projeto.CadastroClientes.Produtos.DTO.ProdutoCreateDTO;
import projeto.CadastroClientes.Produtos.DTO.ProdutoResponseDTO;
import projeto.CadastroClientes.Produtos.DTO.ProdutoUpdateDTO;
import projeto.CadastroClientes.Produtos.Model.ProdutoModel;

@Component
public class ProdutoMapper {

    public ProdutoModel mapCreate(ProdutoCreateDTO produtoDTO){
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNomeProduto(produtoDTO.getNomeProduto());
        produtoModel.setNomeMarca(produtoDTO.getNomeMarca());
        produtoModel.setPreco(produtoDTO.getPreco());
        produtoModel.setQuantidade(produtoDTO.getQuantidade());
        produtoModel.setImagemProduto(produtoDTO.getImagemProduto());

        return produtoModel;
    }

    public void mapUpdate(ProdutoModel produtoModel, ProdutoUpdateDTO produtoDTO){
        if(produtoDTO.getNomeProduto() != null) {
            produtoModel.setNomeProduto(produtoDTO.getNomeProduto());
        }
        if(produtoDTO.getNomeMarca() != null){
            produtoModel.setNomeMarca(produtoDTO.getNomeMarca());
        }
        if(produtoDTO.getPreco() != null){
            produtoModel.setPreco(produtoDTO.getPreco());
        }
        if(produtoDTO.getQuantidade() != null){
            produtoModel.setQuantidade(produtoDTO.getQuantidade());
        }
        if(produtoDTO.getImagemProduto() != null){
            produtoModel.setImagemProduto(produtoDTO.getImagemProduto());
        }
    }

    public ProdutoResponseDTO mapResponse(ProdutoModel produtoModel){
        ProdutoResponseDTO produtoDTO = new ProdutoResponseDTO();
        produtoDTO.setId(produtoModel.getId());
        produtoDTO.setNomeProduto(produtoModel.getNomeProduto());
        produtoDTO.setNomeMarca(produtoModel.getNomeMarca());
        produtoDTO.setPreco(produtoModel.getPreco());
        produtoDTO.setQuantidade(produtoModel.getQuantidade());
        produtoDTO.setImagemProduto(produtoModel.getImagemProduto());

        return produtoDTO;
    }
}
