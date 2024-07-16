package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dao.EmpleadoDao;
import com.example.entities.Empleado;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
// Cursor en EmpleadoServiceImpl y Quit Fix Add los metodos...
public class EmpleadoServiceImpl implements EmpleadoService {

// Se necesita inyectar el objeto DAO, es decir, una inyección de Dependencia 
// (DI, Dependency Injection) de EmpleadoDao, porque los metodos de la capa de servicio
// se van a implementar a partir de los métodos de la capa DAO

// Una Dependencia se inyecta:
// 1. De forma automática utilizando la anotación @Autowired
// @Autowired
// private EmpleadoDao empleadoDao;

// 2. Por constructor, variante recomendada actualmente
// Queremos tener un objeto de este tipo, (ya no utilizamos el operador new):
private final EmpleadoDao empleadoDao;

// Internamente hace esto:
// public EmpleadoServiceImpl(EmpleadoDao empleadoDao){
//    this.empleadoDao = empleadoDao;

@Override
    public List<Empleado> getEmpleados() {
    return empleadoDao.findAll();   
    }

@Override
    public Empleado getEmpleado(int idEmpleado) {
    Optional<Empleado> optionalEmpleado = empleadoDao.findById(idEmpleado);
        
        if (optionalEmpleado.isPresent())
            return optionalEmpleado.get();
        else
            return null;
}

@Override
    public void persistirUpdateEmpleado(Empleado empleado) {
    empleadoDao.save(empleado);   
    }

@Override
    public void deleteEmpleado(int idEmpleado) {
    empleadoDao.deleteById(idEmpleado);    
    }

}
