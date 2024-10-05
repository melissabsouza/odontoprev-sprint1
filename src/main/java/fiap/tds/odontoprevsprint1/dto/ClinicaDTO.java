package fiap.tds.odontoprevsprint1.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClinicaDTO {
    private Long cnpj;
    private String nome;
    private UsuarioDTO usuario;
    private EnderecoDTO endereco;
    private List<TelefoneDTO> telefones;
}
