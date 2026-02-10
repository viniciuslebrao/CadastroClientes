package projeto.CadastroClientes.Clientes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.CadastroClientes.Pedidos.PedidosModel;

import java.util.List;

//Entity tranforma uma classe em uma entidade no DB
@Entity
//Table cria e nomeia a tabela no DB
@Table(name = "tb_cliente")
//Cria um construtor sem argumentos (Construtor vazio)
@NoArgsConstructor
/*
 Cria um contrutor com todos os argumentos (Construtor com todos os atributos da classe)
 Obs: Isso evita a escrita de sobrecarga de construtor, o lombok faz isso automaticamente
*/
@AllArgsConstructor
//@Data pede ao lombok para os getters e setters serem criados
@Data
public class ClienteModel {

    //Id serve para indicar ao compilador que a variável imediatamente abaixo vai ser tradada como ID
    @Id
    //GeneratedValue É a forma como o Java vai criar um ID para o banco de dados, neste caso, de forma sequencial
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Declara que a coluna não pode possuir um valor nulo

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String email;

    private Integer idade;

    //OneToMany- Um Cliente possui vários pedidos | ManyToOne - Um Pedido(ou mais) só pertencem a um único cliente
    @OneToMany(mappedBy = "cliente")
    private List<PedidosModel> pedidos;


}
