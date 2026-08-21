package microservicios.visitas_medicas.service;

import microservicios.visitas_medicas.repository.*;
import microservicios.visitas_medicas.model.*;
import java.util.List;

public class VisitaMedicaServiceImpl implements VisitaMedicaService {
    private final VisitaMedicaRepository repo;

    public VisitaMedicaServiceImpl(VisitaMedicaRepository repo) {
        this.repo = repo;
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
}