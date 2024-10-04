package fiap.tds.odontoprevsprint1.mapper;

import fiap.tds.odontoprevsprint1.dto.UsuarioDTO;
import fiap.tds.odontoprevsprint1.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toDto(Usuario usuario);
    Usuario toEntity(UsuarioDTO usuarioDTO);
}
