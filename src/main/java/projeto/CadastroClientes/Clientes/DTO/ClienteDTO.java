package projeto.CadastroClientes.Clientes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {


    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @Min(0)
    private Integer idade;

}
