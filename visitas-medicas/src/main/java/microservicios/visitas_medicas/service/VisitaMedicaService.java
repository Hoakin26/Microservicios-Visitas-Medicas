package microservicios.visitas_medicas.service;

import java.util.List;
import microservicios.visitas_medicas.model.VisitaMedica;

public interface VisitaMedicaService {
    List<VisitaMedica> getAll();
    VisitaMedica getById(Long id);
    VisitaMedica create(VisitaMedica visitaMedica);
    VisitaMedica update(Long id, VisitaMedica visitaMedica);
    void delete(Long id);
}