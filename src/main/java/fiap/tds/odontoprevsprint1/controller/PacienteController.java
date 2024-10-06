package fiap.tds.odontoprevsprint1.controller;

import fiap.tds.odontoprevsprint1.dto.ClinicaDTO;
import fiap.tds.odontoprevsprint1.dto.PacienteDTO;
import fiap.tds.odontoprevsprint1.repository.PacienteRepository;
import fiap.tds.odontoprevsprint1.service.PacienteService;
import fiap.tds.odontoprevsprint1.service.mapper.PacienteMapper;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
@AllArgsConstructor
public class PacienteController {


    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        List<PacienteDTO> pacientes = pacienteService.getAllPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping
    public ResponseEntity<?> createPaciente(@RequestBody PacienteDTO pacienteDTO) {
        try {
            PacienteDTO novoPaciente = pacienteService.savePaciente(pacienteDTO);
            return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Paciente já existente", HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PacienteDTO> buscarPorCpf(@PathVariable Long cpf) {
        Optional<PacienteDTO> pacienteDTO = pacienteService.buscarPorCpf(cpf);
        return pacienteDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long cpf) {
        pacienteService.deletePaciente(cpf);
        return ResponseEntity.noContent().build();
    }


}
