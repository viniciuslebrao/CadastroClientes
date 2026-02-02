package projeto.CadastroClientes.Clientes;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;
import projeto.CadastroClientes.Pedidos.PedidosModel;

import java.util.List;

//Entity tranforma uma classe em uma entidade no DB
@Entity
@Table(name = "tb_cliente")
public class ClienteModel {

    //Id serve para indicar ao compilador que a variável imediatamente abaixo vai ser tradada como ID
    @Id
    //GeneratedValue É a forma como o Java vai criar um ID para o banco de dados, neste caso, de forma sequencial
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String email;
    private Integer idade;

    @OneToMany(mappedBy = "cliente")
    private List<PedidosModel> pedidos;

    public ClienteModel() { }

    public ClienteModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
