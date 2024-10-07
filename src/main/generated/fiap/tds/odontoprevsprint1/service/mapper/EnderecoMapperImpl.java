package fiap.tds.odontoprevsprint1.service.mapper;

import fiap.tds.odontoprevsprint1.dto.EnderecoDTO;
import fiap.tds.odontoprevsprint1.models.Endereco;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-07T08:12:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public EnderecoDTO toDto(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setId( endereco.getId() );
        enderecoDTO.setRua( endereco.getRua() );
        enderecoDTO.setNumero( endereco.getNumero() );
        enderecoDTO.setComplemento( endereco.getComplemento() );
        enderecoDTO.setBairro( endereco.getBairro() );
        enderecoDTO.setCidade( endereco.getCidade() );
        enderecoDTO.setEstado( endereco.getEstado() );
        enderecoDTO.setCep( endereco.getCep() );

        return enderecoDTO;
    }

    @Override
    public Endereco toEntity(EnderecoDTO enderecoDTO) {
        if ( enderecoDTO == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setId( enderecoDTO.getId() );
        endereco.setRua( enderecoDTO.getRua() );
        endereco.setNumero( enderecoDTO.getNumero() );
        endereco.setComplemento( enderecoDTO.getComplemento() );
        endereco.setBairro( enderecoDTO.getBairro() );
        endereco.setCidade( enderecoDTO.getCidade() );
        endereco.setEstado( enderecoDTO.getEstado() );
        endereco.setCep( enderecoDTO.getCep() );

        return endereco;
    }
}
