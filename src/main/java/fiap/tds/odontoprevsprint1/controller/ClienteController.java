package fiap.tds.odontoprevsprint1.controller;

import fiap.tds.odontoprevsprint1.dto.ClinicaDTO;
import fiap.tds.odontoprevsprint1.dto.UsuarioDTO;
import fiap.tds.odontoprevsprint1.service.ClinicaService;
import fiap.tds.odontoprevsprint1.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinicas")
@AllArgsConstructor
public class ClinicaController {
    private final ClinicaService clinicaService;

    @GetMapping
    public ResponseEntity<List<ClinicaDTO>> getAllClinicas() {
        return ResponseEntity.ok(clinicaService.getAllClinicas());
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<UsuarioDTO> buscarPorEmail(@PathVariable String email) {
        Optional<UsuarioDTO>  usuarioDTO = usuarioService.buscarPorEmail(email);
        return usuarioDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            UsuarioDTO novoUsuario = usuarioService.saveUsuario(usuarioDTO);
           return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
       } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Usuario já existente", HttpStatus.CONFLICT);
        }

    }

}
