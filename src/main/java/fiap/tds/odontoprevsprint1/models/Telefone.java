package fiap.tds.odontoprevsprint1.models;

import fiap.tds.odontoprevsprint1.enums.TipoTelefone;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "T_CHALLENGE_TELEFONE")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private Long id;

    @Column(name = "numero_telefone", length = 15, nullable = false)
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_telefone", nullable = false)
    private TipoTelefone tipo;


    @ManyToOne
    @JoinColumn(name = "cnpj_clinica", referencedColumnName = "cnpj_clinica")
    private Clinica clinica;

    @ManyToOne
    @JoinColumn(name = "cpf_paciente", referencedColumnName = "cpf_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "cpf_dentista", referencedColumnName = "cpf_dentista")
    private Dentista dentista;
}
