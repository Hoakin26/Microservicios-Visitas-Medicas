package microservicios.laboratorio.repository;

import microservicios.laboratorio.model.Laboratorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LaboratorioRepository extends MongoRepository<Laboratorio, String> {
    List<Laboratorio> findByIdVisita(Long idVisita); 
}