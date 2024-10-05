package fiap.tds.odontoprevsprint1.service.mapper;

import fiap.tds.odontoprevsprint1.dto.ClinicaDTO;
import fiap.tds.odontoprevsprint1.models.Clinica;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClinicaMapper {
    ClinicaDTO toDto(Clinica clinica);
    Clinica toEntity(ClinicaDTO clinicaDTO);
}
