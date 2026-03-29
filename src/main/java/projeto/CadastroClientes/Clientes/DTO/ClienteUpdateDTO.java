package projeto.CadastroClientes.Clientes.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteUpdateDTO {

    @Size(min = 3, max = 12)
    private String nome;

    @Email
    private String email;

    @Min(18)
    private Integer idade;
}
