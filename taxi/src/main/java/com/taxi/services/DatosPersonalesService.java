package com.taxi.services;
//ESTO ES LA LOGICA DE NEGOCIO, VAN LOS METODOS Y FUNCIONES

import com.taxi.entity.DatosPersonales;
import com.taxi.repository.DatosPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatosPersonalesService {

    @Autowired//trae el contenido de la interface
    private DatosPersonalesRepository datosPersonalesRepository;

    //Guardar
    public DatosPersonales saveDatosPersonales(DatosPersonales datos){
        return datosPersonalesRepository.save(datos);
    }

    //Buscar usuario
    public DatosPersonales buscarDatosPersonales(String dni){
        //si no haya el id va a devolver null
        DatosPersonales datos=datosPersonalesRepository.findById(dni).orElse(null);
        return datos;
    }

    //Buscar todos los usuarios
    public List<DatosPersonales> listaUsuarios(){
        return datosPersonalesRepository.findAll();
    }

    //Update usuario
    public DatosPersonales updateUsuario(DatosPersonales datos, String id){
        DatosPersonales user2=new DatosPersonales();
        user2=datosPersonalesRepository.findById(id).orElse(null);
        if (user2!=null){
            user2.setNombre(datos.getNombre());
            user2.setApellidos(datos.getApellidos());
            user2.setLicencia(datos.getLicencia());
            return datosPersonalesRepository.save(user2);
        }else return null;
    }

    //Borrar usuario
    public void deleteUser(String dni){
        DatosPersonales datos=datosPersonalesRepository.findById(dni).orElse(null);
        datosPersonalesRepository.delete(datos);
    }
}
