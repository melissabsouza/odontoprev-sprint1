package fiap.tds.odontoprevsprint1.service.mapper;

import fiap.tds.odontoprevsprint1.dto.AtendimentoDTO;
import fiap.tds.odontoprevsprint1.dto.ClinicaDTO;
import fiap.tds.odontoprevsprint1.dto.DentistaDTO;
import fiap.tds.odontoprevsprint1.dto.EnderecoDTO;
import fiap.tds.odontoprevsprint1.dto.PacienteDTO;
import fiap.tds.odontoprevsprint1.dto.TelefoneDTO;
import fiap.tds.odontoprevsprint1.dto.UsuarioDTO;
import fiap.tds.odontoprevsprint1.models.Atendimento;
import fiap.tds.odontoprevsprint1.models.Clinica;
import fiap.tds.odontoprevsprint1.models.Dentista;
import fiap.tds.odontoprevsprint1.models.Endereco;
import fiap.tds.odontoprevsprint1.models.Paciente;
import fiap.tds.odontoprevsprint1.models.Telefone;
import fiap.tds.odontoprevsprint1.models.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-07T08:12:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class AtendimentoMapperImpl implements AtendimentoMapper {

    @Override
    public AtendimentoDTO toDto(Atendimento atendimento) {
        if ( atendimento == null ) {
            return null;
        }

        AtendimentoDTO atendimentoDTO = new AtendimentoDTO();

        atendimentoDTO.setId( atendimento.getId() );
        atendimentoDTO.setTipoProcedimento( atendimento.getTipoProcedimento() );
        atendimentoDTO.setDescricao( atendimento.getDescricao() );
        atendimentoDTO.setDataAtendimento( atendimento.getDataAtendimento() );
        atendimentoDTO.setCustoEstimado( atendimento.getCustoEstimado() );
        atendimentoDTO.setPaciente( pacienteToPacienteDTO( atendimento.getPaciente() ) );
        atendimentoDTO.setDentista( dentistaToDentistaDTO( atendimento.getDentista() ) );

        return atendimentoDTO;
    }

    @Override
    public Atendimento toEntity(AtendimentoDTO atendimentoDTO) {
        if ( atendimentoDTO == null ) {
            return null;
        }

        Atendimento atendimento = new Atendimento();

        atendimento.setId( atendimentoDTO.getId() );
        atendimento.setTipoProcedimento( atendimentoDTO.getTipoProcedimento() );
        atendimento.setDescricao( atendimentoDTO.getDescricao() );
        atendimento.setDataAtendimento( atendimentoDTO.getDataAtendimento() );
        atendimento.setCustoEstimado( atendimentoDTO.getCustoEstimado() );
        atendimento.setPaciente( pacienteDTOToPaciente( atendimentoDTO.getPaciente() ) );
        atendimento.setDentista( dentistaDTOToDentista( atendimentoDTO.getDentista() ) );

        return atendimento;
    }

    protected UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setEmail( usuario.getEmail() );
        usuarioDTO.setSenha( usuario.getSenha() );
        usuarioDTO.setStatus( usuario.getStatus() );

        return usuarioDTO;
    }

    protected EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setId( endereco.getId() );
        enderecoDTO.setRua( endereco.getRua() );
        enderecoDTO.setNumero( endereco.getNumero() );
        enderecoDTO.setComplemento( endereco.getComplemento() );
        enderecoDTO.setBairro( endereco.getBairro() );
        enderecoDTO.setCidade( endereco.getCidade() );
        enderecoDTO.setEstado( endereco.getEstado() );
        enderecoDTO.setCep( endereco.getCep() );

        return enderecoDTO;
    }

    protected TelefoneDTO telefoneToTelefoneDTO(Telefone telefone) {
        if ( telefone == null ) {
            return null;
        }

        TelefoneDTO telefoneDTO = new TelefoneDTO();

        telefoneDTO.setId( telefone.getId() );
        telefoneDTO.setNumero( telefone.getNumero() );
        telefoneDTO.setTipo( telefone.getTipo() );

        return telefoneDTO;
    }

    protected ClinicaDTO clinicaToClinicaDTO(Clinica clinica) {
        if ( clinica == null ) {
            return null;
        }

        ClinicaDTO clinicaDTO = new ClinicaDTO();

        clinicaDTO.setCnpj( clinica.getCnpj() );
        clinicaDTO.setNome( clinica.getNome() );
        clinicaDTO.setUsuario( usuarioToUsuarioDTO( clinica.getUsuario() ) );
        clinicaDTO.setEndereco( enderecoToEnderecoDTO( clinica.getEndereco() ) );
        clinicaDTO.setTelefone( telefoneToTelefoneDTO( clinica.getTelefone() ) );

        return clinicaDTO;
    }

    protected PacienteDTO pacienteToPacienteDTO(Paciente paciente) {
        if ( paciente == null ) {
            return null;
        }

        PacienteDTO pacienteDTO = new PacienteDTO();

        pacienteDTO.setCpf( paciente.getCpf() );
        pacienteDTO.setNome( paciente.getNome() );
        pacienteDTO.setDataNascimento( paciente.getDataNascimento() );
        pacienteDTO.setGenero( paciente.getGenero() );
        pacienteDTO.setClinica( clinicaToClinicaDTO( paciente.getClinica() ) );
        pacienteDTO.setEndereco( enderecoToEnderecoDTO( paciente.getEndereco() ) );
        pacienteDTO.setTelefone( telefoneToTelefoneDTO( paciente.getTelefone() ) );

        return pacienteDTO;
    }

    protected DentistaDTO dentistaToDentistaDTO(Dentista dentista) {
        if ( dentista == null ) {
            return null;
        }

        DentistaDTO dentistaDTO = new DentistaDTO();

        dentistaDTO.setCpf( dentista.getCpf() );
        dentistaDTO.setNome( dentista.getNome() );
        dentistaDTO.setCro( dentista.getCro() );
        dentistaDTO.setEspecialidade( dentista.getEspecialidade() );
        dentistaDTO.setEmail( dentista.getEmail() );
        dentistaDTO.setDataContratacao( dentista.getDataContratacao() );
        dentistaDTO.setClinica( clinicaToClinicaDTO( dentista.getClinica() ) );
        dentistaDTO.setEndereco( enderecoToEnderecoDTO( dentista.getEndereco() ) );
        dentistaDTO.setTelefone( telefoneToTelefoneDTO( dentista.getTelefone() ) );

        return dentistaDTO;
    }

    protected Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( usuarioDTO.getId() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setSenha( usuarioDTO.getSenha() );
        usuario.setStatus( usuarioDTO.getStatus() );

        return usuario;
    }

    protected Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
        if ( enderecoDTO == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setId( enderecoDTO.getId() );
        endereco.setRua( enderecoDTO.getRua() );
        endereco.setNumero( enderecoDTO.getNumero() );
        endereco.setComplemento( enderecoDTO.getComplemento() );
        endereco.setBairro( enderecoDTO.getBairro() );
        endereco.setCidade( enderecoDTO.getCidade() );
        endereco.setEstado( enderecoDTO.getEstado() );
        endereco.setCep( enderecoDTO.getCep() );

        return endereco;
    }

    protected Telefone telefoneDTOToTelefone(TelefoneDTO telefoneDTO) {
        if ( telefoneDTO == null ) {
            return null;
        }

        Telefone telefone = new Telefone();

        telefone.setId( telefoneDTO.getId() );
        telefone.setNumero( telefoneDTO.getNumero() );
        telefone.setTipo( telefoneDTO.getTipo() );

        return telefone;
    }

    protected Clinica clinicaDTOToClinica(ClinicaDTO clinicaDTO) {
        if ( clinicaDTO == null ) {
            return null;
        }

        Clinica clinica = new Clinica();

        clinica.setCnpj( clinicaDTO.getCnpj() );
        clinica.setNome( clinicaDTO.getNome() );
        clinica.setUsuario( usuarioDTOToUsuario( clinicaDTO.getUsuario() ) );
        clinica.setEndereco( enderecoDTOToEndereco( clinicaDTO.getEndereco() ) );
        clinica.setTelefone( telefoneDTOToTelefone( clinicaDTO.getTelefone() ) );

        return clinica;
    }

    protected Paciente pacienteDTOToPaciente(PacienteDTO pacienteDTO) {
        if ( pacienteDTO == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setCpf( pacienteDTO.getCpf() );
        paciente.setNome( pacienteDTO.getNome() );
        paciente.setDataNascimento( pacienteDTO.getDataNascimento() );
        paciente.setGenero( pacienteDTO.getGenero() );
        paciente.setClinica( clinicaDTOToClinica( pacienteDTO.getClinica() ) );
        paciente.setEndereco( enderecoDTOToEndereco( pacienteDTO.getEndereco() ) );
        paciente.setTelefone( telefoneDTOToTelefone( pacienteDTO.getTelefone() ) );

        return paciente;
    }

    protected Dentista dentistaDTOToDentista(DentistaDTO dentistaDTO) {
        if ( dentistaDTO == null ) {
            return null;
        }

        Dentista dentista = new Dentista();

        dentista.setCpf( dentistaDTO.getCpf() );
        dentista.setNome( dentistaDTO.getNome() );
        dentista.setCro( dentistaDTO.getCro() );
        dentista.setEspecialidade( dentistaDTO.getEspecialidade() );
        dentista.setEmail( dentistaDTO.getEmail() );
        dentista.setDataContratacao( dentistaDTO.getDataContratacao() );
        dentista.setClinica( clinicaDTOToClinica( dentistaDTO.getClinica() ) );
        dentista.setEndereco( enderecoDTOToEndereco( dentistaDTO.getEndereco() ) );
        dentista.setTelefone( telefoneDTOToTelefone( dentistaDTO.getTelefone() ) );

        return dentista;
    }
}
