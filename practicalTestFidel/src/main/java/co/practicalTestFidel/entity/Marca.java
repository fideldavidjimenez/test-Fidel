package co.practicalTestFidel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "marcas", schema = "dev")
@Data
@NoArgsConstructor
public class Marca implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    public Marca(Integer id) {
        this.id = id;
    }

}
