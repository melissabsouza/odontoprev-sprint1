package fiap.tds.odontoprevsprint1.service;

import fiap.tds.odontoprevsprint1.dto.PacienteDTO;
import fiap.tds.odontoprevsprint1.repository.EnderecoRepository;
import fiap.tds.odontoprevsprint1.repository.PacienteRepository;
import fiap.tds.odontoprevsprint1.repository.TelefoneRepository;
import fiap.tds.odontoprevsprint1.repository.UsuarioRepository;
import fiap.tds.odontoprevsprint1.service.mapper.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;
    private UsuarioRepository usuarioRepository;
    private EnderecoRepository enderecoRepository;
    private TelefoneRepository telefoneRepository;

    private PacienteMapper pacienteMapper;
    private UsuarioMapper usuarioMapper;
    private EnderecoMapper enderecoMapper;
    private TelefoneMapper telefoneMapper;


    @Transactional
    public List<PacienteDTO> getAllPacientes() {
        return pacienteRepository.findAll()
                .stream()
                .map(pacienteMapper::toDto)
                .collect(Collectors.toList());
    }


}
