package fiap.tds.odontoprevsprint1.dto;

import fiap.tds.odontoprevsprint1.enums.TipoTelefone;
import fiap.tds.odontoprevsprint1.models.Clinica;
import fiap.tds.odontoprevsprint1.models.Dentista;
import fiap.tds.odontoprevsprint1.models.Paciente;
import lombok.Data;

@Data
public class TelefoneDTO {

    private Long id;
    private String numero;
    private TipoTelefone tipo;
}
