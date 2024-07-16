package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Departamento;
import com.example.entities.Empleado;
import com.example.entities.Genero;
import com.example.services.DepartamentoService;
import com.example.services.EmpleadoService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CrudDeEmpleadosConSpringMvcApplication implements CommandLineRunner{

	private final DepartamentoService departamentoService; 
	private final EmpleadoService empleadoService;

	public static void main(String[] args) {
		SpringApplication.run(CrudDeEmpleadosConSpringMvcApplication.class, args);
	}
// el siguiente metodo se ejecuta justo antes de que termine de levantarse el contexto de Spring

	@Override
	public void run(String... args) throws Exception {
	// Agregar registros a las tablas de departamentos y empleados	
	// Primero agregar departamentos
		Departamento dpto1 = Departamento.builder()
		.nombre("RRHH")
		.build();
		Departamento dpto2 = Departamento.builder()
		.nombre("INFORMATICA")
		.build();

		departamentoService.persistirDepartamento(dpto1);
		departamentoService.persistirDepartamento(dpto2);

	// Segundo agregar empleados
	// Empleados del Dpto1	
		Empleado emp11;
		Empleado emp21;

		emp11 = Empleado.builder()
		.nombre("Adrian")
		.primerApellido("Santos")
		.segundoApellido("Gil")
		.salario(2500.00)
		.fechaAlta(LocalDate.of(2015,Month.SEPTEMBER, 1))
		.departamento(departamentoService.getDepartamento(1))
		.genero(Genero.HOMBRE)
		.build();

		
		emp21 = Empleado.builder()
		.nombre("Carlos Andres")
		.primerApellido("Diaz")
		.segundoApellido("Muñoz")
		.salario(2600.00)
		.fechaAlta(LocalDate.of(2010,Month.SEPTEMBER, 1))
		.departamento(departamentoService.getDepartamento(1))
		.genero(Genero.HOMBRE)
		.build();

		// Empleados del Dpto2
Empleado emp12;
Empleado emp22;

emp12 = Empleado.builder()
.nombre("Ivan")
.primerApellido("Santiago")
.segundoApellido("Martinez")
.salario(2400.00)
.fechaAlta(LocalDate.of(2000,Month.SEPTEMBER, 11))
.departamento(departamentoService.getDepartamento(2))
.genero(Genero.OTRO)
.build();


emp22 = Empleado.builder()
.nombre("Jessica Liseth")
.primerApellido("Ysique")
.segundoApellido("Roque")
.salario(2800.00)
.fechaAlta(LocalDate.of(2018,Month.SEPTEMBER, 21))
.departamento(departamentoService.getDepartamento(2))
.genero(Genero.MUJER)
.build();

empleadoService.persistirUpdateEmpleado(emp11);
empleadoService.persistirUpdateEmpleado(emp21);
empleadoService.persistirUpdateEmpleado(emp12);
empleadoService.persistirUpdateEmpleado(emp22);
	}

}

