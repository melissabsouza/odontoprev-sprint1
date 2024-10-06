package fiap.tds.odontoprevsprint1.service;

import fiap.tds.odontoprevsprint1.dto.AtendimentoDTO;
import fiap.tds.odontoprevsprint1.dto.ClinicaDTO;
import fiap.tds.odontoprevsprint1.models.*;
import fiap.tds.odontoprevsprint1.repository.AtendimentoRepository;
import fiap.tds.odontoprevsprint1.repository.DentistaRepository;
import fiap.tds.odontoprevsprint1.repository.PacienteRepository;
import fiap.tds.odontoprevsprint1.service.mapper.AtendimentoMapper;
import fiap.tds.odontoprevsprint1.service.mapper.DentistaMapper;
import fiap.tds.odontoprevsprint1.service.mapper.PacienteMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AtendimentoService {
    private AtendimentoRepository atendimentoRepository;
    private PacienteRepository pacienteRepository;
    private DentistaRepository dentistaRepository;

    private AtendimentoMapper atendimentoMapper;
    private PacienteMapper pacienteMapper;
    private DentistaMapper dentistaMapper;

    @Transactional
    public List<AtendimentoDTO> getAllAtendimentos(){
        return atendimentoRepository.findAll()
                .stream()
                .map(atendimentoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<AtendimentoDTO> buscarPorId(Long id){
        return atendimentoRepository.findById(id).map(atendimentoMapper::toDto);
    }

    public void deleteAtendimento(Long id) {
        Optional<Atendimento> atendimentoExistente = atendimentoRepository.findById(id);
        if (atendimentoExistente.isPresent()) {
            atendimentoRepository.delete(atendimentoExistente.get());
        } else {
            throw new IllegalArgumentException("Atendimento não encontrado");
        }
    }

    public AtendimentoDTO saveAtendimento(AtendimentoDTO atendimentoDTO) {
        Optional<Atendimento> atendimentoExistente = atendimentoRepository.findById(atendimentoDTO.getId());
        if (atendimentoExistente.isPresent()) {
            throw new IllegalArgumentException("Atendimento já existente");
        }

        Paciente paciente = pacienteMapper.toEntity(atendimentoDTO.getPaciente());
        Paciente savedPaciente = pacienteRepository.save(paciente);


        Dentista dentista = dentistaMapper.toEntity(atendimentoDTO.getDentista());
        Dentista savedDentista = dentistaRepository.save(dentista);


        Atendimento atendimento = atendimentoMapper.toEntity(atendimentoDTO);
        atendimento.setPaciente(savedPaciente);
        atendimento.setDentista(savedDentista);

        Atendimento savedAtendimento = atendimentoRepository.save(atendimento);
        return atendimentoMapper.toDto(savedAtendimento);
    }

}
