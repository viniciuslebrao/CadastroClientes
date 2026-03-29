package projeto.CadastroClientes.Clientes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCreateDTO {


    private Long id;

    @NotBlank
    @Size(min = 3, max = 12)
    private String nome;

    @Email
    @NotBlank
    private String email;

    @Min(18)
    private Integer idade;

}
