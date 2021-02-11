package co.practicalTestFidel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "encuestas", schema = "dev")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Encuesta implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nro_documento")
    private String documento;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "comentarios")
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id")
    private Marca marca;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "id_usuario")
    private Integer usuario;

}
