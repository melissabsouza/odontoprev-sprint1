package fiap.tds.odontoprevsprint1.service.mapper;

import fiap.tds.odontoprevsprint1.dto.PacienteDTO;
import fiap.tds.odontoprevsprint1.models.Paciente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteDTO toDto(Paciente paciente);
    Paciente toEntity(PacienteDTO pacienteDTO);
}
