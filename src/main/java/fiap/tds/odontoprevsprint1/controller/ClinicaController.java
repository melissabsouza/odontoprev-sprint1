package fiap.tds.odontoprevsprint1.controller;

import fiap.tds.odontoprevsprint1.dto.ClinicaDTO;
import fiap.tds.odontoprevsprint1.service.ClinicaService;
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
    public ResponseEntity<ClinicaDTO> buscarPorCnpj(@PathVariable Long cnpj) {
        Optional<ClinicaDTO>  clinicaDTO = clinicaService.buscarPorCnpj(cnpj);
        return clinicaDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createClinica(@RequestBody ClinicaDTO clinicaDTO) {
        try {
            ClinicaDTO novaClinica = clinicaService.saveClinica(clinicaDTO);
            return new ResponseEntity<>(novaClinica, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Clínica já existente", HttpStatus.CONFLICT);
        }

    }

}
