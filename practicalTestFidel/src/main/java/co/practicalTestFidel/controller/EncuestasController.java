package co.practicalTestFidel.controller;

import co.practicalTestFidel.dto.EncuestaDTO;
import co.practicalTestFidel.dto.MarcaDTO;
import co.practicalTestFidel.entity.Encuesta;
import co.practicalTestFidel.entity.Marca;
import co.practicalTestFidel.service.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EncuestasController {

    @Autowired
    private EncuestaService encuestaService;

    @GetMapping("/marcas")
    public ResponseEntity<List<MarcaDTO>> list() {

        List<MarcaDTO> list = new ArrayList<>();

        for (Marca iMarca : this.encuestaService.listMarcas()) {
            list.add(new MarcaDTO(iMarca.getId(), iMarca.getNombre()));
        }

        return new ResponseEntity<List<MarcaDTO>>(list, HttpStatus.OK);
    }

    @GetMapping("/encuestas/usuario/{idUsuario}")
    public ResponseEntity<List<EncuestaDTO>> list(@PathVariable("idUsuario") Integer idUsuario) {

        List<EncuestaDTO> list = new ArrayList<>();

        for (Encuesta iEncuesta : this.encuestaService.list(idUsuario)) {
            list.add(new EncuestaDTO(iEncuesta.getId(), iEncuesta.getDocumento(), iEncuesta.getEmail(), iEncuesta.getComentarios(), new MarcaDTO(iEncuesta.getMarca().getId(), iEncuesta.getMarca().getNombre()), iEncuesta.getFecha(), iEncuesta.getUsuario()));
        }

        return new ResponseEntity<List<EncuestaDTO>>(list, HttpStatus.OK);
    }

    @PostMapping("/encuestas")
    public ResponseEntity<Integer> createTutorial(@RequestBody EncuestaDTO aEncuesta) {
        try {

            Encuesta encuesta = new Encuesta(null, aEncuesta.getDocumento(), aEncuesta.getEmail(), aEncuesta.getComentarios(), new Marca(aEncuesta.getMarca().getId()), aEncuesta.getFecha(), aEncuesta.getUsuario());
            Integer idEncuesta = this.encuestaService.save(encuesta);

            return new ResponseEntity<>(idEncuesta, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/encuestas/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Integer id) {
        try {
            this.encuestaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
