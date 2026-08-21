package microservicios.laboratorio.service;

import microservicios.laboratorio.model.Laboratorio;
import microservicios.laboratorio.repository.LaboratorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LaboratorioServiceImpl implements LaboratorioService {

    private final LaboratorioRepository repository;

    public LaboratorioServiceImpl(LaboratorioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Laboratorio> getAll() {
        return repository.findAll();
    }

    @Override
    public Laboratorio crearOrden(Laboratorio laboratorio) {
        laboratorio.setEstado("En_Proceso");
        return repository.save(laboratorio);
    }

    @Override
    public Laboratorio ingresarResultados(String idLaboratorio, Map<String, Object> nuevosResultados) {
        Laboratorio laboratorio = repository.findById(idLaboratorio)
            .orElseThrow(() -> new RuntimeException("Examen no encontrado"));
            
        laboratorio.setResultados(nuevosResultados);
        laboratorio.setEstado("Resultados_Listos");
        
        return repository.save(laboratorio);
    }
}