package com.taxi.controler;

import com.taxi.entity.DatosPersonales;
import com.taxi.services.DatosPersonalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CONTROLA LAS PETICIONES Y RESPUESTAS DEL SERVIDOR

@RestController//le digo que esta es la clase de tipo controlador
@RequestMapping("/user")//cuando le ponga "user" va a apuntar hacia ahi
public class DatosPersonalesControler {

    @Autowired
    private DatosPersonalesService datosPersonalesService;

    //Guardar
    //ResonseEntity devuelve si todo ha salido bien
    @PostMapping //es un metodo para guardar
    public ResponseEntity<DatosPersonales>guardarUsuario(@RequestBody DatosPersonales user){
        DatosPersonales user2=datosPersonalesService.saveDatosPersonales(user);
        return ResponseEntity.ok(user);
    }

    //buscar
    @GetMapping("/buscar/{dni}")
    public ResponseEntity<DatosPersonales>buscarUsuario(@PathVariable("dni")String dni){
        DatosPersonales user2=datosPersonalesService.buscarDatosPersonales(dni);
        if (user2==null){
            return ResponseEntity.notFound().build();//si no existe ese usuario que devuelve not found. build contruye la respuesta

        }else{
            return ResponseEntity.ok(user2);
        }
    }

    //Listar todo
    @GetMapping("/all")
    public ResponseEntity<List<DatosPersonales>> listaUsuarios(){
        List<DatosPersonales>lista=datosPersonalesService.listaUsuarios();
        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(lista);
        }
    }
    //Actualizar
    @PutMapping("/update/{dni}")
    public ResponseEntity<DatosPersonales>updateUser(@RequestBody DatosPersonales user,@PathVariable("dni")String dni){
        DatosPersonales user2=datosPersonalesService.updateUsuario(user,dni);
        if (user2==null){
            return ResponseEntity.notFound().build();//si no existe ese usuario que devuelve not found. build contruye la respuesta

        }else{
            return ResponseEntity.ok(user2);
        }
    }
    //Borrar
    @DeleteMapping("/borrar/{dni}")
    public void borrarUser(@PathVariable("dni") String dni){
        datosPersonalesService.deleteUser(dni);

    }
    //
}
