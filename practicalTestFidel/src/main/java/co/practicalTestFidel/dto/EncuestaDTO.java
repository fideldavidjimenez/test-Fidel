package co.practicalTestFidel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncuestaDTO implements Serializable {

    private Integer id;

    private String documento;

    @Email
    private String email;

    private String comentarios;

    private MarcaDTO marca;

    private Date fecha;

    private Integer usuario;

}
