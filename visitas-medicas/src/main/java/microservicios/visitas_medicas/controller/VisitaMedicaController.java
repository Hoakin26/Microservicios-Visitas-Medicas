package microservicios.visitas_medicas.controller;

import org.springframework.web.bind.annotation.*;
import microservicios.visitas_medicas.service.VisitaMedicaService;
import microservicios.visitas_medicas.model.VisitaMedica;
import java.util.List;

@RestController
@RequestMapping("/api/visitas-medicas")
public class VisitaMedicaController {
    private final VisitaMedicaService service;

    public VisitaMedicaController(VisitaMedicaService service) {
        this.service = service;
    }

    @GetMapping
    public List<VisitaMedica> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public VisitaMedica getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public VisitaMedica create(@RequestBody VisitaMedica visitaMedica) {
        return service.create(visitaMedica);
    }

    @PutMapping("/{id}")
    public VisitaMedica update(@PathVariable Long id, @RequestBody VisitaMedica visitaMedica) {
        return service.update(id, visitaMedica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/{idVisita}/solicitar-examen")
    public ResponseEntity<String> solicitarExamenLaboratorio(
            @PathVariable Long idVisita, 
            @RequestParam String tipoExamen) {
        
        service.solicitarExamen(idVisita, tipoExamen);
        return ResponseEntity.ok("Orden enviada exitosamente al laboratorio");
    }
}