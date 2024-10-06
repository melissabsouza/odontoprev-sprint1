package fiap.tds.odontoprevsprint1.repository;

import fiap.tds.odontoprevsprint1.models.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    Optional<Atendimento> findById(Long id);
}
