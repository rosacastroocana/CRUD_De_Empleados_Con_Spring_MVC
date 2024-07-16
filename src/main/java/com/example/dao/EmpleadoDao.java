package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Empleado;

// Esta interface tiene los metodos que te da los datos de los empleados
// Lo que estamos haciendo aquí es crear la capa que se va a conectar con la bbdd
// Con Repository le estamos diciendo que aquí hay beans que trabaja con datos y los mete en el contenedor de control de inversion

@Repository
// Se le pasa El Empleado y el tipo de dato del Id de Empleado
public interface EmpleadoDao extends JpaRepository<Empleado, Integer>
 {

}
