package fiap.tds.odontoprevsprint1.controller;

import fiap.tds.odontoprevsprint1.dto.PacienteDTO;
import fiap.tds.odontoprevsprint1.service.PacienteService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@AllArgsConstructor
public class PacienteController {

    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.getAllPacientes());
    }


}
