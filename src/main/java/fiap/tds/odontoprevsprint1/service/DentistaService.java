package fiap.tds.odontoprevsprint1.service;

import fiap.tds.odontoprevsprint1.dto.DentistaDTO;
import fiap.tds.odontoprevsprint1.repository.*;
import fiap.tds.odontoprevsprint1.service.mapper.ClinicaMapper;
import fiap.tds.odontoprevsprint1.service.mapper.EnderecoMapper;
import fiap.tds.odontoprevsprint1.service.mapper.PacienteMapper;
import fiap.tds.odontoprevsprint1.service.mapper.TelefoneMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DentistaService {

    private DentistaRepository dentistaRepository
    private ClinicaRepository clinicaRepository;
    private EnderecoRepository enderecoRepository;
    private TelefoneRepository telefoneRepository;

    private PacienteMapper pacienteMapper;
    private ClinicaMapper clinicaMapper;
    private EnderecoMapper enderecoMapper;
    private TelefoneMapper telefoneMapper;
}
