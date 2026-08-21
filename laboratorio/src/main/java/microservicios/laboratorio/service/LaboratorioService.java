package microservicios.laboratorio.service;

import java.util.Map;
import microservicios.laboratorio.model.Laboratorio;

public interface LaboratorioService {
    Laboratorio crearOrden(Laboratorio laboratorio);
    Laboratorio ingresarResultados(String idLaboratorio, Map<String, Object> nuevosResultados);
}