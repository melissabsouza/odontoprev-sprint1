package fiap.tds.odontoprevsprint1.repository;

import fiap.tds.odontoprevsprint1.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByCpf(Long cpf);
}
