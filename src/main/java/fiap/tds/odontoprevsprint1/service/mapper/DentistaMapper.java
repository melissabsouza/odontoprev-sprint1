package fiap.tds.odontoprevsprint1.service.mapper;

import fiap.tds.odontoprevsprint1.dto.DentistaDTO;
import fiap.tds.odontoprevsprint1.dto.UsuarioDTO;
import fiap.tds.odontoprevsprint1.models.Dentista;
import fiap.tds.odontoprevsprint1.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DentistaMapper {
    DentistaDTO toDto(Dentista dentista);
    Dentista toEntity(DentistaDTO dentistaDTO);
}
