package fiap.tds.odontoprevsprint1.service.mapper;

import fiap.tds.odontoprevsprint1.dto.AtendimentoDTO;
import fiap.tds.odontoprevsprint1.models.Atendimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AtendimentoMapper {
    AtendimentoDTO toDto(Atendimento atendimento);
    Atendimento toEntity(AtendimentoDTO atendimentoDTO);
}
