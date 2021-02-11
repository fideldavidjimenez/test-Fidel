package co.practicalTestFidel.service;

import co.practicalTestFidel.entity.Encuesta;
import co.practicalTestFidel.entity.Marca;
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
public class EncuestaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private EncuestaRepository encuestaRepository;

    @Transactional
    public Integer save(Encuesta aEncuesta) throws Exception {

        try {

            if (aEncuesta != null) {

                aEncuesta.setFecha(new Date());
                aEncuesta = this.encuestaRepository.save(aEncuesta);
                return aEncuesta.getId();

            } else {
                throw new Exception(Messages.INTERNAL_ERROR);
            }

        } catch (Exception e) {
            throw e;
        }

    }

    @Transactional
    public void delete(Integer aId) throws Exception {

        try {

            if (aId != null) {

                this.encuestaRepository.deleteById(aId);

            } else {
                throw new Exception(Messages.INTERNAL_ERROR);
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public List<Encuesta> list(Integer aUsuario) {

        if (aUsuario != null) {
            return this.encuestaRepository.findEncuestaByUsuario(aUsuario);
        }

        return new ArrayList<>();
    }

    public List<Marca> listMarcas() {

        return this.marcaRepository.findAll();
    }

}
