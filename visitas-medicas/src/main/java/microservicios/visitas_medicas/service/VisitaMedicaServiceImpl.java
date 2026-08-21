package microservicios.visitas_medicas.service;

import microservicios.visitas_medicas.repository.*;
import microservicios.visitas_medicas.dto.ExamenLaboratorioDTO;
import microservicios.visitas_medicas.model.*;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VisitaMedicaServiceImpl implements VisitaMedicaService {
    private final VisitaMedicaRepository repo;
    private final RestTemplate restTemplate;

    private final String URL_LABORATORIO = "http://laboratorio-service:8082/api/laboratorio/ordenes";

    public VisitaMedicaServiceImpl(VisitaMedicaRepository repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }
    
    @Override
    public List<VisitaMedica> getAll() {
        return repo.findAll();
    }

    @Override
    public VisitaMedica getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public VisitaMedica create(VisitaMedica visitaMedica) {
        return repo.save(visitaMedica);
    }

    @Override
    public VisitaMedica update(Long id, VisitaMedica visitaMedica) {
        VisitaMedica existingVisitaMedica = repo.findById(id).orElse(null);
        if (existingVisitaMedica == null) {
            return null;
        }
        existingVisitaMedica.setId_paciente(visitaMedica.getId_paciente());
        existingVisitaMedica.setId_med_general(visitaMedica.getId_med_general());
        existingVisitaMedica.setId_enfermero(visitaMedica.getId_enfermero());
        existingVisitaMedica.setId_med_especialista(visitaMedica.getId_med_especialista());
        existingVisitaMedica.setFecha_solicitud(visitaMedica.getFecha_solicitud());
        existingVisitaMedica.setFecha_cita(visitaMedica.getFecha_cita());
        existingVisitaMedica.setMotivo_consulta(visitaMedica.getMotivo_consulta());
        existingVisitaMedica.setDiagnostico(visitaMedica.getDiagnostico());
        existingVisitaMedica.setObservaciones(visitaMedica.getObservaciones());
        existingVisitaMedica.setEstado(visitaMedica.getEstado());
        existingVisitaMedica.setCosto_consulta(visitaMedica.getCosto_consulta());
        return repo.save(existingVisitaMedica);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void solicitarExamen(Long idVisita, String tipoExamen) {

        VisitaMedica visita = repo.findById(idVisita)
        .orElseThrow(() -> new RuntimeException("La visita médica no existe"));

        ExamenLaboratorioDTO nuevaOrden = new ExamenLaboratorioDTO(idVisita, tipoExamen);

        try {
            ExamenLaboratorioDTO respuesta = restTemplate.postForObject(
                URL_LABORATORIO, 
                nuevaOrden, 
                ExamenLaboratorioDTO.class
            );
            System.out.println("Orden de laboratorio creada exitosamente en MongoDB.");
        } catch (Exception e) {
            System.err.println("Error de comunicación con el microservicio de Laboratorio: " + e.getMessage());
        }
    }
}