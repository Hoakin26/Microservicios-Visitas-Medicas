package microservicios.laboratorio.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "laboratorios")
public class Laboratorio {
    @Id
    private String id;
    private Long idVisita; 
    private String tipoExamen;
    private Map<String, Object> resultados; 
    private Double costoExamen;
    private String estado; 

    public Laboratorio() {
    }

    public Laboratorio(String id, Long idVisita, String tipoExamen, Map<String, Object> resultados, Double costoExamen, String estado) {
        this.id = id;
        this.idVisita = idVisita;
        this.tipoExamen = tipoExamen;
        this.resultados = resultados;
        this.costoExamen = costoExamen;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Long idVisita) {
        this.idVisita = idVisita;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public Map<String, Object> getResultados() {
        return resultados;
    }

    public void setResultados(Map<String, Object> resultados) {
        this.resultados = resultados;
    }

    public Double getCostoExamen() {
        return costoExamen;
    }

    public void setCostoExamen(Double costoExamen) {
        this.costoExamen = costoExamen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}