package com.taxi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="datos_personales")
@Data //genera getter,setter, hashcode, tostring y equals
@NoArgsConstructor   //genera constructor vacio
@AllArgsConstructor
public //genera constructor con todos los atributos
class DatosPersonales {
    @Id
    private String dni;

    private String licencia;

    private String nombre;

    private String apellidos;

}
