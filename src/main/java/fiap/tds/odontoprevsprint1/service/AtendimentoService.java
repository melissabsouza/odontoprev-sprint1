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

    public Atendimento createAtendimento(AtendimentoDTO atendimentoDTO) {
        Paciente paciente = pacienteRepository.findByCpf(atendimentoDTO.getPaciente().getCpf())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        Dentista dentista = dentistaRepository.findByCpf(atendimentoDTO.getDentista().getCpf())
                .orElseThrow(() -> new EntityNotFoundException("Dentista não encontrado"));


        Atendimento atendimento = atendimentoMapper.toEntity(atendimentoDTO);

        atendimento.setPaciente(paciente);
        atendimento.setDentista(dentista);

        return atendimentoRepository.save(atendimento);
    }

}
