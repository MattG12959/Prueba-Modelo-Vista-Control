/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDate;

/**
 *
 * @author matia
 */
public class Alumno {
    private int id = -1;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;

    public Alumno() {
    }
    
    public Alumno(int id, int dni, String apellido, String nombre, LocalDate fechaNacimiento) {
        this.id = id;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Alumno(int dni, String apellido, String nombre, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
}
