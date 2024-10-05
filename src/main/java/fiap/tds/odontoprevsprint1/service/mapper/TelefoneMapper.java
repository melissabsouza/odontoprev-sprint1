package fiap.tds.odontoprevsprint1.service.mapper;

import fiap.tds.odontoprevsprint1.dto.EnderecoDTO;
import fiap.tds.odontoprevsprint1.dto.TelefoneDTO;
import fiap.tds.odontoprevsprint1.models.Endereco;
import fiap.tds.odontoprevsprint1.models.Telefone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {
    TelefoneDTO toDto(Telefone telefone);
    Telefone toEntity(TelefoneDTO telefoneDTO);
}
