package microservicios.laboratorio.service;

import java.util.List;
import java.util.Map;
import microservicios.laboratorio.model.Laboratorio;

public interface LaboratorioService {
    List<Laboratorio> getAll();
    Laboratorio crearOrden(Laboratorio laboratorio);
    Laboratorio ingresarResultados(String idLaboratorio, Map<String, Object> nuevosResultados);
}