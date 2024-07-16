package com.example.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departamentos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Departamento implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    // Las relaciones son bidireccionales
    // Relación con empleados. Un departamento tiene muchos empleados
    // El atributo fetch quiere decir que trae los empleados con carga perezosa (consume menos recursos)
    // mappeddBy (quien) está en el lado de muchos, el padre
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
    private List<Empleado> empleados;
}