package co.edu.uniquindio.notas.modelo;
import java.time.LocalDate;

public class Contacto {
    private int id;
    private String nombre;
    private String correo;
    private String numero;
    private LocalDate fechaNacimiento;

    public Contacto(int id, String nombre, String correo, String numero, LocalDate fechaNacimiento, String apellido, LocalDate fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.numero = numero;
        this.fechaNacimiento = fechaNacimiento;
        this.apellido = apellido;
        this.fechaCreacion = fechaCreacion;
    }

    public static ContactoBuilder builder() {
        return new ContactoBuilder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    private String apellido;
    private LocalDate fechaCreacion;

    //public Nota(String titulo, String descripcion, String categoria) {

    //}



}
