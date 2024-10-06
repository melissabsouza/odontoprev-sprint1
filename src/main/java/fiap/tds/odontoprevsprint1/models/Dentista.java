package fiap.tds.odontoprevsprint1.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "T_CHALLENGE_DENTISTA")
public class Dentista {
    @Id
    @Column(name = "cpf_dentista", unique = true, nullable = false)
    private Long cpf;

    @Column(name = "nome_dentista", length = 100, nullable = false)
    private String nome;

    @Column(name = "cro_dentista", length = 100, nullable = false)
    private String cro;

    @Column(name = "especialidade", length = 100, nullable = false)
    private String especialidade;

    @Column(name = "email_dentista", length = 100, nullable = false)
    private String email;

    @Column(name = "data_contratacao", nullable = false)
    private Date dataContratacao;

    @ManyToOne
    @JoinColumn(name = "cnpj_clinica", referencedColumnName = "cnpj_clinica", nullable = false)
    private Clinica clinica;

    @OneToOne
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco", nullable = false)
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "id_telefone", referencedColumnName = "id_telefone")
    private Telefone telefone;


}
