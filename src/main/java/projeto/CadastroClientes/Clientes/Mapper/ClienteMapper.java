package projeto.CadastroClientes.Clientes.Mapper;

import org.springframework.stereotype.Component;
import projeto.CadastroClientes.Clientes.DTO.ClienteCreateDTO;
import projeto.CadastroClientes.Clientes.DTO.ClienteResponseDTO;
import projeto.CadastroClientes.Clientes.DTO.ClienteUpdateDTO;
import projeto.CadastroClientes.Clientes.Model.ClienteModel;

@Component
public class ClienteMapper {

    public ClienteModel mapCreate(ClienteCreateDTO clienteDTO){
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setNome(clienteDTO.getNome());
        clienteModel.setEmail(clienteDTO.getEmail());
        clienteModel.setIdade(clienteDTO.getIdade());

        return clienteModel;
    }

    public void mapUpdate(ClienteUpdateDTO clienteDTO, ClienteModel model){
        if (clienteDTO.getNome() != null){
            model.setNome(clienteDTO.getNome());
        }
        if(clienteDTO.getEmail() != null){
            model.setEmail(clienteDTO.getEmail());
        }
        if(clienteDTO.getIdade() != null){
            model.setIdade(clienteDTO.getIdade());
        }
    }

    public ClienteResponseDTO mapResponse(ClienteModel clienteModel){
        ClienteResponseDTO clienteDTO = new ClienteResponseDTO();
        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setEmail(clienteModel.getEmail());
        clienteDTO.setIdade(clienteModel.getIdade());

        return clienteDTO;
    }
}

