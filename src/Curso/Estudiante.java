/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

/**
 *
 * @author HP
 */
public class Estudiante {
    private int rut;
    private String nombre;
    private float promedio;

    public Estudiante() {
    }

    public Estudiante(int rut, String nombre, float promedio) {
        this.rut = rut;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "rut: " + this.rut + ", nombre=: " + this.nombre + ", promedio: " + this.promedio + '}';
    }
    
    
    
}
