package fiap.tds.odontoprevsprint1.repository;

import fiap.tds.odontoprevsprint1.models.Clinica;
import fiap.tds.odontoprevsprint1.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClinicaRepository extends JpaRepository<Clinica, Long> {
    Optional<Clinica> findByCnpj(Long cnpj);
}
