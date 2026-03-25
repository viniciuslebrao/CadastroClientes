package projeto.CadastroClientes.Clientes.Mapper;

import org.springframework.stereotype.Component;
import projeto.CadastroClientes.Clientes.DTO.ClienteDTO;
import projeto.CadastroClientes.Clientes.Model.ClienteModel;

@Component
public class ClienteMapper {

    public ClienteModel map(ClienteDTO clienteDTO){
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(clienteDTO.getId());
        clienteModel.setNome(clienteDTO.getNome());
        clienteModel.setEmail(clienteDTO.getEmail());
        clienteModel.setIdade(clienteDTO.getIdade());

        return clienteModel;
    }

    public ClienteDTO map(ClienteModel clienteModel){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setEmail(clienteModel.getEmail());
        clienteDTO.setIdade(clienteModel.getIdade());

        return clienteDTO;
    }
}

