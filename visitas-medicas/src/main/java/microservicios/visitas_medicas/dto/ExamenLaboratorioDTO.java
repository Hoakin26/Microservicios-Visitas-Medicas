package microservicios.visitas_medicas.dto;

public class ExamenLaboratorioDTO {
    private Long idVisita;
    private String tipoExamen;

    public ExamenLaboratorioDTO(Long idVisita, String tipoExamen) {
        this.idVisita = idVisita;
        this.tipoExamen = tipoExamen;
    }

    public Long getIdVisita(){
        return this.idVisita;
    }
    public void setIdVisita(Long idVisita){
        this.idVisita = idVisita;
    }

    public String getTipoExamen(){
        return this.tipoExamen;
    }
    public void setTipoVisita(String tipoExamen){
        this.tipoExamen = tipoExamen;
    }
}