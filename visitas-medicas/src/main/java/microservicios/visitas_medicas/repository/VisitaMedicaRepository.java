package microservicios.visitas_medicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import microservicios.visitas_medicas.model.VisitaMedica;

@Repository
public interface VisitaMedicaRepository extends JpaRepository<VisitaMedica, Long> {

}