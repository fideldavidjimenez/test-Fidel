package co.practicalTestFidel.controller;

import co.practicalTestFidel.dto.EncuestaDTO;
import co.practicalTestFidel.dto.LoginDTO;
import co.practicalTestFidel.dto.MarcaDTO;
import co.practicalTestFidel.dto.MessageDTO;
import co.practicalTestFidel.entity.Encuesta;
import co.practicalTestFidel.entity.Marca;
import co.practicalTestFidel.service.EncuestaService;
import co.practicalTestFidel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping(path = "/login")
    public ResponseEntity<Integer> login(@RequestBody LoginDTO aLogin) {

        try {

            Integer idUsuario = this.loginService.autenticar(aLogin.getUsuario(), aLogin.getContrasena());
            return new ResponseEntity<>(idUsuario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(-1, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
