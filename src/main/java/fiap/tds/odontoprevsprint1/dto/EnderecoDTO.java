package fiap.tds.odontoprevsprint1.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EnderecoDTO {
    private Long id;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Long cep;
}
