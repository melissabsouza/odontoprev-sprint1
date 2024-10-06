package fiap.tds.odontoprevsprint1.dto;

import fiap.tds.odontoprevsprint1.models.Clinica;
import fiap.tds.odontoprevsprint1.models.Endereco;
import fiap.tds.odontoprevsprint1.models.Telefone;
import lombok.Data;

import java.util.Date;
@Data
public class PacienteDTO {
    private Long cpf;
    private String nome;
    private Date dataNascimento;
    private String genero;
    private ClinicaDTO clinica;
    private EnderecoDTO endereco;
    private TelefoneDTO telefone;
}
