package com.taxi.repository;

import com.taxi.entity.DatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Esta interface simula la estructura de la BBDD. Es el repositorio
//Le pasamos la clase DatosPersonales y el tipo de dato de su clave primaria dni
@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales,String>{
    DatosPersonales findByNombre(String nombre);//me trae de la BBDD los datos personales por el Nombre
    boolean existsByNombre(String nombre); //devuelve si este nombre existe en la BBDD


}
