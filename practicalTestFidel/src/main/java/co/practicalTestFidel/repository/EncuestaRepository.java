package co.practicalTestFidel.repository;

import co.practicalTestFidel.entity.Encuesta;
import co.practicalTestFidel.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EncuestaRepository extends JpaRepository<Encuesta, Integer> {

    /**
     * Consulta encuestas relacionadas a un usuario
     * @param aUsuario
     * @return
     */
    @Query("select c from Encuesta c join fetch c.marca where c.usuario = :usuario order by c.id")
    List<Encuesta> findEncuestaByUsuario(@Param("usuario") Integer aUsuario);

}
