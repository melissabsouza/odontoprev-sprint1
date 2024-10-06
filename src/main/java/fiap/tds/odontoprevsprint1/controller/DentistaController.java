package fiap.tds.odontoprevsprint1.controller;

import fiap.tds.odontoprevsprint1.dto.DentistaDTO;
import fiap.tds.odontoprevsprint1.dto.PacienteDTO;
import fiap.tds.odontoprevsprint1.service.DentistaService;
import fiap.tds.odontoprevsprint1.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentistas")
@AllArgsConstructor
public class DentistaController {
    private DentistaService dentistaService;

    @GetMapping
    public ResponseEntity<List<DentistaDTO>> getAllDentistas() {
        List<DentistaDTO> dentistas = dentistaService.getAllDentistas();
        return ResponseEntity.ok(dentistas);
    }

    @PostMapping
    public ResponseEntity<?> createDentista(@RequestBody DentistaDTO dentistaDTO) {
        try {
            DentistaDTO novoDentista = dentistaService.saveDentista(dentistaDTO);
            return new ResponseEntity<>(novoDentista, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Dentista já existente", HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/{cpf}")
    public ResponseEntity<DentistaDTO> buscarPorCpf(@PathVariable Long cpf) {
        Optional<DentistaDTO> dentistaDTO = dentistaService.buscarPorCpf(cpf);
        return dentistaDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> deleteDentista(@PathVariable Long cpf) {
        try {
            dentistaService.deleteDentista(cpf);
            return ResponseEntity.ok("Dentista deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar o Dentista");
        }
    }
}
