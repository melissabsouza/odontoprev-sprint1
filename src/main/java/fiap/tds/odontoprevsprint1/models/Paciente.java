package fiap.tds.odontoprevsprint1.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "T_CHALLENGE_PACIENTE")
public class Paciente {
    @Id
    @Column(name = "cpf_paciente", unique = true, nullable = false)
    private Long cpf;
    @Column(name = "nome_paciente", length = 100, nullable = false)
    private String nome;
    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;
    @Column(name = "genero_paciente", length = 100, nullable = false)
    private String genero;

    @ManyToOne
    @JoinColumn(name = "cnpj_clinica", referencedColumnName = "cnpj_clinica", nullable = false)
    private Clinica clinica;

    @OneToOne
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco", nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones;
}
