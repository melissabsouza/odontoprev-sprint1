package fiap.tds.odontoprevsprint1.service;

import fiap.tds.odontoprevsprint1.dto.ClinicaDTO;
import fiap.tds.odontoprevsprint1.dto.UsuarioDTO;
import fiap.tds.odontoprevsprint1.models.Clinica;
import fiap.tds.odontoprevsprint1.models.Endereco;
import fiap.tds.odontoprevsprint1.models.Telefone;
import fiap.tds.odontoprevsprint1.models.Usuario;
import fiap.tds.odontoprevsprint1.repository.ClinicaRepository;
import fiap.tds.odontoprevsprint1.repository.EnderecoRepository;
import fiap.tds.odontoprevsprint1.repository.TelefoneRepository;
import fiap.tds.odontoprevsprint1.repository.UsuarioRepository;
import fiap.tds.odontoprevsprint1.service.mapper.ClinicaMapper;
import fiap.tds.odontoprevsprint1.service.mapper.EnderecoMapper;
import fiap.tds.odontoprevsprint1.service.mapper.TelefoneMapper;
import fiap.tds.odontoprevsprint1.service.mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClinicaService {

    private ClinicaRepository clinicaRepository;
    private UsuarioRepository usuarioRepository;
    private EnderecoRepository enderecoRepository;
    private TelefoneRepository telefoneRepository;

    private ClinicaMapper clinicaMapper;
    private UsuarioMapper usuarioMapper;
    private EnderecoMapper enderecoMapper;
    private TelefoneMapper telefoneMapper;

    @Transactional
    public List<ClinicaDTO> getAllClinicas(){
        return clinicaRepository.findAll()
                .stream()
                .map(clinicaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<ClinicaDTO> buscarPorCnpj(Long cnpj){
        return clinicaRepository.findByCnpj(cnpj).map(clinicaMapper::toDto);
    }


    public ClinicaDTO saveClinica(ClinicaDTO clinicaDTO) {
        Optional<Clinica> clinicaExistente = clinicaRepository.findByCnpj(clinicaDTO.getCnpj());
        if (clinicaExistente.isPresent()) {
            throw new IllegalArgumentException("Clínica já existente");
        }

        Usuario usuario = usuarioMapper.toEntity(clinicaDTO.getUsuario());
        Usuario savedUsuario = usuarioRepository.save(usuario);


        Endereco endereco = enderecoMapper.toEntity(clinicaDTO.getEndereco());
        Endereco savedEndereco = enderecoRepository.save(endereco);

        Telefone telefone = telefoneMapper.toEntity(clinicaDTO.getTelefone());
        Telefone savedTelefone = telefoneRepository.save(telefone);


        Clinica clinica = clinicaMapper.toEntity(clinicaDTO);
        clinica.setUsuario(savedUsuario);
        clinica.setEndereco(savedEndereco);
        clinica.setTelefone(savedTelefone);

        Clinica savedClinica = clinicaRepository.save(clinica);
        return clinicaMapper.toDto(savedClinica);
    }
}
