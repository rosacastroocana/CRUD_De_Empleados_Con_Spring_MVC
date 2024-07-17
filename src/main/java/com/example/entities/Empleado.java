package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleados")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    private double salario;
 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;

  // Para que se guarde el nombre en vez del ordinal, sino sería un número  
    @Enumerated(EnumType.STRING)
    private Genero genero;    
 
  // no se puede llamar imagen porque ya se ha llamado así en la vista
    private String foto;

    // Relación con Departamento
    //Un Empleado trabaja en un solo Departamento
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento departamento;

}