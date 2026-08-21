package microservicios.visitas_medicas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;
import lombok.Getter;

@Entity
@Getter
@Setter
public class VisitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long id_paciente;
    public Long id_med_general;
    public Long id_enfermero;
    public Long id_med_especialista;
    public String fecha_solicitud;
    public String fecha_cita;
    public String motivo_consulta;
    public String diagnostico;
    public String observaciones;
    public String estado;
    public Double costo_consulta;
}
