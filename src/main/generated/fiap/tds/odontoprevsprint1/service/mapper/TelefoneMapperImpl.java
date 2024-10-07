package fiap.tds.odontoprevsprint1.service.mapper;

import fiap.tds.odontoprevsprint1.dto.TelefoneDTO;
import fiap.tds.odontoprevsprint1.models.Telefone;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-07T08:12:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class TelefoneMapperImpl implements TelefoneMapper {

    @Override
    public TelefoneDTO toDto(Telefone telefone) {
        if ( telefone == null ) {
            return null;
        }

        TelefoneDTO telefoneDTO = new TelefoneDTO();

        telefoneDTO.setId( telefone.getId() );
        telefoneDTO.setNumero( telefone.getNumero() );
        telefoneDTO.setTipo( telefone.getTipo() );

        return telefoneDTO;
    }

    @Override
    public Telefone toEntity(TelefoneDTO telefoneDTO) {
        if ( telefoneDTO == null ) {
            return null;
        }

        Telefone telefone = new Telefone();

        telefone.setId( telefoneDTO.getId() );
        telefone.setNumero( telefoneDTO.getNumero() );
        telefone.setTipo( telefoneDTO.getTipo() );

        return telefone;
    }
}
