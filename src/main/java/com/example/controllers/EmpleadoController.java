package com.example.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entities.Departamento;
import com.example.entities.Empleado;
import com.example.services.DepartamentoService;
import com.example.services.EmpleadoService;

import lombok.RequiredArgsConstructor;

// Con esto convertimos la clase en un controler, para recibir peticiones de http
@Controller

// Para mapear, en el navegador haces la petición al pto y si final pones
// empleado, las petciones que reciba
// que termine en empleado vienen aquí ej: http://localhost:8080/empleado
@RequestMapping(value = "/empleado", method = {RequestMethod.POST, RequestMethod.GET})
@RequiredArgsConstructor
public class EmpleadoController {

    private static final Logger LOG = Logger.getLogger("EmpleadoController");
// No se puede modificar porque es final y la hemos hecho estática porque no hace falta crear un objeto para poderla usar
// porque LOG vive en el plano de a clase para poder usarlo.

    // Inyectar como dependencia la capa de servicio:
    private final EmpleadoService empleadoService;
    private final DepartamentoService departamentoService;

    // Metodo donde se delega la petición de mostrar todos lo empleados de la tabla
    // empleados
    // Este metodo devuelve un String que es el nombre de la vista que se mostrará
    // al cliente en el navegador:
    // Model de org.springframework
    // El metodo sabe que va a resolver una petición por ej:
    // (http://localhost:8080/empleado/all) por:
    @GetMapping("/all")
    public String dameTodosLosEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.getEmpleados();

        model.addAttribute("empleados", empleados);

        return "listadoDeEmpleados";
    }

    // Metodo que muestra el formulario de alta de empleado
    @GetMapping("/frmAltaEmpleado")
    public String formlarioAltaEmpleado(Model model) {

        // Hay que enviar a la vista un objeto empleado vacio para que se vincule con
        // los controlers del formulario
        Empleado empleado = new Empleado();

        // También hay que enviar los departamentos
        List<Departamento> departamentos = departamentoService.getDepartamentos();

        model.addAttribute("empleado", empleado);
        model.addAttribute("departamentos", departamentos);

        return "altaModificacionEmpleado";
    }

    // Metodo que recibe por POST los datos de los controlers del formulario de alta
    // de empleado
    @PostMapping("/persistirEmpleado")

// El nombre de este metodo no se usa, lo que se usa es lo que va en PostMapping que va con el de la url
    public String persistir(@ModelAttribute Empleado empleado) {
        empleadoService.persistirUpdateEmpleado(empleado);

        return "redirect:/empleado/all";
    }

// Metodo que muestra el formulario de actualización de un empleado
// Este metodo va a recibir una petición por get por ejemplo frmActualizar/1 y le estoy diciendo que me muestre el 
// formulario que el id es 1
@GetMapping("/frmActualizar/{id}")
    public String formularioActualizacionEmpleado(@PathVariable(name ="id") int idEmpleado, Model model) {

// Con el id del empleado (idEmpleado), solicitamos que nos lo recupere a la capa de servicio de empleado que nos 
        Empleado empleado = empleadoService.getEmpleado(idEmpleado);

        List<Departamento> departamentos = departamentoService.getDepartamentos();

        model.addAttribute("empleado", empleado);
        model.addAttribute("departamentos", departamentos);

        return "altaModificacionEmpleado";

    }

}