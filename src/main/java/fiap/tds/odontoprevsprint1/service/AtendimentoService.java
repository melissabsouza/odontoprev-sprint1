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

    public void deleteAtendimento(Long cnpj) {
        Optional<Atendimento> atendimentoExistente = atendimentoRepository.findById(id);
        if (atendimentoExistente.isPresent()) {
            atendimentoRepository.delete(atendimentoExistente.get());
        } else {
            throw new IllegalArgumentException("Atendimento não encontrado");
        }
    }

    public ClinicaDTO saveClinica(ClinicaDTO clinicaDTO) {
        Optional<Clinica> clinicaExistente = clinicaRepository.findByCnpj(clinicaDTO.getCnpj());
        if (clinicaExistente.isPresent()) {
            throw new IllegalArgumentException("Clínica já existente");
        }

        Paciente paciente = pacienteMapper.toEntity(atendimentoDTO.getPaciente());
        Paciente savedPaciente = pacienteRepository.save(paciente);


        Endereco endereco = dentistaMapper.toEntity(clinicaDTO.getEndereco());
        Endereco savedEndereco = enderecoRepository.save(endereco);


        Clinica clinica = clinicaMapper.toEntity(clinicaDTO);
        clinica.setUsuario(savedUsuario);
        clinica.setEndereco(savedEndereco);
        clinica.setTelefone(savedTelefone);

        Clinica savedClinica = clinicaRepository.save(clinica);
        return clinicaMapper.toDto(savedClinica);
    }

}








    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_procedimento", length = 100, nullable = false)
    private String tipoProcedimento;

    @Column(name = "descricao_atendimento", length = 150, nullable = false)
    private String descricao;

    @Column(name = "data_atendimento", nullable = false)
    private Date dataAtendimento;

    @Column(name = "custo_estimado", nullable = false)
    private float custoEstimado;

    @OneToOne
    @JoinColumn(name = "cpf_paciente", referencedColumnName = "cpf_paciente", nullable = false)
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "cpf_dentista", referencedColumnName = "cpf_dentista", nullable = false)
    private Dentista dentista;
}
