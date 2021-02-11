package co.practicalTestFidel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDTO implements Serializable {

    private Integer id;

    private String nombre;

    public MarcaDTO(Integer id) {
        this.id = id;
    }

}
