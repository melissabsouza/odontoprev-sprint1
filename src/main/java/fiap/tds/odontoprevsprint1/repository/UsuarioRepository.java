package fiap.tds.odontoprevsprint1.repository;

import fiap.tds.odontoprevsprint1.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
     Optional<Usuario> findByEmail(String email);
}
