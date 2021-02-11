package co.practicalTestFidel.service;

import co.practicalTestFidel.entity.Encuesta;
import co.practicalTestFidel.entity.Marca;
import co.practicalTestFidel.entity.Usuario;
import co.practicalTestFidel.repository.EncuestaRepository;
import co.practicalTestFidel.repository.MarcaRepository;
import co.practicalTestFidel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Integer autenticar(String aUsuario, String aContrasena) {

        List<Usuario> u = this.usuarioRepository.findUsuario(aUsuario, aContrasena);

        if (u != null && u.isEmpty() == false) {
            return u.get(0).getId();
        }


        return -1;
    }

}
