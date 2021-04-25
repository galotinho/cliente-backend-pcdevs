package br.com.cliente.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cliente.dto.input.ClienteInputDTO;
import br.com.cliente.dto.output.ClienteOutputDTO;
import br.com.cliente.dto.output.ClienteRGOutputDTO;
import br.com.cliente.models.Cliente;

@Component
public class ClienteMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ClienteOutputDTO converterModelParaOutputDTO(Cliente cliente) {
        return modelMapper.map(cliente, ClienteOutputDTO.class);
    }
    
    public ClienteRGOutputDTO converterModelParaRGDTO(Cliente cliente) {
        return modelMapper.map(cliente, ClienteRGOutputDTO.class);
    }
    
    public Cliente converterInputDTOParaModel(ClienteInputDTO clienteInput) {
        return modelMapper.map(clienteInput, Cliente.class);
    }
    
    

//    public Cliente dtoRequestToModel(OfficeRequest request) {
//        return modelMapper.map(request, Cliente.class);
//    }
}