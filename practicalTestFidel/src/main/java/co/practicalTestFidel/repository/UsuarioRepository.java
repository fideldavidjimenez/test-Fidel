package co.practicalTestFidel.repository;

import co.practicalTestFidel.entity.Encuesta;
import co.practicalTestFidel.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.usuario = :usuario and u.contrasena = :contrasena")
    List<Usuario> findUsuario(@Param("usuario") String aUsuario, @Param("contrasena") String aContrasena);

}
