package fiap.tds.odontoprevsprint1.repository;

import fiap.tds.odontoprevsprint1.models.Endereco;
import fiap.tds.odontoprevsprint1.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findById(Long id);
}
