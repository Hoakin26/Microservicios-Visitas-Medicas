package microservicios.visitas_medicas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamenLaboratorioDTO {
    private Long idVisita;
    private String tipoExamen;

    public ExamenLaboratorioDTO(Long idVisita, String tipoExamen) {
        this.idVisita = idVisita;
        this.tipoExamen = tipoExamen;
    }
}