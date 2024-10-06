package fiap.tds.odontoprevsprint1.controller;

import fiap.tds.odontoprevsprint1.dto.AtendimentoDTO;
import fiap.tds.odontoprevsprint1.dto.ClinicaDTO;
import fiap.tds.odontoprevsprint1.dto.DentistaDTO;
import fiap.tds.odontoprevsprint1.service.AtendimentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Atendimentos")
@AllArgsConstructor
public class AtendimentoController {
    private final AtendimentoService atendimentoService;

    @GetMapping
    public ResponseEntity<List<AtendimentoDTO>> getAllAtendimentos() {
        return ResponseEntity.ok(atendimentoService.getAllAtendimentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoDTO> buscarPorId(@PathVariable Long id) {
        Optional<AtendimentoDTO> atendimentoDTO = atendimentoService.buscarPorId(id);
        return atendimentoDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendimento(@PathVariable Long id) {
        atendimentoService.deleteAtendimento(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> createAtendimento(@RequestBody AtendimentoDTO atendimentoDTO) {
        try {
            AtendimentoDTO novoAtendimento = atendimentoService.saveAtendimento(atendimentoDTO);
            return new ResponseEntity<>(novoAtendimento, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Atendimento já existente", HttpStatus.CONFLICT);
        }

    }
}
