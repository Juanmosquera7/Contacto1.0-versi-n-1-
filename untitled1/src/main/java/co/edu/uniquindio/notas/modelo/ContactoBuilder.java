package co.edu.uniquindio.notas.modelo;

import java.time.LocalDate;

public class ContactoBuilder {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String numero;
    private LocalDate fechaNacimiento;
    private LocalDate fechaCreacion;

    public ContactoBuilder() {}

    public ContactoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ContactoBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public ContactoBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public ContactoBuilder numero(String numero) {
        this.numero = numero;
        return this;
    }

    public ContactoBuilder fechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public ContactoBuilder fechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public ContactoBuilder id(int id) {
        this.id = id;
        return this;
    }

    public Contacto build() {
        return new Contacto(id, nombre, correo, numero, fechaNacimiento, apellido, fechaCreacion);
    }
}

