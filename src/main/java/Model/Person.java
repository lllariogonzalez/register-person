package Model;

import java.time.LocalDate;

public class Person {
    private final String nombre;
    private final String apellido;
    private final int dni;
    private final LocalDate fechaNacimiento;

    public Person(String nombre, String apellido, int dni, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "DNI: " + dni + "\n" +
                "Fecha de Nacimiento: " + fechaNacimiento + "\n";
    }
}
