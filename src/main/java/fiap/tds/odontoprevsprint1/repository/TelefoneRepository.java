package fiap.tds.odontoprevsprint1.repository;

import fiap.tds.odontoprevsprint1.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    Optional<Telefone> findById(Long id);
}
