package fiap.tds.odontoprevsprint1.dto;

import fiap.tds.odontoprevsprint1.enums.StatusUsuario;
import lombok.Data;

@Data
public class UsuarioDTO {
    private int id;
    private String email;
    private String senha;
    private StatusUsuario status;
}
