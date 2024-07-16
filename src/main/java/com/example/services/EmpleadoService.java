package com.example.services;

import java.util.List;

import com.example.entities.Empleado;

// Metodos para el servicio de empleados (listas)
// El metodo persistir también sabe si se ha modificado un empleado
public interface EmpleadoService {

    public List<Empleado> getEmpleados();
    public Empleado getEmpleado(int idEmpleado);
    public void persistirUpdateEmpleado(Empleado empleado);
    public void deleteEmpleado (int idEmpleado);

}
