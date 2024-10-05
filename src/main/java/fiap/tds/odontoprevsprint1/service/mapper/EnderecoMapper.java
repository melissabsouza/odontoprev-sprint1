package fiap.tds.odontoprevsprint1.service.mapper;

import fiap.tds.odontoprevsprint1.dto.ClinicaDTO;
import fiap.tds.odontoprevsprint1.dto.EnderecoDTO;
import fiap.tds.odontoprevsprint1.models.Clinica;
import fiap.tds.odontoprevsprint1.models.Endereco;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoDTO toDto(Endereco endereco);
    Endereco toEntity(EnderecoDTO enderecoDTO);
}
