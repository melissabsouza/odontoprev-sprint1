package fiap.tds.odontoprevsprint1.repository;

import fiap.tds.odontoprevsprint1.models.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DentistaRepository extends JpaRepository<Dentista, Long> {

    Optional<Dentista> findByCpf(Long cpf);
}
