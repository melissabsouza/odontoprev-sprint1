package fiap.tds.odontoprevsprint1.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Entity
@Table(name = "T_CHALLENGE_CLINICA")
public class Clinica {
    @Id
    @Column(name = "cnpj_clinica", unique = true, nullable = false)
    private Long cnpj;

    @Column(name = "nome_clinica", length = 100, nullable = false)
    private String nome;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco", nullable = false)
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "id_telefone", referencedColumnName = "id_telefone")
    private Telefone telefone;


}
