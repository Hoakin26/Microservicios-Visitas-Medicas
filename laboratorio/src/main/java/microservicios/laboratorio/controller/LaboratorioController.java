package microservicios.laboratorio.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.*;
import microservicios.laboratorio.model.Laboratorio;
import microservicios.laboratorio.service.LaboratorioService;

@RestController
@RequestMapping("/api/laboratorio")
public class LaboratorioController {
    private final LaboratorioService service;

    public LaboratorioController(LaboratorioService service) {
        this.service = service;
    }

    @PostMapping("/ordenes")
    public Laboratorio recibirOrden(@RequestBody Laboratorio laboratorio) {
        return service.crearOrden(laboratorio);
    }

    @PutMapping("/{idLaboratorio}/resultados")
    public Laboratorio cargarResultados(@PathVariable String idLaboratorio, @RequestBody Map<String, Object> nuevosResultados) {
        return service.ingresarResultados(idLaboratorio, nuevosResultados);
    }
}