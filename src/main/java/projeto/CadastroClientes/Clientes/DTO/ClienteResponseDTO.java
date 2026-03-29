package projeto.CadastroClientes.Clientes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    private Long id;

    private String nome;

    private String email;

    private Integer idade;

}
